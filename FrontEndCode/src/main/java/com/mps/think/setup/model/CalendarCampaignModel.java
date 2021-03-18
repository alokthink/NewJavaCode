package com.mps.think.setup.model;

import java.io.Serializable;

public class CalendarCampaignModel implements Serializable{

	private static final long serialVersionUID = 18L;
	private int calendarCampainId;
	private int beginDay;
	private String beginMonth;
	private String campaign;
	private int endDay;
	private String endMonth;
	public int getCalendarCampainId() {
		return calendarCampainId;
	}
	public void setCalendarCampainId(int calendarCampainId) {
		this.calendarCampainId = calendarCampainId;
	}
	public int getBeginDay() {
		return beginDay;
	}
	public void setBeginDay(int beginDay) {
		this.beginDay = beginDay;
	}
	public String getBeginMonth() {
		return beginMonth;
	}
	public void setBeginMonth(String beginMonth) {
		this.beginMonth = beginMonth;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	public String getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
}
