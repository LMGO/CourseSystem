package com.wanderpoet.experiment.dao;

import com.wanderpoet.experiment.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TeacherDao extends JpaRepository <Teacher, Integer> {

    public Teacher findByTname(String tname);

    public Teacher findByTid(Integer tid);

    public Teacher findByLogintid(String logintid);

    @Query( "select t from Teacher t where t.logintid = ?1")
    public List<Teacher> findTeacher(String logintid);
}
