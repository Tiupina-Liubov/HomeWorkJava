package src.new_year;

import java.util.Comparator;

public class Comporator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }
}
