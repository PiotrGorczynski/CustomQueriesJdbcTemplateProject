package com.twilio.jdbcTemplate;

import com.twilio.jdbcTemplate.dao.StudentDao;
import com.twilio.jdbcTemplate.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {
    private final StudentDao studentDao;

    @Autowired
    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @PostMapping("/add")
    public void addStudent(@Valid @RequestBody Student student){
        studentDao.addStudent(student);
    }
}
