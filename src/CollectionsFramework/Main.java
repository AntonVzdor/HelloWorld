package CollectionsFramework;

import myExperiments.Library;
import myExperiments.LibraryArrayList;
import myExperiments.LibraryList;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> nums = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        for (int i = 0; i < 100; i++) {
            nums.add((int)(Math.random() * 10));
        }
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
