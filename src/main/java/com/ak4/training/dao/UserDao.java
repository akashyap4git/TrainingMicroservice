package com.ak4.training.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ak4.training.entity.User;


@Repository
public interface UserDao extends CrudRepository<User, Long> {

    public User findByUserName(String username);
}
