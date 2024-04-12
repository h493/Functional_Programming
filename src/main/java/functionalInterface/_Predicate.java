package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("91232"));
        System.out.println(isPhoneNumberValid("21213214"));

        System.out.println(isPhoneNumberValidPredicate.test("91231"));

        System.out.println(
                isPhoneNumberValidPredicate.and(containNumber3).test("912312")
        );

        System.out.println(
                isPhoneNumberValidPredicate.or(containNumber3).test("912312")
        );

        System.out.println(isEqual(2,"2") + "\n" + isEqualBiPredicate.test(2,"2") );
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("91") && phoneNumber.length() == 5;
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("91") && phoneNumber.length() == 5;

    static Predicate<String> containNumber3 =
            phoneNumber -> phoneNumber.contains("3");

    static boolean isEqual(int num, String number){
         return num == Integer.parseInt(number);
    }

    static BiPredicate<Integer, String> isEqualBiPredicate =
            (num, number) -> num == Integer.parseInt(number);
}
