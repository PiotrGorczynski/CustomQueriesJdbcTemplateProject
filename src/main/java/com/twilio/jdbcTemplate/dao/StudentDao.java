package com.twilio.jdbcTemplate.dao;

import com.twilio.jdbcTemplate.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> findAll();
    int addStudent(Student student);
    Optional<Student> findById(int id);
    int deleteStudent(int id);
    int updateStudent(int id, Student student);

}
