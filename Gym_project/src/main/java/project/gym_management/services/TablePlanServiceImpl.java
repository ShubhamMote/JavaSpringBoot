package project.gym_management.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.gym_management.dao.TablePlanDao;
import project.gym_management.dto.PlanDto;
import project.gym_management.entities.TablePlan;

@Service
@Transactional
public class TablePlanServiceImpl implements TablePlanService{
	@Autowired
	TablePlanDao planDao;

	@Override
	public void createPlan(PlanDto planDto) {
		TablePlan plan=new TablePlan();
		BeanUtils.copyProperties(planDto, plan);
		planDao.save(plan);
	}

	@Override
	public TablePlan getPlan(PlanDto planDto) {
		TablePlan plan = planDao.getById(planDto.getPlan_id());
		return plan;
	}

	@Override
	public void deletePlan(PlanDto planDto) {
		planDao.deleteById(planDto.getPlan_id());
		
	}

	@Override
	public void updatePlan(PlanDto planDto) {
		TablePlan plan = this.getPlan(planDto);
		BeanUtils.copyProperties(planDto, plan);
		planDao.save(plan);
	}

	@Override
	public List<TablePlan> getAllPalns() {
		List<TablePlan> list = planDao.findAll();
		return list;
	}

	@Override
	public TablePlan findPlan(int plan_id) {
		TablePlan plan = planDao.getById(plan_id);
		return plan;
	}

	
}
