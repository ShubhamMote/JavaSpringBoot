package project.gym_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.gym_management.entities.TablePlan;

public interface TablePlanDao extends JpaRepository<TablePlan, Integer> {

}
