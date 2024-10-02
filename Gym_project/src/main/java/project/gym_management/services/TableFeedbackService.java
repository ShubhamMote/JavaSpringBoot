package project.gym_management.services;

import java.util.List;

import project.gym_management.dto.FeedbackDto;
import project.gym_management.entities.TableFeedback;

public interface TableFeedbackService {

	public List<TableFeedback> getAllFeedbacks();

	public void addFeedback(FeedbackDto feed);

	public void deleteFeedback(FeedbackDto feeddto);

	List<TableFeedback> getUserFeedbackById(int user_id);

	public void feedbackResponse(FeedbackDto feeddto);

}
