package com.example.courseapi.service;

import com.example.courseapi.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(long corseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public void deleteCourse(long corseId);
}
