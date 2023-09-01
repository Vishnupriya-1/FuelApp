package com.test.fuelApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.fuelApp.model.DAOUser;

public interface UserDao extends JpaRepository<DAOUser, Integer> {
	DAOUser findByUsername(String username);
}