package com.example.demoRestApp.controllers;

import com.example.demoRestApp.Models.Student;
import com.example.demoRestApp.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //    get all students
    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //    get a student by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") ObjectId id){
        return studentRepository.findBy_id(id);
    }

    //    add a student to data base
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        student.set_id(ObjectId.get());
        return studentRepository.save(student);
    }

    // update student details
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateStudentDetails(@PathVariable("id") ObjectId id, @RequestBody Student student) {
        student.set_id(id);
        studentRepository.save(student);
    }
//
    // delete student records
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable ObjectId id) {
        studentRepository.delete(studentRepository.findBy_id(id));
    }

}
