package jp.co.scsk.kyushu.jdbc;

import java.sql.Timestamp;

public class Shop {
	private String shopId;
	private String shopName;
	private Timestamp insDate;
	private String insUserId;
	private int updCounter;
	private Timestamp updDate;
	private String updUserId;

	public Shop(String shopId, String shopName, Timestamp insDate, String insUserId, int updCounter, Timestamp updDate,
			String updUserId) { 
		this.shopId = shopId;
		this.shopName = shopName;
		this.insDate = insDate;
		this.insUserId = insUserId;
		this.updCounter = updCounter;
		this.updDate = updDate;
		this.updUserId = updUserId;
	}

	public String getShopName() {
		return shopName;
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

	public String getUpdUserId() {
		return updUserId;
	}

	public String getShopId() {
		return shopId;
	}
}