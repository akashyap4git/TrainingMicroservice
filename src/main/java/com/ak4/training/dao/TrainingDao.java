package com.ak4.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ak4.training.entity.Training;

@Repository
public interface TrainingDao extends JpaRepository<Training, Long> {
	
	public List<Training> findBySkillId(Long skillId);

	public List<Training> findByMentorId(Long mentorId);

}
