package project.gym_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.gym_management.entities.TableInventory;

public interface TableInventoryDao extends JpaRepository<TableInventory, Integer>{

}
