package com.hexagonal.application.service;

import com.hexagonal.application.usecases.TaskService;
import com.hexagonal.application.mapper.TaskDtoMapper;
import com.hexagonal.application.mapper.TaskRequestMapper;
import com.hexagonal.domain.model.dto.TaskDto;
import com.hexagonal.domain.model.dto.request.TaskRequest;
import com.hexagonal.domain.port.BookPort;
import com.hexagonal.domain.port.TaskAudioPort;
import com.hexagonal.domain.port.TaskPersistencePort;
import com.hexagonal.infrastructure.adapter.exception.UserException;

import lombok.extern.slf4j.Slf4j;

import com.hexagonal.domain.model.constant.TaskConstant;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TaskManagementService implements TaskService {

	private final TaskPersistencePort taskPersistencePort;
	private final TaskRequestMapper taskRequestMapper;
	private final TaskDtoMapper taskDtoMapper;
	private final TaskAudioPort taskAudioPort;
	private final BookPort bookPort;

	public TaskManagementService(@Qualifier("taskMongoAdapter") final TaskPersistencePort taskPersistencePort,
			final TaskRequestMapper taskRequestMapper, final TaskDtoMapper taskDtoMapper, TaskAudioPort taskAudioPort, final BookPort bookPort) {
		this.taskPersistencePort = taskPersistencePort;
		this.taskRequestMapper = taskRequestMapper;
		this.taskDtoMapper = taskDtoMapper;
		this.taskAudioPort = taskAudioPort;
		this.bookPort = bookPort;
	}

	@Override
	public TaskDto createNew(TaskRequest request) {
		var taskToCreate = taskRequestMapper.toDomain(request);

		var taskCreated = taskPersistencePort.create(taskToCreate);

		var idAudio = taskAudioPort.saveAudio();
		var idBook = bookPort.saveBook();
		log.info("Id audio: " + idAudio);
		log.info("Id Book: " + idBook);
		return taskDtoMapper.toDto(taskCreated);
	}

	@Override
	public TaskDto getById(String id) {
		var task = taskPersistencePort.getById(id);

		return taskDtoMapper.toDto(task);
	}

	@Override
	public List<TaskDto> getAll() {
		var tasks = taskPersistencePort.getAll();
		return tasks.stream().map(taskDtoMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public void deleteById(String id) {
		var task = taskPersistencePort.getById(id);

		if (!task.getUsers().isEmpty()) {
			throw new UserException(HttpStatus.BAD_REQUEST,
					String.format(TaskConstant.CURRENT_TASK_NOT_ALLOW_TO_DELETE, task.getId()));
		}
		taskPersistencePort.deleteById(id);
	}

	@Override
	public TaskDto update(TaskRequest request, String id) {
		var taskToUpdate = taskRequestMapper.toDomain(request);

		taskToUpdate.setName(request.getName());
		taskToUpdate.setDescription(request.getDescription());
		taskToUpdate.setTimeRequiredToComplete(request.getTimeRequiredToComplete());

		var taskUpdated = taskPersistencePort.update(taskToUpdate);

		return taskDtoMapper.toDto(taskUpdated);

	}

}
