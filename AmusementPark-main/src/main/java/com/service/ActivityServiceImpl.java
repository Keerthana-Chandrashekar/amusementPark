package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Advices.ActivityNotFoundException;
import com.entity.Activity;
import com.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {

	private ActivityRepository repo;
	
	@Autowired
	public ActivityServiceImpl(ActivityRepository repo) {
		super();
		this.repo = repo;
	}
	
	// Get the list of activities
	public List<Activity> getAllActivities()
	{
		List<Activity> ls = repo.findAll();
		return ls;
	}
	
	// Add activity
	public Activity insertActivity(Activity a)
	{
		repo.save(a);
		return a;
	}
	
	// Update Activity
	public Activity updateActivity(Activity a)  throws Throwable
	{
		Supplier s1 = () -> new ActivityNotFoundException("Activity not found!");
		int id = a.getActivityId();
		Activity a1 = repo.findById(id).orElseThrow(s1);
		
		a1.setActivityId(a.getActivityId());
		a1.setActivityName(a.getActivityName());
		a1.setDescription(a.getDescription());
		a1.setCharges(a.getCharges());
		
		repo.save(a1);
		return a1;
	}
	
	// Delete Activity
	public String deleteActivity(Activity a)
	{
		repo.delete(a);
		return "Activity deleted !";
	}
	
	// Delete activity by id
	public String deleteActivityById(int activityId) throws Throwable
	{
		Supplier s1 = () -> new ActivityNotFoundException("Activity Could not be deleted ! Please enter a valid ID");
		Activity a = repo.findById(activityId).orElseThrow(s1);
		repo.deleteById(activityId);
		return "Activity deleted !"; 
	}
	
	// Filter activities based on price
	public List<Activity> viewActivitiesOfCharges(float charges)
	{
		List<Activity> activityList = repo.viewActivitiesOfCharges(charges);
		return activityList;
	}
	
	// Find the count of activities based on price
	public int countActivitiesOfCharges(float charges)
	{
		List<Activity> activityList = repo.viewActivitiesOfCharges(charges);
		int count = activityList.size();
		return count;
	}
	
}
