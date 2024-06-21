package jp.co.scsk.kyushu.jdbc;

import java.sql.Date;

public class CarModel {
	private String car_model_id;
	private String car_model_name;
	private String car_type_kbn;
	private String car_class_id;
	private String maker_id;
	private int capacity;
	private double fuel_economy;
	private int displacement;
	private Date ins_date;
	private String ins_user_id;
	private int upd_counter;
	private Date upd_date;
	private String upd_user_id;

	public CarModel(String car_model_id, String car_model_name, String car_type_kbn,
			String car_class_id, String maker_id, int capacity, double fuel_economy,
			int displacement, Date date2, String ins_user_id,
			int upd_counter, Date date, String upd_user_id) {
		this.car_model_id = car_model_id;
		this.car_model_name = car_model_name;
		this.car_type_kbn = car_type_kbn;
		this.car_class_id = car_class_id;
		this.maker_id = maker_id;
		this.capacity = capacity;
		this.fuel_economy = fuel_economy;
		this.displacement = displacement;
		this.ins_date = date2;
		this.ins_user_id = ins_user_id;
		this.upd_counter = upd_counter;
		this.upd_date = date;
		this.upd_user_id = upd_user_id;
	}

	public String getCar_model_id() {
		return car_model_id;
	}

	public String getCar_model_name() {
		return car_model_name;
	}

	public String getCar_type_kbn() {
		return car_type_kbn;
	}

	public String getCar_class_id() {
		return car_class_id;
	}

	public String getMaker_id() {
		return maker_id;
	}

	public int getCapacity() {
		return capacity;
	}

	public double getFuel_economy() {
		return fuel_economy;
	}

	public int getDisplacement() {
		return displacement;
	}

	public Date getIns_date() {
		return ins_date;
	}

	public String getIns_user_id() {
		return ins_user_id;
	}

	public int getUpd_counter() {
		return upd_counter;
	}

	public Date getUpd_date() {
		return upd_date;
	}

	public String getUpd_user_id() {
		return upd_user_id;
	}
}