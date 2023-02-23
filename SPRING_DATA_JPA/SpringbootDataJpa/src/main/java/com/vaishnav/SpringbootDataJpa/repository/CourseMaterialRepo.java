package com.vaishnav.SpringbootDataJpa.repository;

import com.vaishnav.SpringbootDataJpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepo extends JpaRepository<CourseMaterial,Long> {
}
