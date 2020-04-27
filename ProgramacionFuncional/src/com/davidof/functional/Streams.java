package com.davidof.functional;

import static com.davidof.functional.Customer.Genero.Femenino;
import static com.davidof.functional.Customer.Genero.Masculino;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.davidof.functional.Customer.Genero;

public class Streams {
	public static void main(String[] args) {

		List<Customer> clientes = getClientes();

		//Filter
		clientes.stream()
				.filter(c -> c.getSexo().equals(Masculino))
				.collect(Collectors.toList())
				.forEach(System.out::println);
				
		//Map
		clientes.stream()
				.map(c -> c.getNombre())
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
		//FlatMap y reduce
		Optional<Double> suma = clientes.stream()
				.flatMap(c -> c.getOrders().stream())
				.map(o -> o.getImporte())
				.reduce((o1,o2)->o1 + o2);
		System.out.println(suma);

		//Order
		clientes.stream()
				.sorted(Comparator.comparing(Customer::getBdate)
								  .thenComparing(Customer::getNombre))
				.forEach(System.out::println);
		System.out.println("");
		//max
		clientes.stream()
				.max(Comparator.comparing(Customer::getBdate))
				.ifPresent(System.out::println);
		//Group
		Map<Genero, List<Customer>> sexos = clientes.stream()
				.collect(Collectors.groupingBy(Customer::getSexo));

	}

	/**
	 * @return
	 */
	private static List<Customer> getClientes() {
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
		cliente.getOrders().add(order);
		order = new Order(4, 2534.5);
		cliente2.getOrders().add(order);
		Customer cliente3 = new Customer("Daniel", "dani@hotmail.com", "9000000", 
				LocalDate.parse("10-03-1965", patron), Masculino);
		order = new Order(5, 2337.5);
		cliente.getOrders().add(order);
		order = new Order(6, 34253.5);
		cliente.getOrders().add(order);
		Customer cliente4 = new Customer("Ana", "ana@hotmail.com", "10200000", 
				LocalDate.parse("10-03-1965", patron), Femenino);
		Customer cliente5 = new Customer("Maria", "maria@hotmail.com", "45333333", 
				LocalDate.parse("13-06-2000", patron), Femenino);
		List<Customer> clientes = new ArrayList<>(Arrays.asList(cliente,cliente2,cliente3,cliente4,cliente5));
		return clientes;
	}
}
