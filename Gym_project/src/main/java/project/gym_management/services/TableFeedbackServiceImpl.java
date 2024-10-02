package project.gym_management.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.gym_management.dao.TableFeedbackDao;
import project.gym_management.dao.TableUserDao;
import project.gym_management.dto.FeedbackDto;
import project.gym_management.entities.TableFeedback;
import project.gym_management.entities.TableUser;

@Service
@Transactional
public class TableFeedbackServiceImpl implements TableFeedbackService {

	@Autowired
	private TableFeedbackDao feedDao;
	@Autowired
	private TableUserDao userDao;

	@Override
	public List<TableFeedback> getAllFeedbacks() {
		List<TableFeedback> list = feedDao.findAll();
		return list;
	}

	@Override
	public void addFeedback(FeedbackDto feed) {
		TableFeedback feedback = new TableFeedback();
		BeanUtils.copyProperties(feed, feedback);
		feedback.getTbluser().setUser_id(feed.getUser_id());
		feedback.setResponse( "Thank you for your feedback,admin will responed you soon !!!");
		feedDao.save(feedback);

	}

	@Override
	public void deleteFeedback(FeedbackDto feeddto) {
		feedDao.deleteById(feeddto.getFeed_id());

	}

	@Override
	public List<TableFeedback> getUserFeedbackById(int user_id) {
		TableUser user = userDao.getById(user_id);
		List<TableFeedback> list = feedDao.findByTbluser(user);
		return list;
	}

	@Override
	public void feedbackResponse(FeedbackDto feeddto) {
		TableFeedback feedback = feedDao.getById(feeddto.getFeed_id());
		feedback.setResponse(feeddto.getResponse());
		feedDao.save(feedback);
	}

}
