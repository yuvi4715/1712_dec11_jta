package com.revature.repository;

import java.util.List;

import com.revature.model.Activity;

public interface ActivityRepo {

	List<Activity> findAllActivities();

	public void createActivity(Activity activity);

	Activity findActivity(String activityid);

}