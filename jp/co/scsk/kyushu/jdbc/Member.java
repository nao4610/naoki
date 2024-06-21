package jp.co.scsk.kyushu.jdbc;

import java.sql.Date;

public class Member {
	private String member_id;
	private String member_name;
	private Date ins_date;
	private String ins_user_id;
	private String upd_counter;
	private Date upd_date;
	private String user_id;
	public Member(String string, String string2, Date date, String string3, int int1, Date date2, String string4) {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public String getMember_id() {
		return member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public Date getIns_date() {
		return ins_date;
	}
	public String getIns_user_id() {
		return ins_user_id;
	}
	public String getUpd_counter() {
		return upd_counter;
	}
	public Date getUpd_date() {
		return upd_date;
	}
	public String getUser_id() {
		return user_id;
	}

}
