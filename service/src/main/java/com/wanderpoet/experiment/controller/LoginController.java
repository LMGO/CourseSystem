package com.wanderpoet.experiment.controller;

import com.wanderpoet.experiment.dao.AdminDao;
import com.wanderpoet.experiment.dao.StudentDao;
import com.wanderpoet.experiment.dao.TeacherDao;
import com.wanderpoet.experiment.entity.Admin;
import com.wanderpoet.experiment.entity.Student;
import com.wanderpoet.experiment.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private  TeacherDao teacherDao;

    //管理员登录
    @PostMapping("/adminLogin")
    public String adminLogin(Admin admin){
        Admin adminbase = adminDao.findByAname(admin.getAname());
       if(adminDao.findByAname(admin.getAname()) == null){
           return "1";
       }
       else if((admin.getPassword().equals(adminDao.findByAname(admin.getAname()).getPassword()))){
            return "2";
        }
       else{
           return "3";
       }

    }

    //教师登录
    @PostMapping(value = "/teacherLogin")
    public String teacherLogin(Teacher teacher){
        List<Teacher> list = teacherDao.findTeacher(teacher.getLogintid());

        if(list.size() < 1){
            return "1";
        }else if(teacher.getPassword().equals(teacherDao.findByLogintid(teacher.getLogintid()).getPassword())){
            return "2";
        }
        else {
            return "3";
        }
    }

    //学生登录
    @PostMapping(value = "/studentLogin")
    public String studentLogin(Student student) {

//        JSONObject jsonObject = new JSONObject();
        List<Student> list = studentDao.findStudent(student.getLoginsid());


        if(list.size() < 1){
       // if (studentDao.findByLoginsid(student.getLoginsid()) != null) {
//            jsonObject.put("message", "登陆失败，用户名不存在");
//            return jsonObject;
            return "1";
        } else {
            if (student.getPassword().equals(studentDao.findByLoginsid(student.getLoginsid()).getPassword())) {
//                jsonObject.put("message", "登陆成功");
//                return jsonObject;
                return "2";
            }
            else{
//                jsonObject.put("message", "登陆失败，密码错误";
//                return jsonObject;
                return "3";
            }
        }

    }

}
