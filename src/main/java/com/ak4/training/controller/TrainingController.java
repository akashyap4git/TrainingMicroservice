package com.ak4.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/propose") 
	public void propose(@RequestBody TrainingDetails trainingDetails) throws Exception {
		if(trainingDetails == null) {
			throw new Exception("Can not propose without metor name");
		}
		String mentorEmailId = trainingDetails.getMentorEmailId();
		trainingService.sendMailBy(mentorEmailId, null);
	}
	
	@PostMapping("/proposalConfirmed")
	public void proposalConfirmed(String emailId) throws Exception {
		trainingService.sendMailBy(emailId, true);
	}
	
	@PostMapping("/proposalDeclined")
	public void proposalDeclined(String emailId) throws Exception {
		trainingService.sendMailBy(emailId, false);
	}

}
