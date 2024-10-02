package project.gym_management.services;

import project.gym_management.dto.MemberPlanDto;
import project.gym_management.entities.TableMemberPlan;

public interface TableMemberPlanService {

	String addUserPlan(MemberPlanDto mpDto);

	void deleteUserPlan(MemberPlanDto mpDto);

	TableMemberPlan endDate(MemberPlanDto mpDto);

}
