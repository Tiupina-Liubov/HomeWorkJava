package src._2024_02_14;

import java.util.ArrayList;
import java.util.List;

public class VoidEx {
    private List<String> list;

    public VoidEx() {
        this.list = new ArrayList<>();
    }

    public List<String> getList() {
        return list;
    }

    public void addToList(String s) {
        list.add(s);
    }

    public void modifyList() {
        list.replaceAll(el -> el + "*");
    }
}