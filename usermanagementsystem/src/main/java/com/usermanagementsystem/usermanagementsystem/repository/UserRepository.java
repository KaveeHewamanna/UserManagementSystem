package com.usermanagementsystem.usermanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagementsystem.usermanagementsystem.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
