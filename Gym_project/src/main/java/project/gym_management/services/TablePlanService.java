package project.gym_management.services;

import java.util.List;

import project.gym_management.dto.PlanDto;
import project.gym_management.entities.TablePlan;

public interface TablePlanService {
  
	public void createPlan(PlanDto planDto);
	
	public TablePlan getPlan(PlanDto planDto);
	
	public void deletePlan(PlanDto planDto);
	
	public void updatePlan(PlanDto planDto);

	public List<TablePlan> getAllPalns();

	public TablePlan findPlan(int plan_id);
}
