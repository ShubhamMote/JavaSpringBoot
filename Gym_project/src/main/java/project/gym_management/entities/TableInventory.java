package project.gym_management.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tblinventory")
public class TableInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	private String equip_name;
	private int units;
	private String model;
	private double item_price;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern =  "yyyy-MM-dd")
    private Date purchase_date;
	
	public TableInventory() {
	
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

	@Override
	public String toString() {
		return "TableInventory{" +
				"item_id=" + item_id +
				", equip_name='" + equip_name + '\'' +
				", units=" + units +
				", model='" + model + '\'' +
				", item_price=" + item_price +
				", purchase_date=" + purchase_date +
				'}';
	}
}
