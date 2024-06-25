package jp.co.scsk.kyushu.jdbc;

import java.sql.Timestamp;

public class CarModel {
	private String carModelId;
	private String carModelName;
	private String carTypeKbn;
	private String carClassId;
	private String makerId;
	private int capacity;
	private double fuelEconomy;
	private int displacement;
	private Timestamp insDate;
	private String insUserId;
	private int updCounter;
	private Timestamp updDate;
	private String updUserId;

	public CarModel(String carModelId, String carModelName, String carTypeKbn,
			String carClassId, String makerId, int capacity, double fuelEconomy,
			int displacement, Timestamp insDate, String insUserId,
			int updCounter, Timestamp updDate, String updUserId) {
		this.carModelId = carModelId;
		this.carModelName = carModelName;
		this.carTypeKbn = carTypeKbn;
		this.carClassId = carClassId;
		this.makerId = makerId;
		this.capacity = capacity;
		this.fuelEconomy = fuelEconomy;
		this.displacement = displacement;
		this.insDate = insDate;
		this.insUserId = insUserId;
		this.updCounter = updCounter;
		this.updDate = updDate;
		this.updUserId = updUserId;
	}

	public String getCarModelId() {
		return carModelId;
	}

	public String getCarModelName() {
		return carModelName;
	}

	public String getCarTypeKbn() {
		return carTypeKbn;
	}

	public String getCarClassId() {
		return carClassId;
	}

	public String getMakerId() {
		return makerId;
	}

	public int getCapacity() {
		return capacity;
	}

	public double getFuelEconomy() {
		return fuelEconomy;
	}

	public int getDisplacement() {
		return displacement;
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