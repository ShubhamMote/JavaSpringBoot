package project.gym_management.services;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.gym_management.dao.TableInventoryDao;
import project.gym_management.dto.InventoryDto;
import project.gym_management.entities.TableInventory;

@Service
@Transactional
public class TableInventoryServiceImpl implements TableInventoryService{
	
	@Autowired
	TableInventoryDao inventoryDao;

	@Override
	public void addItemInfo(InventoryDto inventoryDto) {
		
		TableInventory tblInventory=new TableInventory();
		BeanUtils.copyProperties(inventoryDto, tblInventory);
		inventoryDao.save(tblInventory);
			
	}

	@Override
	public List<TableInventory> getAllInventoryItems() {
		List<TableInventory> list = inventoryDao.findAll();
		return list;
	}



}
