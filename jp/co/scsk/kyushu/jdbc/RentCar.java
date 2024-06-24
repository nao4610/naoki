package jp.co.scsk.kyushu.jdbc;

import java.sql.Date;

public class RentCar {
	private String car_management_no;
	private String car_model_id;
	private String shop_id;
	private String etc;
	private String car_navigation;
	private String smoking_kbn;
	private Date ins_date;
	private String ins_user_id;
	private int upd_counter;
	private Date upd_date;
	private String upd_user_id;

	public RentCar(String car_management_no, String car_model_id, String shop_id, String etc, String car_navigation,
			String smoking_kbn, Date ins_date, String ins_user_id, int upd_counter, Date upd_date, String upd_user_id) {
		this.car_management_no = car_management_no;
		this.car_model_id = car_model_id;
		this.shop_id = shop_id;
		this.etc = etc;
		this.car_navigation = car_navigation;
		this.smoking_kbn = smoking_kbn;
		this.ins_date = ins_date;
		this.ins_user_id = ins_user_id;
		this.upd_counter = upd_counter;
		this.upd_date = upd_date;
		this.upd_user_id = upd_user_id;
	}

	public String getCar_management_no() {
		return car_management_no;
	}

	public String getCar_model_id() {
		return car_model_id;
	}

	public String getShop_id() {
		return shop_id;
	}

	public String getEtc() {
		return etc;
	}

	public String getCar_navigation() {
		return car_navigation;
	}

	public String getSmoking_kbn() {
		return smoking_kbn;
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