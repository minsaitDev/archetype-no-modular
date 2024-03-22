package com.hexagonal.application.usecases;

import com.hexagonal.domain.model.dto.UserDto;
import com.hexagonal.domain.model.dto.request.UserRequest;

import java.util.List;

public interface UserService {
    UserDto createNew(UserRequest request);
    UserDto getById(String id);
    List<UserDto> getAll();
    void deleteById(String id);
    UserDto update(UserRequest request, String id);
    void assignTasks(String id, List<String> tasksIds);

}
