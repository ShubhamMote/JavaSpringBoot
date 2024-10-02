package project.gym_management.dto;

import org.springframework.beans.BeanUtils;

import project.gym_management.entities.TableDiet;

public class DietDto {
	
	private int diet_id;
	private String diet_name;
	private String day;
	private String morning;
	private String afternoon;
	private String evening;
	private String night;
	
	public int getDiet_id() {
		return diet_id;
	}
	public void setDiet_id(int diet_id) {
		this.diet_id = diet_id;
	}
	public String getDiet_name() {
		return diet_name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public void setDiet_name(String diet_name) {
		this.diet_name = diet_name;
	}
	public String getMorning() {
		return morning;
	}
	public void setMorning(String morning) {
		this.morning = morning;
	}
	public String getAfternoon() {
		return afternoon;
	}
	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
	}
	public String getEvening() {
		return evening;
	}
	public void setEvening(String evening) {
		this.evening = evening;
	}
	public String getNight() {
		return night;
	}
	public void setNight(String night) {
		this.night = night;
	}
	public static DietDto fromEntity(TableDiet item) {
	DietDto dietDto=new DietDto();
	BeanUtils.copyProperties(item, dietDto);
		return dietDto;
	}
	
}