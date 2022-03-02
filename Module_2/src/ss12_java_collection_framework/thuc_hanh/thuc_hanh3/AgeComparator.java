package ss12_java_collection_framework.thuc_hanh.thuc_hanh3;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}
