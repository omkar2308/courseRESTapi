package com.example.courseapi.service;

import com.example.courseapi.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Course getCourse(long corseId) {

        Course c=null;
        for(Course course : list){
            if(course.getId()==corseId){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(e -> {
            if(e.getId()==course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(long corseId) {
     list=this.list.stream().filter(e -> e.getId()!=corseId).collect(Collectors.toList());
    }
}
