package com.davidof.lambda;

import java.time.LocalDate;

public class Customer {
	private String nombre;
	private String email;
	private String phone;
	private LocalDate bdate;
	public Customer(String nombre, String email, String phone, LocalDate bdate) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.phone = phone;
		this.bdate = bdate;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getBdate() {
		return bdate;
	}
	public void setBdate(LocalDate bdate) {
		this.bdate = bdate;
	}
}
