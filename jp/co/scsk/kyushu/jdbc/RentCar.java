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

	public RentCar(String string, String string2, String string5, String string6, String string7, String string8, Date date, String string3, int int1, Date date2, String string4) {
		// TODO 自動生成されたコンストラクター・スタブ
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
