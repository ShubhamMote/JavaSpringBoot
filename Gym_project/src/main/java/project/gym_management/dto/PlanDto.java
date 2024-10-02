package project.gym_management.dto;

import org.springframework.beans.BeanUtils;
import project.gym_management.entities.TablePlan;
import project.gym_management.entities.TableTrainer;

public class PlanDto {
	private int plan_id;
	private String membershipPlanName;
	private int  duration;
	private String start_hour;
	private String end_hour;
	private float price;
	private String trainer_name;
	
	public PlanDto() {
	
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getMembershipPlanName() {
		return membershipPlanName;
	}

	public void setMembershipPlanName(String membershipPlanName) {
		this.membershipPlanName = membershipPlanName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStart_hour() {
		return start_hour;
	}

	public void setStart_hour(String start_hour) {
		this.start_hour = start_hour;
	}

	public String getEnd_hour() {
		return end_hour;
	}

	public void setEnd_hour(String end_hour) {
		this.end_hour = end_hour;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTrainer_name() {
		return trainer_name;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}

	public static PlanDto fromEntity(TablePlan entity) {
		
		PlanDto planDto=new PlanDto();
		BeanUtils.copyProperties(entity, planDto);
		return planDto;
	}

	public static PlanDto fromEntityList(TablePlan plan) {
		PlanDto planDto=new PlanDto();
		BeanUtils.copyProperties(plan, planDto);
		return planDto;
	}
	
}
