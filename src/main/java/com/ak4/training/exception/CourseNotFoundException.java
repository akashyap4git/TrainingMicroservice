package com.ak4.training.exception;

public class CourseNotFoundException extends Exception {

	private static final long serialVersionUID = 7952004543336583694L;
	
	public CourseNotFoundException(String msg) {
		super(msg);
	}
}
