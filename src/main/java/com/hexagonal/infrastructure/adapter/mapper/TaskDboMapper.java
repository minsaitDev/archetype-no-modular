package com.hexagonal.infrastructure.adapter.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.domain.model.Task;
import com.hexagonal.infrastructure.adapter.entity.TaskEntity;
import com.hexagonal.infrastructure.adapter.entity.TaskMongoEntity;

@Mapper(componentModel = "spring")
public interface TaskDboMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "completed", target = "completed")
    @Mapping(source = "dateOfCreation", target = "dateOfCreation")
    @Mapping(source = "timeRequiredToComplete", target = "timeRequiredToComplete")
    TaskEntity toDbo(Task domain);
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "completed", target = "completed")
    @Mapping(source = "dateOfCreation", target = "dateOfCreation")
    @Mapping(source = "timeRequiredToComplete", target = "timeRequiredToComplete")
    TaskMongoEntity toDboMongo(Task domain);

    @InheritInverseConfiguration
    Task toDomain(TaskEntity entity);
    
    @InheritInverseConfiguration
    Task toDomainMongo(TaskMongoEntity entity);
}