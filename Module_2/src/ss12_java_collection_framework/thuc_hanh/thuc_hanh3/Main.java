package ss12_java_collection_framework.thuc_hanh.thuc_hanh3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Đạt", 18, "QT");
        Student student1 = new Student("Nam", 18, "QN");
        Student student2 = new Student("Ling", 28, "DN" );
        Student student3 = new Student("Bảo", 25, "DN" );

        List<Student> lists = new ArrayList<>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
//        Collections.sort(lists);
        for(Student st : lists){
            System.out.println(st.toString());
        }
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists,ageComparator);
        System.out.println("So sanh theo tuoi:");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }
}
