package com.example.courseapi.controller;

import com.example.courseapi.entities.Course;
import com.example.courseapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class controller {
    @Autowired
    public CourseService courseService;
   /* @GetMapping("/home")
    public String home(){
        return "In controller";
    }*/
    @GetMapping("/courses")
    public List<Course> getcourse(){
    return this.courseService.getCourses();
    }
    @GetMapping("/courses/{corseId}")
    public Course getCourses(@PathVariable long corseId){
        return this.courseService.getCourse(corseId);
    }
}
