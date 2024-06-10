package com.project.planting_project_startup.repositories;

import com.project.planting_project_startup.entities.UserEntity;
import com.project.planting_project_startup.entities.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByUser(UserEntity user);
}
