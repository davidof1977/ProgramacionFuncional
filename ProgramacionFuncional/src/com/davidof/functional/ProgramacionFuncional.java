package com.davidof.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramacionFuncional {

	public static void main(String[] args) {
		//Lista inmutable
//		List<Integer> numeros = Arrays.asList(1,2,3,4,5);
		List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		List<Integer> numeros2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

		
		
		Iterator<Integer> i = numeros.iterator();
		while(i.hasNext()) {
			if(i.next()  % 2 == 0) { 
				i.remove();
			}
		}
		System.out.println(numeros);
		
		
		numeros2.stream().filter(n -> n % 2 != 0).forEach(n->System.out.print(n));
		numeros2.stream().filter(n -> n % 2 != 0).forEach(System.out::print);
		List<Integer> pares =numeros2.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
		System.out.println(pares);
		numeros.removeIf(n -> n % 2 == 0);
		System.out.println(numeros);
	}

}
