package com.example.courseapi.controller;

import com.example.courseapi.entities.Course;
import com.example.courseapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Course> getcourse() {
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{corseId}")
    public Course getCourses(@PathVariable long corseId) {
        return this.courseService.getCourse(corseId);
    }
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
    return  courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{corseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long courseId){
        try {
            this.courseService.deleteCourse((courseId));
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
