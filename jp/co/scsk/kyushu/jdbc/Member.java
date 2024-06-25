package jp.co.scsk.kyushu.jdbc;

import java.sql.Timestamp;

public class Member {
	private String memberId;
	private String memberName;
	private Timestamp insDate;
	private String insUserId;
	private int updCounter;
	private Timestamp updDate;
	private String userId;

	public Member(String memberId, String memberName, Timestamp insDate, String insUserId, int updCounter,
			Timestamp updDate, String userId) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.insDate = insDate;
		this.insUserId = insUserId;
		this.updCounter = updCounter;
		this.updDate = updDate;
		this.userId = userId;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public Timestamp getInsDate() {
		return insDate;
	}

	public String getInsUserId() {
		return insUserId;
	}

	public int getUpdCounter() {
		return updCounter;
	}

	public Timestamp getUpdDate() {
		return updDate;
	}

	public String getUserId() {
		return userId;
	}
}