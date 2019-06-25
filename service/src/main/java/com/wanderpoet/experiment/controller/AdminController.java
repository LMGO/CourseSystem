package com.wanderpoet.experiment.controller;

import com.wanderpoet.experiment.dao.CourseDao;
import com.wanderpoet.experiment.dao.StudentDao;
import com.wanderpoet.experiment.dao.TeacherDao;
import com.wanderpoet.experiment.entity.Course;
import com.wanderpoet.experiment.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wanderpoet.experiment.entity.Student;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(value = "/admin")
public class AdminController {


//    @Autowired
//    private StudentDao studentDao;
//
//    @Autowired
//    private CourseDao courseDao;
//
//    @Autowired
//    private TeacherDao teacherDao;


    /*
    * 对学生进行操作
    * */

//    //查询所有学生
//    @GetMapping(value = "/student/getAll")
//    public List<Student> findAllStudent(){
//        return studentDao.findAll();
//   }
//
//    //按名字查询学生
//   @GetMapping("/student/get")
//   public Student findByName(String sname){
//      return studentDao.findBySname(sname);
//  }





}
