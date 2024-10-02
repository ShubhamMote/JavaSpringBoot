package project.gym_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import project.gym_management.entities.TableMemberPlan;

public interface TableMemberPlanDao extends JpaRepository<TableMemberPlan, Integer> {
	
     @Query(value = "delete from TableMemberPlan tmp where tmp.user_id=?1 and tmp.plan_id=?2")
	 @Modifying
     void DeleteEntry(int user_id,int plan_id);
     
     @Query(value = "from TableMemberPlan tmp where tmp.user_id=?1 and tmp.plan_id=?2")
	 //@Modifying
	 TableMemberPlan getEndDate(int user_id, int plan_id);
}
