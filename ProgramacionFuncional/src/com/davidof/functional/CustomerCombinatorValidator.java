package com.davidof.functional;

import static com.davidof.functional.CustomerCombinatorValidator.ResultState.EMAIL_ERROR;
import static com.davidof.functional.CustomerCombinatorValidator.ResultState.NOT_ADULT_ERROR;
import static com.davidof.functional.CustomerCombinatorValidator.ResultState.PHONE_ERROR;
import static com.davidof.functional.CustomerCombinatorValidator.ResultState.VALID;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import com.davidof.functional.CustomerCombinatorValidator.ResultState;



public interface CustomerCombinatorValidator extends Function<Customer, ResultState> {
	
	static CustomerCombinatorValidator isEmailValid() {
		return customer -> customer.getEmail().contains("@")?VALID:EMAIL_ERROR;
	}
	
	static CustomerCombinatorValidator isPhoneValid() {
		return customer -> customer.getPhone().startsWith("6")?VALID:PHONE_ERROR;
	}
	
	static CustomerCombinatorValidator isAnAdult() {
		return customer -> Period.between(customer.getBdate(), LocalDate.now()).getYears()>18?VALID:NOT_ADULT_ERROR;
	}
	
	default CustomerCombinatorValidator and (CustomerCombinatorValidator other) {
		return customer -> {
			ResultState validationResult = this.apply(customer);
			return validationResult.equals(VALID)?other.apply(customer) : validationResult;
			};
	}
	
	static ResultState isValid(Customer customer){
		return isAnAdult()
			.and(isEmailValid())
			.and(isPhoneValid())
			.apply(customer);
	}
	
	enum ResultState{
		VALID,EMAIL_ERROR,PHONE_ERROR,NOT_ADULT_ERROR;
	}
	

}
