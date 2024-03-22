package com.hexagonal.infrastructure.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexagonal.domain.model.User;
import com.hexagonal.domain.model.constant.UserConstant;
import com.hexagonal.domain.port.UserPersistencePort;
import com.hexagonal.infrastructure.adapter.exception.UserException;
import com.hexagonal.infrastructure.adapter.mapper.UserDboMapper;
import com.hexagonal.infrastructure.adapter.repository.UserMongoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserMongoAdapter implements UserPersistencePort {

	private final UserMongoRepository userRepository;
	private final UserDboMapper userDboMapper;

	public UserMongoAdapter(UserMongoRepository userRepository, UserDboMapper userDboMapper) {
		this.userRepository = userRepository;
		this.userDboMapper = userDboMapper;
	}

	@Override
	public User create(User user) {
		var userToSave = userDboMapper.toDboMongo(user);
		var userSaved = userRepository.save(userToSave);
		return userDboMapper.toDomainMongo(userSaved);
	}

	@Override
	public User getById(String id) {

		var optionalUser = userRepository.findById(id);

		if (optionalUser.isEmpty()) {
			throw new UserException(HttpStatus.NOT_FOUND, String.format(UserConstant.TASK_NOT_FOUND_MESSAGE_ERROR, id));
		}

		return userDboMapper.toDomainMongo(optionalUser.get());
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll().stream().map(userDboMapper::toDomainMongo).collect(Collectors.toList());
	}

	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public User update(User user) {

		var userToUpdate = userDboMapper.toDboMongo(user);
		var userUpdated = userRepository.save(userToUpdate);

		return userDboMapper.toDomainMongo(userUpdated);
	}
}
