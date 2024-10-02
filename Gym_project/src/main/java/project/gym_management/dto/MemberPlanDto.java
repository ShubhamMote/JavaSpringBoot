package project.gym_management.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import project.gym_management.entities.TableMemberPlan;

public class MemberPlanDto {
	private int memberplan_id;
	private int user_id;
	private int plan_id;
	private String end_date;

	public MemberPlanDto() {

	}

	public int getMemberplan_id() {
		return memberplan_id;
	}

	public void setMemberplan_id(int memberplan_id) {
		this.memberplan_id = memberplan_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public static MemberPlanDto fromEntityList(TableMemberPlan endDate, int duration) {
		MemberPlanDto planDto=new MemberPlanDto();
		Date date = endDate.getSubscription_date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
	    c.add(Calendar.DAY_OF_MONTH, duration);  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String newDate = sdf.format(c.getTime()); 
	    planDto.setEnd_date(newDate);
	    planDto.setUser_id(endDate.getUser_id());
	    planDto.setPlan_id(endDate.getPlan_id());
		return planDto;
	}

}
