package com.wanderpoet.experiment.controller;

import com.wanderpoet.experiment.dao.TeacherDao;
import com.wanderpoet.experiment.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    /*
     * 对教师进行操作
     * */

    @Autowired
    private TeacherDao teacherDao;

    //添加教师
    @PostMapping(value = "/add")
    public Teacher teacherAdd(Teacher teacher){
        return teacherDao.save(teacher);
    }

    //修改教师
    @PutMapping(value = "/update")
    public Teacher teacherUpdate(Teacher teacher){
        if(teacherDao.findById(teacher.getTid()) == null){
            return teacherDao.save(teacher);
        }
        else{
            Teacher teacherBase = teacherDao.findByTid(teacher.getTid());
            if(teacher.getTname() != null)
                teacherBase.setTname(teacher.getTname());
            if(teacher.getLogintid() != null)
                teacherBase.setLogintid(teacher.getLogintid());
            if(teacher.getPassword() != null)
                teacherBase.setPassword(teacher.getPassword());
            return teacherDao.save(teacherBase);
        }
    }

    //删除教师
    @DeleteMapping(value = "/delete/{logintid}")
    public void teacherDelete(@PathVariable("logintid") String logintid){
        teacherDao.deleteById(teacherDao.findByLogintid(logintid).getTid()
        );
    }

    //查询所有教师
    @GetMapping(value = "getall")
    public List<Teacher> getAll(){
        return  teacherDao.findAll();
    }

    //查询一位教师
    @GetMapping(value = "/getone")
    public Teacher getOne(@RequestParam("tid") Integer tid){
        return teacherDao.findByTid(tid);
    }
}
