package project.gym_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.gym_management.entities.TableUser;

public interface TableUserDao extends JpaRepository<TableUser, Integer>{

	TableUser findByEmail(String email);
	
 
}
