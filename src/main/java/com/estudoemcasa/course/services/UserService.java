package com.estudoemcasa.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudoemcasa.course.entities.User;
import com.estudoemcasa.course.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
	return repository.findAll();
    }

    public User findById(Long id) {
	Optional<User> obj = repository.findById(id);
	return obj.get();
    }

    /*
     * simple method to save to database
     */
    public User insert(User obj) {
	return repository.save(obj);
    }

    /*
     * simple method to delete from database
     */
    public void delete(Long id) {
	repository.deleteById(id);
    }

    /*
     * simple method to update in database
     */
    public User update(Long id, User obj) {
	User entity = repository.getReferenceById(id);
	updateData(entity, obj);
	return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
	entity.setName(obj.getName());
	entity.setEmail(obj.getEmail());
	entity.setPhone(obj.getPhone());
    }

}
