package com.davidof.functional;

import java.time.LocalDate;

import com.davidof.functional.Customer.Genero;
import com.davidof.functional.CustomerCombinatorValidator.ResultState;

public class CustomerApp {

	public static void main(String[] args) {
		Customer c= new Customer("David", "davidhotmail.come", "65897844", LocalDate.of(1977, 07, 18), Genero.Masculino);
		ResultState result= CustomerCombinatorValidator.isValid(c);
		
		System.out.println(result);
	}

}
