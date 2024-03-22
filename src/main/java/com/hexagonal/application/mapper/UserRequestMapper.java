package com.hexagonal.application.mapper;

import com.hexagonal.domain.model.User;
import com.hexagonal.domain.model.dto.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") 
public interface UserRequestMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "country", target = "country")
    User toDomain(UserRequest request);
}
