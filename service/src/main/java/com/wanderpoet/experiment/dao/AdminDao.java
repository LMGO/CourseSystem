package com.wanderpoet.experiment.dao;

import com.wanderpoet.experiment.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AdminDao extends JpaRepository<Admin, Integer> {
      public Admin findByAname(String aname);
}
