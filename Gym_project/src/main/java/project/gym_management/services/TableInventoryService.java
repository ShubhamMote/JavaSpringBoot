package project.gym_management.services;

import java.util.List;

import project.gym_management.dto.InventoryDto;
import project.gym_management.entities.TableInventory;

public interface TableInventoryService {

	void addItemInfo(InventoryDto inventoryDto);

	List<TableInventory> getAllInventoryItems();


}
