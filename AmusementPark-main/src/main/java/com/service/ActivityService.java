package com.service;

import java.util.List;

import com.Advices.ActivityNotFoundException;
import com.entity.Activity;

public interface ActivityService {

	 Activity insertActivity(Activity activity);
	 Activity updateActivity(Activity activity) throws  ActivityNotFoundException, Throwable;
	 String deleteActivity(Activity activity);
	 String deleteActivityById(int activityId)  throws  ActivityNotFoundException, Throwable;
	 List<Activity> viewActivitiesOfCharges(float charges);
	 int countActivitiesOfCharges(float charges);
}
