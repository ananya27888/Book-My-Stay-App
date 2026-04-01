import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + "(" + capacity + ")";
    }
}

public class UC9 {
    public static void main(String[] args) {
        List<Bogie> list = new ArrayList<>();

        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("First Class", 24));

        Map<String, List<Bogie>> map =
                list.stream().collect(Collectors.groupingBy(b -> b.name));


        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

}