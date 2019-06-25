package com.wanderpoet.experiment.entity;

import javax.persistence.*;

/**
 *
 */
@Entity
public class Selection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String  score;

    //与学生有多对一关系
    @ManyToOne(targetEntity = Student.class)
    //@JoinColumn(name = "sid", referencedColumnName = "sid")
    private Student student;

    //与课程有多对一关系
    @ManyToOne(targetEntity = Course.class)
   // @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Course course;

    public Selection() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Selection{" +
                "id=" + id +
                ", score='" + score + '\'' +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
