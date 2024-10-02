package project.gym_management.services;

import java.util.List;

import project.gym_management.dto.ImageDto;
import project.gym_management.dto.TrainerDto;
import project.gym_management.entities.TableTrainer;

public interface TableTrainerService {

	void addTrainer(TrainerDto trainerDto);

	List<TableTrainer> getAllTrainers();

	void deleteTrainer(TrainerDto trainerDto);

	void updateTrainer(TrainerDto trainerDto);

	void addTrainerImage(ImageDto imageDto);


}
