package hsp.chapter14.list_;

import java.util.LinkedList;
import java.util.List;

public class ListExercise01 {
    public static void main(String[] args) {
        List list = new LinkedList();
        for (int i = 0; i <= 15; i++) {
            list.add("h " + i);
        }

        list.size();

    }
}
