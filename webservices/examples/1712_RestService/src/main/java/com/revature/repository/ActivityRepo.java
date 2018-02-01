package com.revature.repository;

import java.util.List;

import com.revature.model.Activity;

public interface ActivityRepo {

	List<Activity> findAllActivities();

	String createActivity(String activityid);

	Activity findActivity(String activityid);

}