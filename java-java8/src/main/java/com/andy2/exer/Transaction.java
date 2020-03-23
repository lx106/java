package com.andy2.exer;

import com.andy.exer.Trader;

//交易类
public class Transaction {

	private com.andy.exer.Trader trader;
	private int year;
	private int value;

	public Transaction() {
	}

	public Transaction(com.andy.exer.Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public com.andy.exer.Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value="
				+ value + "]";
	}

}
