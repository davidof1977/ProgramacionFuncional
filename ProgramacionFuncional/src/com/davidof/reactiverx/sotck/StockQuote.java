package com.davidof.reactiverx.sotck;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StockQuote {
private double price;
private LocalDateTime date;
private Integer volumen;
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public LocalDateTime getDate() {
	return date;
}
public void setDate(LocalDateTime date) {
	this.date = date;
}
public StockQuote(double price, LocalDateTime date, Integer volumen) {
	super();
	this.price = price;
	this.date = date;
	this.volumen = volumen;
}
public Integer getVolumen() {
	return volumen;
}
public void setVolumen(Integer volumen) {
	this.volumen = volumen;
}
}
