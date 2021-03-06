package com.winvest.data;

public class Item {

	private String name;

	private double actualPrice;

	private double coverPrice;

	private double percentCovered;

	public double getPercentCovered() {
		return percentCovered;
	}

	public void setPercentCovered(double percentCovered) {
		this.percentCovered = percentCovered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public double getCoverPrice() {
		return coverPrice;
	}

	public void setCoverPrice(double coverPrice) {
		this.coverPrice = coverPrice;
	}

}
