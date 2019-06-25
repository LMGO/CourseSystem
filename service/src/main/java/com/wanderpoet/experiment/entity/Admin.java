package com.wanderpoet.experiment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class Admin {

    @Id
    private String aname;

    private String  password;

    public Admin() {
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aname='" + aname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
