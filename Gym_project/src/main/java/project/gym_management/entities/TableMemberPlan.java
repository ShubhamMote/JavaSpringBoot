package project.gym_management.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tblmemberplan")
public class TableMemberPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberplan_id;
	private int user_id;
	private int plan_id;
	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
    @CreationTimestamp
	private Date subscription_date;

	public TableMemberPlan() {

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

	public Date getSubscription_date() {
		return subscription_date;
	}

	public void setSubscription_date(Date subscription_date) {
		this.subscription_date = subscription_date;
	}

	@Override
	public String toString() {
		return "TableMemberPlan{" +
				"memberplan_id=" + memberplan_id +
				", user_id=" + user_id +
				", plan_id=" + plan_id +
				", subscription_date=" + subscription_date +
				'}';
	}
}
