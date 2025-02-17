package com.api.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.model.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

}
