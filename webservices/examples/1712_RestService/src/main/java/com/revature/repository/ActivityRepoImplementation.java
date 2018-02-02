package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Activity;

public class ActivityRepoImplementation implements ActivityRepo {
	public List<Activity> findAllActivities(){
		List<Activity> activities = new ArrayList<>();
		
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration("50");
		activity1.setId("1234");
		
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setDescription("Running");
		activity2.setDuration("30");
		activity2.setId("2345");
		
		activities.add(activity2);
		return activities;
	}
	
	public String createActivity(String activityid){
		return null;
	}
	
	public Activity findActivity(String activityid){
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration("50");
		activity1.setId("1234");
		return activity1;
	}
}
