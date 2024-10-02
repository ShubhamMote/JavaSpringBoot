package project.gym_management.services;

import java.util.List;

import project.gym_management.dto.DietDto;
import project.gym_management.entities.TableDiet;

public interface TableDietService {

	void addDiet(DietDto dietDto);

	void updateDiet(DietDto dietDto);

	void deleteDiet(DietDto dietDto);

	List<TableDiet> getAllDietItems();

}
