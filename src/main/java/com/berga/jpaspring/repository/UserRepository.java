package com.berga.jpaspring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berga.jpaspring.model.User;

@Transactional
public interface UserRepository extends JpaRepository<User, String> {

}
