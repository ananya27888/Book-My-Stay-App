import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class UC13 {
    public static void main(String[] args) {

        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(new Bogie("Sleeper", (i % 100) + 1));
        }

        long s1 = System.nanoTime();

        List<Bogie> l1 = new ArrayList<>();
        for (Bogie b : list) {
            if (b.capacity > 60) l1.add(b);
        }

        long e1 = System.nanoTime();

        long s2 = System.nanoTime();

        List<Bogie> l2 = list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long e2 = System.nanoTime();

        System.out.println("Loop: " + (e1 - s1));
        System.out.println("Stream: " + (e2 - s2));
    }

}