package com.hexagonal.application.mapper;


import com.hexagonal.domain.model.Task;
import com.hexagonal.domain.model.dto.request.TaskRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") 
public interface TaskRequestMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "timeRequiredToComplete", target = "timeRequiredToComplete")
    Task toDomain(TaskRequest request);

}
