package com.davidof.functional;

import static com.davidof.functional.pojos.Customer.Genero.Femenino;
import static com.davidof.functional.pojos.Customer.Genero.Masculino;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.davidof.functional.pojos.Customer;
import com.davidof.functional.pojos.Order;

public class Optionals {
	static DateTimeFormatter  patron = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public static void main(String[] args) {

		List<Optional<Customer>> clientes = getClientes();

		
		//OrElseGet
		List<Optional<Customer>> collect = clientes.stream()
				.filter(c -> c.orElseGet(()-> new Customer("Default", "default@hotmail.com", "9122222", LocalDate.parse("14-01-1980", patron), Masculino)).getSexo().equals(Masculino))
				.collect(Collectors.toList());
		collect.forEach(c->System.out.println(c.get().toString()));
		
		//OrElse
		clientes.stream()
				.filter(c -> c.orElse(new Customer("Default", "default@hotmail.com", "9122222", 
						LocalDate.parse("14-01-1980", patron), Masculino)).getSexo().equals(Masculino))
				.forEach(System.out::println);
		//Map
		//OrElseThrow
				clientes.stream()
						.filter(c -> c.orElseThrow(UnsatisfiedLinkError::new).getSexo().equals(Masculino))
						.forEach(System.out::println);

	}
	/**
	 * @return
	 */
	private static List<Optional<Customer>> getClientes() {

		Optional<Customer> cliente = Optional.ofNullable(new Customer("David", "david@hotmail.com", "91234567", 
				LocalDate.parse("18-07-1977", patron), Masculino));

		cliente.ifPresent(c-> c.getOrders().add(new Order(1, 23.5)));

		cliente.ifPresent(c-> c.getOrders().add(new Order(2, 253.5)));
		Optional<Customer> cliente2 = Optional.ofNullable(new Customer("Mario", "Mario@hotmail.com", "9122222", 
				LocalDate.parse("14-01-1980", patron), Masculino));
		cliente2.ifPresent(c-> c.getOrders().add(new Order(3, 123.5)));
		cliente2.ifPresent(c-> c.getOrders().add(new Order(4, 2534.5)));
		Optional<Customer> cliente3 = Optional.ofNullable(new Customer("Daniel", "dani@hotmail.com", "9000000", 
				LocalDate.parse("10-03-1965", patron), Masculino));
		cliente3.ifPresent(c-> c.getOrders().add(new Order(5, 2337.5)));
		cliente3.ifPresent(c-> c.getOrders().add(new Order(6, 34253.5)));
		Optional<Customer> cliente4 = Optional.ofNullable(new Customer("Ana", "ana@hotmail.com", "10200000", 
				LocalDate.parse("10-03-1965", patron), Femenino));
		Optional<Customer> cliente5 = Optional.ofNullable(new Customer("Maria", "maria@hotmail.com", "45333333", 
				LocalDate.parse("13-06-2000", patron), Femenino));
		Optional<Customer> cliente6 = Optional.ofNullable(null);
		List<Optional<Customer>> clientes = new ArrayList<>(Arrays.asList(cliente,cliente2,cliente3,cliente4,cliente5,cliente6));
		return clientes;
	}
}
