package com.davidof.functional;

import java.time.LocalDate;

import com.davidof.functional.CustomerCombinatorValidator.ResultState;
import com.davidof.functional.pojos.Customer;
import com.davidof.functional.pojos.Customer.Genero;

public class CustomerApp {

	public static void main(String[] args) {
		Customer c= new Customer("David", "davidhotmail.come", "65897844", LocalDate.of(1977, 07, 18), Genero.Masculino);
		ResultState result= CustomerCombinatorValidator.isValid(c);
		
		System.out.println(result);
	}

}
