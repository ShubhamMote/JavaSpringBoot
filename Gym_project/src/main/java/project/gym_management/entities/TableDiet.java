package project.gym_management.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tblDiet")
@Entity
public class TableDiet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Override
	public String toString() {
		return "TableDiet{" +
				"diet_id=" + diet_id +
				", diet_name='" + diet_name + '\'' +
				", day='" + day + '\'' +
				", morning='" + morning + '\'' +
				", afternoon='" + afternoon + '\'' +
				", evening='" + evening + '\'' +
				", night='" + night + '\'' +
				'}';
	}
}
