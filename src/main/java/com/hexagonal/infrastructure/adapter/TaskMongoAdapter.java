package com.hexagonal.infrastructure.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexagonal.domain.model.Task;
import com.hexagonal.domain.model.constant.TaskConstant;
import com.hexagonal.domain.port.TaskPersistencePort;
import com.hexagonal.infrastructure.adapter.exception.TaskException;
import com.hexagonal.infrastructure.adapter.mapper.TaskDboMapper;
import com.hexagonal.infrastructure.adapter.repository.TaskMongoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Qualifier("taskMongoAdapter")
public class TaskMongoAdapter implements TaskPersistencePort {

	private final TaskMongoRepository taskRepository;
	private final TaskDboMapper taskDboMapper;

	public TaskMongoAdapter(TaskMongoRepository taskRepository, TaskDboMapper taskDboMapper) {
		this.taskRepository = taskRepository;
		this.taskDboMapper = taskDboMapper;
	}

	@Override
	public Task create(Task request) {

		var taskToSave = taskDboMapper.toDboMongo(request);
		var taskSaved = taskRepository.save(taskToSave);

		return taskDboMapper.toDomainMongo(taskSaved);

	}

	@Override
	public Task getById(String id) {
		var optionalTask = taskRepository.findById(id);

		if (optionalTask.isEmpty()) {
			throw new TaskException(HttpStatus.NOT_FOUND, String.format(TaskConstant.TASK_NOT_FOUND_MESSAGE_ERROR, id));
		}

		return taskDboMapper.toDomainMongo(optionalTask.get());
	}

	@Override
	public List<Task> getAll() {
		return taskRepository.findAll().stream().map(taskDboMapper::toDomainMongo).collect(Collectors.toList());
	}

	@Override
	public void deleteById(String id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Task update(Task task) {

		var taskToUpdate = taskDboMapper.toDboMongo(task);
		var taskUpdated = taskRepository.save(taskToUpdate);

		return taskDboMapper.toDomainMongo(taskUpdated);

	}

	@Override
	public List<Task> getByIds(List<String> tasksIds) {

		return taskRepository.findByIdIn(tasksIds).stream().map(taskDboMapper::toDomainMongo).collect(Collectors.toList());

	}

}
