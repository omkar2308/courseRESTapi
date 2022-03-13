package com.example.courseapi.service;

import com.example.courseapi.entities.Course;
import com.example.courseapi.repository.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class serviceImpl implements CourseService {


    //without DB
    /*List <Course> list;

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
    public Course getCourse(long courseId) {

        Course c=null;
        for(Course course : list){
            if(course.getId()==courseId){
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
    public void deleteCourse(long courseId) {
     list=this.list.stream().filter(e -> e.getId()!=courseId).collect(Collectors.toList());
    }*/

//    with database mysql
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        return courseDao.findById(courseId).get();
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        courseDao.delete(courseDao.getById(courseId));
    }

}
