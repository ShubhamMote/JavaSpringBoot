package project.gym_management.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbluser")
public class TableUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String complete_name;
	private String avatar;
	private String contact;
	private String email;
	private String password;
	@Column(columnDefinition = "varchar(255) default 'user'")
	private String role;
	private int question;
	private String answer;
	private String address;
	private int age;
	private double height;
	private double weight;
	private int gender;
	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
    @CreationTimestamp
	private Date joining_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end_of_membership_date;

	/*
	 * @OneToMany(mappedBy = "tbluser", cascade = CascadeType.ALL) private
	 * List<TableFeedback> tbfeed;
	 */

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tblmemberplan", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "plan_id") })
	private List<TablePlan> planList;
	
	public TableUser() {

		// this.tbfeed = new ArrayList<TableFeedback>();
		this.planList = new ArrayList<TablePlan>();
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getComplete_name() {
		return complete_name;
	}

	public void setComplete_name(String complete_name) {
		this.complete_name = complete_name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public Date getEnd_of_membership_date() {
		return end_of_membership_date;
	}

	public void setEnd_of_membership_date(Date end_of_membership_date) {
		this.end_of_membership_date = end_of_membership_date;
	}

	public List<TablePlan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<TablePlan> planList) {
		this.planList = planList;
	}

	@Override
	public String toString() {
		return "TableUser{" +
				"user_id=" + user_id +
				", complete_name='" + complete_name + '\'' +
				", avatar='" + avatar + '\'' +
				", contact='" + contact + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				", question=" + question +
				", answer='" + answer + '\'' +
				", address='" + address + '\'' +
				", age=" + age +
				", height=" + height +
				", weight=" + weight +
				", gender=" + gender +
				", joining_date=" + joining_date +
				", end_of_membership_date=" + end_of_membership_date +
				", planList=" + planList +
				'}';
	}
}
