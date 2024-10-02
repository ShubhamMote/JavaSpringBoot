package project.gym_management.dto;

import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import project.gym_management.entities.TableTrainer;

public class TrainerDto {
	private int trainer_id;
	private String trainer_name;
	private String avatar;
	private String contact;
	private String address;
	private float salary;
	private Date join_date;
	
	public TrainerDto() {
		// TODO Auto-generated constructor stub
	}


	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

	public String getTrainer_name() {
		return trainer_name;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public static TrainerDto fromEntity(TableTrainer trainer) {
		TrainerDto trainerDto=new TrainerDto();
		BeanUtils.copyProperties(trainer, trainerDto);
		return trainerDto;
	}
	

}
