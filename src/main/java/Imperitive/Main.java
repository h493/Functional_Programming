package Imperitive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Imperitive.Main.Gender.*;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Himanshu", MALE),
                new Person("Tushar", MALE),
                new Person("Chakshu", FEMALE),
                new Person("Tanvi", FEMALE)
        );

        //Imperative approach
        System.out.println("//Imperative approach");
        List<Person> females = new ArrayList<>();

        for(Person person : people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for(Person female : females){
            System.out.println(female);
        }

        //Declarative Approach
        System.out.println("//Declarative Approach");
//        people.stream().filter(person -> FEMALE.equals(person.gender))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        List<Person> females2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());

        females2.forEach(System.out::println);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE
    }

}
