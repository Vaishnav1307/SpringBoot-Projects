package com.vaishnav.SpringbootDataJpa.repository;

import com.vaishnav.SpringbootDataJpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Long> {
}
