package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        // Function take one argument and produces one result
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        int result = addBy1AndThenMultiplyBy10.apply(1);

        System.out.println(result);

        // BiFunction takes 2 argument and produces 1 result
        System.out.println(increamentByOneAndMultiply(1,10));

        System.out.println(increamentByOneAndMultiplyBiFunction.apply(1,10));
    }

    static BiFunction<Integer, Integer, Integer> increamentByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne+1)*numberToMultiplyBy;

    static Function<Integer, Integer> multiplyBy10Function = number -> number*10;
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static int incrementByOne(int number){
        return number+1;
    }

    static int increamentByOneAndMultiply(int number, int multiplyBy){
        return (number+1)*multiplyBy;
    }
}
