package com.vaishnav.SpringbootDataJpa.repository;

import com.vaishnav.SpringbootDataJpa.entity.Guardian;
import com.vaishnav.SpringbootDataJpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("vabanave@gmail.com")
                .firstName("Vaishnav")
                .lastName("Abanave")
                //.guardianName("Omkar")
                //.guardianEmail("omyaDeshmukh32@gmail.com")
                //.guardianMobile("8237434246")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentsList = studentRepository.findAll();
        System.out.println(studentsList);
    }

    @Test
    public void saveStudentWithGuardianDetails(){
        Guardian guardian = Guardian.builder()
                .email("NanyaIsChapari@gmail.com")
                .name("Nanya")
                .mobileNo("999999999")
                .build();

        Student student = Student.builder()
                .firstName("Chotya")
                .emailId("cabanave@gmail.com")
                .lastName("Abanabve")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
    List<Student> students = studentRepository.findByFirstName("vaishnav");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("vai");
        System.out.println(students);
    }

    @Test
    public void studentBasedOnGuardeanName(){
        List<Student> students = studentRepository.findByGuardianName("nanya");
        System.out.println(students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("vabanave@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentByEmailId(){
        int i = studentRepository.updateStudentByEmailId("Bhau","vabanave@gmail.com");
        System.out.println(i);
    }
}