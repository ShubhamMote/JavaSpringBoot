package project.gym_management.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import project.gym_management.entities.TableInventory;

public class InventoryDto {


	private int item_id;
	private String equip_name;
	private int units;
	private String model;
	private double item_price;
    private Date purchase_date;
	
	public InventoryDto() {
	
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getEquip_name() {
		return equip_name;
	}

	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public static InventoryDto fromEntity(TableInventory item) {
		InventoryDto inventoryDto=new InventoryDto();
		BeanUtils.copyProperties(item, inventoryDto);
		return inventoryDto;
	}
	
}
