package CombinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static CombinatorPattern.CustomerRegistrationValidator.*;
import static CombinatorPattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
        extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid(){
        System.out.println("Running Email validation");
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().startsWith("+91") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult(){
        return customer ->
                Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
