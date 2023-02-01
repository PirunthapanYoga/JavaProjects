import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args){
        //task 1
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        String longName = names.max(Comparator.comparing(String::valueOf)).get();
        System.out.println(longName);

        //task 2
        long start=System.currentTimeMillis();
        Stream<String> names2 = Stream.of("John", "Paul", "George", "John", "Paul", "John");
        List<String> names3=names2.collect(Collectors.toList());
        Map<String,Long> map= names3.stream().distinct().collect(Collectors.toMap(  p -> (String) p.toString() , p-> names3.stream().filter(c -> c== p).count()));
        long end=System.currentTimeMillis();
        System.out.println(map.toString());
        System.out.println("Time taken for the process :  " + (end-start));

    }
}
