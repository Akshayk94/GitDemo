package streamapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        List<String> data1= Arrays.asList("JAVA","J2EE","SPRING");
        List<String> data2= Arrays.asList("REACT","NODE","VUE");
        //merging two lists
        Stream.concat(data1.stream(),data2.stream()).forEach(System.out::println);
        //check whether list contains specific course
        boolean status=data1.stream().anyMatch(e->e.equalsIgnoreCase("SPRING"));
        System.out.println(status);
        Assert.assertTrue(status);

        //find out distinct numbers from the given array
        List<Integer> data=Arrays.asList(1,5,7,5,3,1,8);
        data.stream().distinct().forEach(System.out::println);
    }
}
