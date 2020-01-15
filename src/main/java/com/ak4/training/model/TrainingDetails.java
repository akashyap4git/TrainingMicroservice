package com.ak4.training.model;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrainingDetails {
	
	private String mentorName;
	
	private Float yearsOfExperience;
	
	private int noOfCompletedTraining;
	
	private String technology;
		
	private Float fees = 0.0f;
		
	private Integer rating = 0;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String startDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private String endDate;

	@JsonFormat(pattern = "HH:mm:ss")
	private String startTime;

	@JsonFormat(pattern = "HH:mm:ss")
	private String endTime;

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public Float getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public int getNoOfCompletedTraining() {
		return noOfCompletedTraining;
	}

	public void setNoOfCompletedTraining(int noOfCompletedTraining) {
		this.noOfCompletedTraining = noOfCompletedTraining;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Float getFees() {
		return fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
