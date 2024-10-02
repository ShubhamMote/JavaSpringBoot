package project.gym_management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.gym_management.entities.TableFeedback;
import project.gym_management.entities.TableUser;

public interface TableFeedbackDao extends JpaRepository<TableFeedback, Integer> {

	List<TableFeedback> findByTbluser(TableUser user);

}
