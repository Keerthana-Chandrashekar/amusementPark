package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Activity;
import com.service.ActivityServiceImpl;

@RestController
@RequestMapping(path = "/api")
public class ActivityController {

	@Autowired
	ActivityServiceImpl activityservice;
	
	// Get list of all activities
	@GetMapping(path="/getAllActivity")
	public List<Activity> getAllActivities()
	{
		List<Activity> activityList = activityservice.getAllActivities();
		return activityList;
	}
	
	// Get list of activities by charges
	@GetMapping(path="getActivity/{charges}")
	public List<Activity> viewActivitiesOfCharges(@PathVariable float charges)
	{
		List<Activity> activitiesList = activityservice.viewActivitiesOfCharges(charges);
		return activitiesList;
	}
	
	// Count the activities by charge
	@GetMapping(path="getActivityCount/{charges}")
	public int countActivitiesOfCharges(@PathVariable float charges)
	{
		int count = activityservice.countActivitiesOfCharges(charges);
		return count;
	}
	
	// Add Activity
	@PostMapping("/addActivity")
	public ResponseEntity<Activity> insertActivity(@RequestBody Activity a)
	{
		return new ResponseEntity<Activity>(activityservice.insertActivity(a),HttpStatus.CREATED);
	}
	
	// Update Activity
	@PutMapping("/updateActivity")
	public ResponseEntity<Activity> updateActivity(@RequestBody Activity a) throws Throwable
	{
		return new ResponseEntity<Activity>(activityservice.updateActivity(a),HttpStatus.OK);
	}
	
	// Delete Activity
	@DeleteMapping(path="/deleteActivity")
	public String deleteActivity(@RequestBody Activity a)
	{
		activityservice.deleteActivity(a);
		return "Activity deleted !";
	}
	
	// Delete Activity by id
	@DeleteMapping(path="deleteActivityById/{activityId}")
	public ResponseEntity<String> deleteActivityById(@PathVariable int activityId) throws Throwable
	{
		activityservice.deleteActivityById(activityId);
		return new ResponseEntity<String>("Activity deleted successfully!",HttpStatus.OK);
		
	}
}
