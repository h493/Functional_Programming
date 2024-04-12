package CombinatorPattern;

import java.time.LocalDate;

import static CombinatorPattern.CustomerRegistrationValidator.*;
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Customer customer = new Customer(
                "Alice",
                "alicegmail.com",
                "+917206690063",
                LocalDate.of(2000,1,1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));
        //if valid we can store customer in DB

        // using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalAccessException(result.name());
        }
    }
}
