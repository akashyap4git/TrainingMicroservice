package com.ak4.training.service;

import java.util.List;

import com.ak4.training.model.TrainingDetails;

public interface TrainingService {

	public TrainingDetails serachTrainingBy(String courseName);

	public Long getSkillIdBy(String courseName) throws Exception;

	public List<TrainingDetails> getTrainingDetailsBy(Long skillId);

}
