package com.wanderpoet.experiment.dao;

import com.wanderpoet.experiment.entity.Selection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectionDao extends JpaRepository<Selection, Integer> {
        public Selection findByid(Integer id);
}
