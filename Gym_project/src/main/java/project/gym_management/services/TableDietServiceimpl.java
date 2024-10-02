package project.gym_management.services;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.gym_management.dao.TableDietDao;
import project.gym_management.dto.DietDto;
import project.gym_management.entities.TableDiet;

@Service
@Transactional
public class TableDietServiceimpl implements TableDietService {

	@Autowired
	TableDietDao dietDao;

	@Override
	public void addDiet(DietDto dietDto) {
		TableDiet tblDiet = new TableDiet();
		BeanUtils.copyProperties(dietDto, tblDiet);
		dietDao.save(tblDiet);
	}

	@Override
	public void updateDiet(DietDto dietDto) {
		TableDiet diet = dietDao.getById(dietDto.getDiet_id());
		diet.setDiet_name(dietDto.getDiet_name());
		diet.setMorning(dietDto.getMorning());
		diet.setAfternoon(dietDto.getAfternoon());
		diet.setEvening(dietDto.getEvening());
		diet.setNight(dietDto.getNight());
		dietDao.save(diet);
	}

	@Override
	public void deleteDiet(DietDto dietDto) {
		
		dietDao.deleteById(dietDto.getDiet_id());
	}

	@Override
	public List<TableDiet> getAllDietItems() {
		List<TableDiet> list = dietDao.findAll();
		return list;
	}

}
