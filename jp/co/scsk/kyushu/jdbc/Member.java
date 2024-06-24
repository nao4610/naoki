package jp.co.scsk.kyushu.jdbc;

import java.sql.Date;

public class Member {
	private String member_id;
	private String member_name;
	private Date ins_date;
	private String ins_user_id;
	private int upd_counter;
	private Date upd_date;
	private String user_id;

	public Member(String member_id, String member_name, Date ins_date, String ins_user_id, int upd_counter,
			Date upd_date, String user_id) {
		this.member_id = member_id;
		this.member_name = member_name;
		this.ins_date = ins_date;
		this.ins_user_id = ins_user_id;
		this.upd_counter = upd_counter;
		this.upd_date = upd_date;
		this.user_id = user_id;
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

	public int getUpd_counter() {
		return upd_counter;
	}

	public Date getUpd_date() {
		return upd_date;
	}

	public String getUser_id() {
		return user_id;
	}
}