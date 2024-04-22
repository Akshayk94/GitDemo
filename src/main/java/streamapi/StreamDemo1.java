package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> courses=new ArrayList<>();
        courses.add("JAVA");
        courses.add("J2EE");
        courses.add("SPRING");
        courses.add("SELENIUM");
        courses.add("HIBERNATE");

        //count the number of courses starting with 'J'
        System.out.println(courses.stream().filter(e->e.startsWith("J")).count());
        //get the courses having length greater than 4
        courses.stream().filter(e->e.length()>4).forEach(System.out::println);
        //get only first course matching this condition
        courses.stream().filter(e->e.length()>4).limit(1).forEach(System.out::println);
    }
}
