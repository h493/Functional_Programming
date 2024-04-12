package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectURL());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectURL(){
        return "jdbc://localhost:5432/users";
    }

    //Represents a supplier of results
    static Supplier<String> getDBConnectionUrlSupplier =
            () -> "jdbc://localhost:5432/users";
}
