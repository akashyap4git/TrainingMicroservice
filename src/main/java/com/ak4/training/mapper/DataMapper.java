package com.ak4.training.mapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ak4.training.dao.TrainingDao;
import com.ak4.training.dao.UserDao;
import com.ak4.training.entity.Training;
import com.ak4.training.entity.User;
import com.ak4.training.model.TrainingDetails;

@Component
public class DataMapper {
	
	@Autowired
	private UserDao mentorDao;
	
	@Autowired
	private TrainingDao trainingDao;
	
	public TrainingDetails mapFrom(Training training) {
		TrainingDetails td = new TrainingDetails();
		if(training.getProgress() != 0) {
			Optional<User> user = mentorDao.findById(training.getMentorId());
			td.setMentorName(user.get().getFirstName()+" " + user.get().getLastName());
			td.setYearsOfExperience(user.get().getYearsOfExperience());
			List<Training> training2 = trainingDao.findByMentorId(training.getMentorId());
			int count = 0;
			for(Training tr : training2) {
				if(tr.getProgress() == 0) {
					count++;
				}
			}
			td.setNoOfCompletedTraining(count);
			td.setFees(training.getFees()+training.getCommissionAmount());
			td.setRating(training.getRating());
			td.setStartDate(training.getStartDate());
			td.setEndTime(training.getEndDate());
			td.setStartTime(training.getStartTime());
			td.setEndTime(training.getEndTime());
		}
		return td;
	}

}
