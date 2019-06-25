package com.wanderpoet.experiment.entity;


import com.wanderpoet.experiment.entity.Course;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;

    private String sname;

    private String gender;

    private String loginsid;

    private String  password;

    //与选课表具有一对多关系
    @OneToMany(cascade = CascadeType.ALL,fetch =  FetchType.EAGER, mappedBy = "student" )
    private Set<Selection> selections = new HashSet<>();

    public Student() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLoginsid() {
        return loginsid;
    }

    public void setLoginsid(String loginsid) {
        this.loginsid = loginsid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Selection> getSelections() {
        return selections;
    }

    public void setSelections(Set<Selection> selections) {
        this.selections = selections;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", loginsid='" + loginsid + '\'' +
                ", password='" + password + '\'' +
                ", selections=" + selections +
                '}';
    }
}
