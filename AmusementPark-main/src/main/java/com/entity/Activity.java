package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue( strategy =  GenerationType.AUTO )
	private int activityId;
	private String activityName;
	private String description;
	private float charges;
	
	public int getActivityId() {
		return activityId;
	}
	
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getCharges() {
		return charges;
	}
	
	public void setCharges(float charges) {
		this.charges = charges;
	}
	
	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", activityName=" + activityName + ", description=" + description
				+ ", charges=" + charges + "]";
	}
	
	

}
