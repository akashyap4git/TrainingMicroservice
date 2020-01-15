package com.ak4.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak4.training.model.TrainingDetails;
import com.ak4.training.service.TrainingService;

@RestController
public class TrainingController {
	
	@Autowired
	private TrainingService trainingService;
	
	@PostMapping("/search")
	public List<TrainingDetails> search(@RequestBody String courseName) throws Exception {
		
		if(courseName == null) {
			throw new Exception("Please provide course name");
		}
		Long skillId = trainingService.getSkillIdBy(courseName);
		List<TrainingDetails> trainingDetails = trainingService.getTrainingDetailsBy(skillId);
		return trainingDetails;
	}
}
