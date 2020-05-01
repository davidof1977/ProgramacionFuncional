package com.davidof.reactiverx;

import static com.davidof.functional.pojos.Customer.Genero.Femenino;
import static com.davidof.functional.pojos.Customer.Genero.Masculino;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import com.davidof.functional.pojos.Customer;
import com.davidof.functional.pojos.Order;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class CustomerObservable extends Observable<List<Order>>{

	private List<Observer<? super List<Order>>> misObservadores = new LinkedList<>();
	
	String nombre;
	
	public CustomerObservable(String nombre) {
		super();
		this.nombre = nombre;

	}
	@Override
	protected void subscribeActual(Observer<? super List<Order>> observer) {
		misObservadores.add(observer);
		
	}
	
	public void recuperarOrdenesCompra() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				misObservadores.forEach(o->{
					try {
					 //Thread.sleep(1500);
					//	List<Customer> clientes = getClientes().stream().filter(c->c.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
					//	List<Order> ordenesCliente = clientes.stream().flatMap(c-> c.getOrders().stream()).collect(Collectors.toList());
						//o.onNext(ordenesCliente);
					Optional<List<Order>> ordenes = getClientes().stream().filter(c->c.getNombre().equalsIgnoreCase(nombre)).findFirst().map(c->c.getOrders());
					 o.onNext(ordenes.orElse(new ArrayList<Order>()));
						
					}catch(Exception ie) {
						ie.printStackTrace();
					}
				});
				misObservadores.forEach(o->{
					o.onComplete();
				});
			}
		}, 400);;
	}
	
	
	/**
	 * @return
	 */
	private List<Customer> getClientes() {
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Customer cliente = new Customer("David", "david@hotmail.com", "91234567", 
				LocalDate.parse("18-07-1977", patron), Masculino);
		Order order = new Order(1, 23.5);
		cliente.getOrders().add(order);
		order = new Order(2, 253.5);
		cliente.getOrders().add(order);
		
		Customer cliente2 = new Customer("Mario", "Mario@hotmail.com", "9122222", 
				LocalDate.parse("14-01-1980", patron), Masculino);
		order = new Order(3, 123.5);
		cliente2.getOrders().add(order);
		order = new Order(4, 2534.5);
		cliente2.getOrders().add(order);
		
		Customer cliente3 = new Customer("Daniel", "dani@hotmail.com", "9000000", 
				LocalDate.parse("10-03-1965", patron), Masculino);
		order = new Order(5, 2337.5);
		cliente3.getOrders().add(order);
		order = new Order(6, 34253.5);
		cliente3.getOrders().add(order);
		
		Customer cliente4 = new Customer("Ana", "ana@hotmail.com", "10200000", 
				LocalDate.parse("10-03-1965", patron), Femenino);
		
		Customer cliente5 = new Customer("Maria", "maria@hotmail.com", "45333333", 
				LocalDate.parse("13-06-2000", patron), Femenino);
		
		List<Customer> clientes = new ArrayList<>(Arrays.asList(cliente,cliente2,cliente3,cliente4,cliente5));
		return clientes;
	}
}