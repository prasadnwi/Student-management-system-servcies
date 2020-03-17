package com.example.demoRestApp.repository;

import com.example.demoRestApp.Models.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {

    Student findBy_id(ObjectId _id);
}
