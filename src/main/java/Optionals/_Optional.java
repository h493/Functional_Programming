package Optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class _Optional {
    public static void main(String[] args) {

        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        System.out.println(value);

        Object value2 = Optional.ofNullable("null")
                .orElseThrow(() -> new IllegalStateException("exception"));

        Supplier<IllegalStateException> exceptionSupplier = () -> new IllegalStateException("Exception");

        Object value2_Copy = Optional.ofNullable("null")
                .orElseThrow(exceptionSupplier);

       //IfPresent
        Optional.ofNullable("chhikarahimanshu21@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to : " + email));

        //IfPresentOrElse
        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending Email to :" + email) , () ->
                        System.out.println("Cannot send the email"));

    }
}
