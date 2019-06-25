package com.wanderpoet.experiment.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *教师信息
 */
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    private String tname;

    private String logintid;

    private String  password;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

    public Teacher() {
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getLogintid() {
        return logintid;
    }

    public void setLogintid(String logintid) {
        this.logintid = logintid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", logintid='" + logintid + '\'' +
                ", password='" + password + '\'' +
                ", courses=" + courses +
                '}';
    }
}

