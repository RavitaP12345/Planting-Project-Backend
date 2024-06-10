package com.project.planting_project_startup.repositories;

import com.project.planting_project_startup.entities.CommentEntity;
import com.project.planting_project_startup.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByPost(PostEntity data);
}
