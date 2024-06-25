package jp.co.scsk.kyushu.jdbc;

import java.sql.Timestamp;

public class RentCar {
	private String carManagementNo;
	private String carModelId;
	private String shopId;
	private String etc;
	private String carNavigation;
	private String smokingKbn;
	private Timestamp insDate;
	private String insUserId;
	private int updCounter;
	private Timestamp updDate;
	private String updUserId;

	public RentCar(String carManagementNo, String carModelId, String shopId, String etc, String carNavigation,
			String smokingKbn, Timestamp insDate, String insUserId, int updCounter, Timestamp updDate,
			String updUserId) {
		this.carManagementNo = carManagementNo;
		this.carModelId = carModelId;
		this.shopId = shopId;
		this.etc = etc;
		this.carNavigation = carNavigation;
		this.smokingKbn = smokingKbn;
		this.insDate = insDate;
		this.insUserId = insUserId;
		this.updCounter = updCounter;
		this.updDate = updDate;
		this.updUserId = updUserId;
	}

	public String getCarManagementNo() {
		return carManagementNo;
	}

	public String getCarModelId() {
		return carModelId;
	}

	public String getShopId() {
		return shopId;
	}

	public String getEtc() {
		return etc;
	}

	public boolean getExistEtc() {
		if (etc.equals("1")) {
			return true;
		}
		return false;
	}
	
	public boolean getNotEtc() {
		if (etc.equals("0")) {
			return true;
		}
		return false;
	}

	public String getCarNavigation() {
		return carNavigation;
	}
	
	public boolean getExistCarNavigation() {
		if (carNavigation.equals("1")) {
			return true;
		}
		return false;
	}
	
	public boolean getNotCarNavigation() {
		if (carNavigation.equals("0")) {
			return true;
		}
		return false;
	}

	public String getSmokingKbn() {
		return smokingKbn;
	}
	
	public boolean getYesSmoking() {
		if (smokingKbn.equals("1")) {
			return true;
		}
		return false;
	}
	
	public boolean getNoSmoking() {
		if (smokingKbn.equals("2")) {
			return true;
		}
		return false;
	}

	public String getSmokingKbnDisPlay() {
		return smokingKbn.equals("1") ? "喫煙" : "禁煙";
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
}