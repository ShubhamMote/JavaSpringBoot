package project.gym_management.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import project.gym_management.entities.TableFeedback;

public class FeedbackDto {

	private int feed_id;
	private int user_id;
	private String complete_name;
	private String contact;
	private String feedback;
	private String response;
	private Date created_timestamp;

	public FeedbackDto() {

	}

	public int getFeed_id() {
		return feed_id;
	}

	public void setFeed_id(int feed_id) {
		this.feed_id = feed_id;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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


	public static FeedbackDto fromEntity(TableFeedback entity) {
		FeedbackDto dto = new FeedbackDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setUser_id(entity.getTbluser().getUser_id());
		dto.setComplete_name(entity.getTbluser().getComplete_name());
		dto.setContact(entity.getTbluser().getContact());
		return dto;
	}
}
