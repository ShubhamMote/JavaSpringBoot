package project.gym_management.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tblfeedback")
public class TableFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feed_id;
    private String feedback;
    @Column(length=500)
    private String response;
    @Temporal(TemporalType.DATE)
	@Column(updatable = false)
    @CreationTimestamp
	private Date created_timestamp;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TableUser tbluser;
    
    public TableFeedback() {
		this.tbluser=new TableUser();
	}

	public TableFeedback(int feed_id, String feedback, Date created_timestamp, TableUser tbluser) {
		super();
		this.feed_id = feed_id;
		this.feedback = feedback;
		this.created_timestamp = created_timestamp;
		this.tbluser = tbluser;
	}

	public int getFeed_id() {
		return feed_id;
	}

	public void setFeed_id(int feed_id) {
		this.feed_id = feed_id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getCreated_timestamp() {
		return created_timestamp;
	}

	public void setCreated_timestamp(Date created_timestamp) {
		this.created_timestamp = created_timestamp;
	}

	public TableUser getTbluser() {
		return tbluser;
	}

	public void setTbluser(TableUser tbluser) {
		this.tbluser = tbluser;
	}

	@Override
	public String toString() {
		return "TableFeedback{" +
				"feed_id=" + feed_id +
				", feedback='" + feedback + '\'' +
				", response='" + response + '\'' +
				", created_timestamp=" + created_timestamp +
				", tbluser=" + tbluser +
				'}';
	}
}
