package com.wanderpoet.experiment.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    private String cname;

    private String  address;

    //与教师有多对一关系
    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "tid", referencedColumnName = "tid")
    private Teacher teacher;

    //与选课表有一对多关系
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "course")
    private Set<Selection> selections = new HashSet<>();

    public Course() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Selection> getSelections() {
        return selections;
    }

    public void setSelections(Set<Selection> selections) {
        this.selections = selections;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", address='" + address + '\'' +
                ", teacher=" + teacher +
                ", selections=" + selections +
                '}';
    }
}
