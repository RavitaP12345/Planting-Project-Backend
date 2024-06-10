package com.project.planting_project_startup.repositories;

import com.project.planting_project_startup.entities.LikeDislikeEntity;
import com.project.planting_project_startup.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeDislikeRepository extends JpaRepository<LikeDislikeEntity, Long> {
    List<LikeDislikeEntity> findByPost(PostEntity data);
}
