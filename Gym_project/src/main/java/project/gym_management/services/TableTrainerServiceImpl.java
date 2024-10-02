package project.gym_management.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gym_management.dao.TableTrainerDao;
import project.gym_management.dto.ImageDto;
import project.gym_management.dto.TrainerDto;
import project.gym_management.entities.TableTrainer;
import project.gym_management.utils.StorageService;

@Service
@Transactional
public class TableTrainerServiceImpl implements TableTrainerService {
	
	@Autowired
	TableTrainerDao trainerDao;
	@Autowired
	private StorageService storageService;
	@Autowired
	private AmazonClient amazonClient;

	@Override
	public void addTrainer(TrainerDto trainerDto) {
		TableTrainer trainer=new TableTrainer();
		BeanUtils.copyProperties(trainerDto, trainer);
		trainerDao.save(trainer);
	}

	@Override
	public List<TableTrainer> getAllTrainers() {
		List<TableTrainer> list = trainerDao.findAll();
		return list;
	}

	@Override
	public void deleteTrainer(TrainerDto trainerDto) {
		TableTrainer trainer = trainerDao.getById(trainerDto.getTrainer_id());
		storageService.delete(trainer.getAvatar());
		trainerDao.deleteById(trainerDto.getTrainer_id());
	}

	@Override
	public void updateTrainer(TrainerDto trainerDto) {
		TableTrainer trainer = trainerDao.getById(trainerDto.getTrainer_id());
		trainer.setAddress(trainerDto.getAddress());
		trainer.setContact(trainerDto.getContact());
		trainer.setSalary(trainerDto.getSalary());
		trainerDao.save(trainer);
	}

	@Override
	public void addTrainerImage(ImageDto imageDto) {
		TableTrainer trainer = trainerDao.getById(imageDto.getId());
		//String fileName = storageService.store(imageDto.getThumbnail());
		String fileName=amazonClient.uploadFile(imageDto.getThumbnail());
		trainer.setAvatar(fileName);
		trainerDao.save(trainer);
	}


	
}
