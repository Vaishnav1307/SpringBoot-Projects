package com.vaishnav.SpringbootDataJpa.Controller;

import com.vaishnav.SpringbootDataJpa.entity.Teacher;
import com.vaishnav.SpringbootDataJpa.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    @Autowired
    private TeacherRepo teacherRepo;

    @PostMapping("/saveteacher")
    public String saveTeacher(@RequestBody Teacher teacher) {
        teacherRepo.save(teacher);
        return "Teacher is saved";
    }
}
