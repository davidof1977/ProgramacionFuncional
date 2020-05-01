package com.davidof.functional.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Comparable<Customer> {

	@Override
	public String toString() {
		return "Customer [nombre=" + nombre + ", email=" + email + ", phone=" + phone + ", bdate=" + bdate + ", sexo="
				+ sexo + ", orders=" + orders + "]";
	}

	private String nombre;
	private String email;
	private String phone;
	private LocalDate bdate;
	private Genero sexo;
	private List<Order> orders;
	public List<Order> getOrders() {
		if(orders==null)
			orders = new ArrayList<>();
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Genero getSexo() {
		return sexo;
	}
	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}
	public Customer(String nombre, String email, String phone, LocalDate bdate, Genero sexo) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.phone = phone;
		this.bdate = bdate;
		this.sexo = sexo;
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
	@Override
	public int compareTo(Customer c) {
		return c.getBdate().compareTo(getBdate());
	}
	
	public enum Genero{
		Masculino,Femenino;
	}
}
