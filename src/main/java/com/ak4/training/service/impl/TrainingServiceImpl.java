package com.ak4.training.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak4.training.dao.SkillDao;
import com.ak4.training.dao.TrainingDao;
import com.ak4.training.entity.Skill;
import com.ak4.training.entity.Training;
import com.ak4.training.exception.CourseNotFoundException;
import com.ak4.training.mapper.DataMapper;
import com.ak4.training.model.TrainingDetails;
import com.ak4.training.service.EMailService;
import com.ak4.training.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	private SkillDao skillDao;
	
	@Autowired
	private TrainingDao trainingDao;
	
	@Autowired
	private DataMapper mapper;
	
	@Autowired
	private EMailService email;

	@Override
	public TrainingDetails serachTrainingBy(String courseName) {
		
		return null;
	}

	@Override
	public Long getSkillIdBy(String courseName) throws Exception {
		Skill skill = skillDao.findByName(courseName);
		if(skill != null) {
			return skill.getId();
		} else {
			throw new CourseNotFoundException("There is no course available named " + courseName);
		}
	}

	@Override
	public List<TrainingDetails> getTrainingDetailsBy(Long skillId) {
		List<Training> trainings = trainingDao.findBySkillId(skillId);
		List<TrainingDetails> trainingDetails = new ArrayList<>();
		for(Training training : trainings) {
			trainingDetails.add(mapper.mapFrom(training));
		}
		return trainingDetails;
	}

	@Override
	public void sendMailBy(String emailId, Boolean b) {
		email.sendEmail(emailId, b);
	}
}
