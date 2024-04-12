package CallBack;

import java.util.function.Consumer;

public class _Callback {

    public static void main(String[] args) {
        hello("John", "Montana", value ->
                System.out.println("Last name not provided for" + value));

        hello("John", null, value ->
                System.out.println("Last name not provided for" + value));

        hello2("John",
                null,
                () -> System.out.println("Last name not provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);

        if(lastName != null){
            System.out.println(lastName);
        }else{
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback){
        System.out.println(firstName);

        if(lastName != null){
            System.out.println(lastName);
        }else{
            callback.run();
        }
    }

//        function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName)
//        } else {
//            callback();
//        }
//    }

}
