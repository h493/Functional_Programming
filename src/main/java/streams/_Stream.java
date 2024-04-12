package streams;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

       List<Gender> list  = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toList());

        System.out.println(list);

        Set<Gender> set  = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());

        System.out.println(set);

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(gender -> System.out.println(gender));

        // length of each Name
        people.stream()
                .map(person -> person.name)
                .mapToInt(name -> name.length())
                .forEach(gender -> System.out.println(gender));


        // Explanation of above
        Function<Person, String > peopleStringFunction = person -> person.name;
        ToIntFunction<String> length = name -> name.length();
        IntConsumer println = gender -> System.out.println(gender);

        people.stream().map(peopleStringFunction).mapToInt(length).forEach(println);

        // all Match
        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsOnlyFemales);

        boolean anyFemale = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));

        System.out.println(anyFemale);



    }

    static class Person {
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

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
