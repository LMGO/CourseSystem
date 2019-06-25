package com.wanderpoet.experiment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wanderpoet.experiment.entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;


public interface StudentDao extends JpaRepository<Student, Integer> {

    public Student findBySname(String sname);

    public Student findBySid(Integer sid);

    @Query( "select s from Student s where s.loginsid = ?1")
    public List<Student> findStudent(String loginsid);

    public Student findByLoginsid(String loginsid);
}
