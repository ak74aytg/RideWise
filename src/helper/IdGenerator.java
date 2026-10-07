package helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdGenerator {
    private static Set<Integer> assignedIDs = new HashSet<>();

    public static Integer getRandomId() {
        int id = new Random().nextInt(1_000_000);
        while (assignedIDs.contains(id)){
            id = new Random().nextInt(1_000_000);
        }
        assignedIDs.add(id);
        return id;
    }
}
