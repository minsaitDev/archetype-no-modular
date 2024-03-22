package com.hexagonal.application.usecases;

import com.hexagonal.domain.model.dto.TaskDto;
import com.hexagonal.domain.model.dto.request.TaskRequest;

import java.util.List;

public interface TaskService {

    TaskDto createNew(TaskRequest request);
    TaskDto getById(String id);
    List<TaskDto> getAll();
    void deleteById(String id);
    TaskDto update(TaskRequest request, String id);

}
