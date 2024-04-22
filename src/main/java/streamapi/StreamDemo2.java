package streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> data= Arrays.asList("Java","J2ee","Spring","Selenium");
        //display all courses starting with 's' in uppercase
        data.stream().filter(e->e.startsWith("S")).map(e->e.toUpperCase()).forEach(System.out::println);
        //display all courses starting with 's' in uppercase and sorted manner
        data.stream().filter(e->e.startsWith("S")).sorted().map(String::toUpperCase).forEach(System.out::println);
    }
}
