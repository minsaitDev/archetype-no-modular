package com.hexagonal.infrastructure.adapter.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.domain.model.User;
import com.hexagonal.infrastructure.adapter.entity.UserEntity;
import com.hexagonal.infrastructure.adapter.entity.UserMongoEntity;

@Mapper(componentModel = "spring")
public interface UserDboMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "country", target = "country")
    UserEntity toDbo(User domain);

    @InheritInverseConfiguration
    User toDomain(UserEntity entity);
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "tasks", target = "taskEntities")
    UserMongoEntity toDboMongo(User domain);

    @InheritInverseConfiguration
    User toDomainMongo(UserMongoEntity entity);
}