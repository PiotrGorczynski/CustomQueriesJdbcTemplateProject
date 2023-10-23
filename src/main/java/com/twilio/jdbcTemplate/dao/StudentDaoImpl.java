package com.twilio.jdbcTemplate.dao;

import com.twilio.jdbcTemplate.model.Student;
import com.twilio.jdbcTemplate.model.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> findAll() {
        String sql = """
           SELECT id, first_name,last_name,email
           FROM student
           LIMIT 100;
           """;
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }

    @Override
    public Optional<Student> findById(int id) {
        String sql = """
           SELECT id, first_name, last_name, email
           FROM student
           WHERE id = ?;
           """;
        return jdbcTemplate.query(sql,new StudentRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public int addStudent(Student student) {
        String sql = """
           INSERT into student(first_name,last_name,email)
           VALUES (?,?,?);
           """;
        return jdbcTemplate.update(sql, student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }

    @Override
    public int updateStudent(int id, Student student) {
        String sql = """
           UPDATE student
           SET  first_name = ?, last_name = ?, email = ?
           WHERE id = ?;
           """;
        return jdbcTemplate.update(sql,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),id);
    }

    @Override
    public int deleteStudent(int id) {
        String sql = """
           DELETE FROM student
           WHERE id = ?;
           """;
        return jdbcTemplate.update(sql,id);
    }
}
