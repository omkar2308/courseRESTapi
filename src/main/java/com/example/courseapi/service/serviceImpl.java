package com.example.courseapi.service;

import com.example.courseapi.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class serviceImpl implements CourseService {

    List <Course> list;

    public serviceImpl() {
        list=new ArrayList<>();
        list.add(new Course(111,"java" ,"java courses"));
        list.add(new Course(222,"spring boot" ,"java springboot courses"));
        list.add(new Course(333,"python" ,"python courses"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }
}
