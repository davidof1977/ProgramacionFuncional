package com.davidof.reactiverx.sotck;

import java.time.LocalDate;

public class VolumeData {
	private LocalDate date;
	private Integer volumen;
	public VolumeData(LocalDate date, Integer volumen) {
		super();
		this.date = date;
		this.volumen = volumen;
	}
	@Override
	public String toString() {
		return "VolumeData [date=" + date + ", volumen=" + volumen + "]";
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getVolumen() {
		return volumen;
	}
	public void setVolumen(Integer volumen) {
		this.volumen = volumen;
	}
}
