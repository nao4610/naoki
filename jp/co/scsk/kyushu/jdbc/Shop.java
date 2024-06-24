package jp.co.scsk.kyushu.jdbc;

import java.sql.Date;

public class Shop {
	private String shop_id;
	private String shop_name;
	private Date ins_date;
	private String ins_user_id;
	private int upd_counter;
	private Date upd_date;
	private String upd_user_id;

	public Shop(String shop_id, String shop_name, Date ins_date, String ins_user_id, int upd_counter, Date upd_date,
			String upd_user_id) {
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.ins_date = ins_date;
		this.ins_user_id = ins_user_id;
		this.upd_counter = upd_counter;
		this.upd_date = upd_date;
		this.upd_user_id = upd_user_id;
	}

	public String getShop_name() {
		return shop_name;
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

	public String getShop_id() {
		return shop_id;
	}

}
