package com.davidof.functional;

import static com.davidof.functional.pojos.Customer.Genero.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.davidof.functional.pojos.Customer;

public class ProgramacionFuncional2 {

	public static void main(String[] args) {

		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Customer cliente = new Customer("David", "david@hotmail.com", "91234567", 
				LocalDate.parse("18-07-1977", patron), Masculino);
		Customer cliente2 = new Customer("Mario", "Mario@hotmail.com", "9122222", 
				LocalDate.parse("14-01-1980", patron),Masculino);
		Customer cliente3 = new Customer("Daniel", "dani@hotmail.com", "9000000", 
				LocalDate.parse("10-03-1960", patron),Masculino);
		List<Customer> clientes = new ArrayList<>(Arrays.asList(cliente,cliente2,cliente3));

		List<Customer> listClientes = clientes.stream().sorted().collect(Collectors.toList());
		
		listClientes.forEach(System.out::println);
		
		Map<String,Customer> mapClientes = clientes.stream().collect(Collectors.toMap(Customer::getNombre,c->c));
		
		mapClientes.forEach((k,v)->System.out.println(k + ": " + v));
		
		List<String> nombres = clientes.stream().map(funcionObtenerNombresCliente()).collect(Collectors.toList());
		
		System.out.println(nombres);

	}

	/**
	 * @return
	 */
	private static Function<? super Customer, ? extends String> funcionObtenerNombresCliente() {
		return c -> {
			//Culaquier logica
			return c.getNombre();
		};
	}

}
