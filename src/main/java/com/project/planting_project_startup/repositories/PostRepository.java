package com.project.planting_project_startup.repositories;

import com.project.planting_project_startup.entities.PostEntity;
import com.project.planting_project_startup.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUser(UserEntity user);

    PostEntity findByPostId(Long aLong);
}
