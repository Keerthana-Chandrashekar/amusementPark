package com.service;

import java.util.List;

import com.entity.Activity;

public interface ActivityService {

	 Activity insertActivity(Activity activity);
	 Activity updateActivity(Activity activity);
	 String deleteActivity(Activity activity);
	 String deleteActivityById(int activityId);
	 List<Activity> viewActivitiesOfCharges(float charges);
	 int countActivitiesOfCharges(float charges);
}
