package com.arxall.tema.demo.elasticsearch.user;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
	    Optional<User> userFromDBOrNot = this.userRepository.findById(user.getId());
		if (userFromDBOrNot.isPresent()) {
		    User userFromDB = userFromDBOrNot.get();
		    userFromDB.setId(user.getId());
		    userFromDB.setUserName(user.getUserName());
		    userFromDB.setSex(user.getSex());
		    userFromDB.setDateOfBirth(user.getDateOfBirth());
		    this.userRepository.save(userFromDB);
		    return userFromDB;
		} else {
		    throw new NoSuchElementException("Record not found with id : " + user.getId());
		}
	}

	@Override
	public Iterable<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User> userOrNot = this.userRepository.findById(id);
		if (userOrNot.isPresent()) {
			return userOrNot.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteUser(long id) {
		this.userRepository.deleteById(id);
	}
}
