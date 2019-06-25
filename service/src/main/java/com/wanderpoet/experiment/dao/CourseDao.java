package com.wanderpoet.experiment.dao;

import com.wanderpoet.experiment.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CourseDao extends JpaRepository<Course, Integer>{
   public Course findByCname(String cname);

   public Course findByCid(Integer cid);

   public void deleteByCname(String cname);
//    @Query( "select c from Course c where c.logincid = ?1")
//    public List<Course> findCourse(String logincid);

}
