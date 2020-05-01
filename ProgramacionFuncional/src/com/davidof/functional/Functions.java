package com.davidof.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions {
	public static void main(String[] args) {
		
		Function<Integer,Integer> funcionSuma1 = x -> x+1;
		BiFunction<Integer, Integer, Integer> suma = (x,y)->{
			return x + y;
		};
		
		System.out.println(funcionSuma1.apply(1));
		System.out.println(suma.apply(1,1));
	}
	
	private Integer suma1Imperative(Integer x) {
		return x+1;
	}
}
