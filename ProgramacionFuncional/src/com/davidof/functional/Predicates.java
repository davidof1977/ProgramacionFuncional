package com.davidof.functional;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Predicates {

	public static void main(String[] args) {
		
		Predicate<Integer> valorPar= x->x % 2 ==0 ;
		BiPredicate<Integer, Integer> comparar = (x,y) -> x>y?true:false;
		
		System.err.println(valorPar.test(2));
		System.err.println(comparar.test(2,3));

	}
}
