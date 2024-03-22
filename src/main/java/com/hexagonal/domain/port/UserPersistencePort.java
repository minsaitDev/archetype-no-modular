package com.hexagonal.domain.port;

import java.util.List;

import com.hexagonal.domain.model.User;

public interface UserPersistencePort {

    User create(User user);
    User getById(String id);
    List<User> getAll();
    void deleteById(String id);
    User update(User user);

}
