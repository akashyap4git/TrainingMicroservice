package com.ak4.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ak4.training.entity.Skill;

@Repository
public interface SkillDao extends JpaRepository<Skill, Long> {
	
	public Skill findByName(String name);

}
