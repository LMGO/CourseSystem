package com.wanderpoet.experiment.controller;

import com.wanderpoet.experiment.dao.StudentDao;
import com.wanderpoet.experiment.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    // 添加学生
    @PostMapping(value = "/add")
    public Object studentAdd(Student student) {
       List<Student> list = studentDao.findStudent(student.getLoginsid());


        if(list.size() < 1){
            return studentDao.save(student);
       }
 //      student.setSname(student.getSname());
//       student.setGender(student.getGender());
        else {
            return "123";
        }
    }

    //修改学生
    @PutMapping(value = "/update")
    public Object studentUpdate(Student student){
        List<Student> list = studentDao.findStudent(student.getLoginsid());

        if(list.size() < 1){
            return "1";
        }
        else{
            Student studentBase = studentDao.findByLoginsid(student.getLoginsid());

                studentBase.setSname(student.getSname());

                studentBase.setGender(student.getGender());

                studentBase.setLoginsid(student.getLoginsid());

                studentBase.setPassword(student.getPassword());

            return studentDao.save(studentBase);
        }
    }

    //删除学生
    @DeleteMapping(value = "/delete/{loginsid}")
    public Object studentDelete(@PathVariable("loginsid") String loginsid){
        List<Student> list = studentDao.findStudent(loginsid);

        if(list.size() < 1){
            return "1";
        }
        studentDao.deleteById(studentDao.findByLoginsid(loginsid).getSid());
        return "0";
    }

    //查询所有学生
    @GetMapping(value = "/getAll")
    public List<Student> findAllStudent(){
        return studentDao.findAll();
    }

    //按名字查询学生
    @GetMapping("/get")
    public Student findByName(String sname){
        return studentDao.findBySname(sname);
    }

}
