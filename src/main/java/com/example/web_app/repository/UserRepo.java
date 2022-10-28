package com.example.web_app.repository;

import com.example.web_app.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository <UserEntity, Long> {
}
