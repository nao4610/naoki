package jp.co.scsk.kyushu.jdbc;

import java.sql.Date;

public class Shop {
	private String Shop_id;
	private String Shop_name;
	private Date ins_date;
	private String ins_user_id;
	private int upd_counter;
	private Date upd_date;
	private String upd_user_id;

	public Shop(String string, String string2, Date date, String string3, int int1, Date date2, String string4) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getShop_name() {
		return Shop_name;
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
		return Shop_id;
	}

}
