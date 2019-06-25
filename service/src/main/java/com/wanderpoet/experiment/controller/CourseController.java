package com.wanderpoet.experiment.controller;

import com.wanderpoet.experiment.dao.CourseDao;
import com.wanderpoet.experiment.dao.SelectionDao;
import com.wanderpoet.experiment.dao.StudentDao;
import com.wanderpoet.experiment.entity.Course;
import com.wanderpoet.experiment.entity.Selection;
import com.wanderpoet.experiment.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private SelectionDao selectionDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private  StudentDao studentDao;

    //学生选课
    @PostMapping(value = "/student/add/")
    public Selection selectCourse(@RequestParam("cname") String cname,@RequestParam("loginsid") String loginsid){

        //courseDao.findByCname(cname).getCid();
      //  studentDao.findByLoginsid(loginsid).getSid();
        Selection selection = new Selection();
        selection.setCourse(courseDao.findByCname(cname));
        selection.setStudent(studentDao.findByLoginsid(loginsid));

        return selectionDao.save(selection);
    }

    //学生退课
    @DeleteMapping(value = "/student/delete")
    public void dropCourse(Selection selection){
        selectionDao.delete(selection);
    }

    //老师选课
    @PostMapping(value = "/teacher/add")
    public void selectCourse(Teacher teacher, Course course){

             course.setTeacher(teacher);
    }

    //老师退课
    @DeleteMapping(value = "/teacher/delete")
    public void dropCourse(Course course){
        courseDao.delete(course);
    }

    //评分
    @PutMapping(value = "grade")
    public Selection grade(Selection selection){

        Selection selectionBase = selectionDao.findByid(selection.getId());
        selectionBase.setScore(selection.getScore());
        return selectionDao.save(selectionBase);

    }


    /*
     * 对课程进行操作
     * */

    //添加课程
    @PostMapping(value = "/add")
    public Course cuurseAdd(Course course){

        return courseDao.save(course);
    }

    //修改课程
    @PutMapping(value = "/update")
    public Course courseUpdate(Course course){
        if(courseDao.findById(course.getCid()) == null){
            return courseDao.save(course);
        }
        else{
            Course courseBase = courseDao.findByCid(course.getCid());
            if(course.getCname() != null)
                courseBase.setCname(course.getCname());
            if(course.getAddress() != null)
                courseBase.setAddress(course.getAddress());
            return courseDao.save(courseBase);
        }
    }

    //删除课程
    @DeleteMapping(value = "/delete/{cname}")
    public String courseDelete(@PathVariable("cname") String cname){

        courseDao.deleteById(courseDao.findByCname(cname).getCid());

        return "1";
    }

    //查询一门课程
    @GetMapping(value = "getone")
    public Course findOne(@RequestParam("cid") Integer cid){
        return courseDao.findByCid(cid);
    }

    //查询所有课程
    @GetMapping(value = "getall")
    public List<Course> getAll(){
        return  courseDao.findAll();
    }


}
