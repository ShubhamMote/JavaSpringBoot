package project.gym_management.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.gym_management.dao.TableMemberPlanDao;
import project.gym_management.dto.MemberPlanDto;
import project.gym_management.entities.TableMemberPlan;
import project.gym_management.entities.TablePlan;
import project.gym_management.entities.TableUser;

@Service
@Transactional
public class TableMemberPlanServiceImpl implements TableMemberPlanService{
	@Autowired
	TableMemberPlanDao memberPlanDao;
	@Autowired
	TableUserService tbluserservice;

	@Override
	public String addUserPlan(MemberPlanDto mpDto) {
		TableUser allInfo = tbluserservice.getById(mpDto.getUser_id());
		List<TablePlan> list = allInfo.getPlanList();
		  for (TablePlan plan : list) { if (plan.getPlan_id() ==mpDto.getPlan_id())
			  return "plan already subscribed"; }
		 
		TableMemberPlan userplan =new TableMemberPlan();
		BeanUtils.copyProperties(mpDto, userplan);
		memberPlanDao.save(userplan);
		return "success";
	}

	@Override
	public void deleteUserPlan(MemberPlanDto mpDto) {
	
		memberPlanDao.DeleteEntry(mpDto.getUser_id(),mpDto.getPlan_id());
	}

	@Override
	public TableMemberPlan endDate(MemberPlanDto mpDto) {
		 TableMemberPlan endDate = memberPlanDao.getEndDate(mpDto.getUser_id(),mpDto.getPlan_id());
	      return endDate;
	}

}
