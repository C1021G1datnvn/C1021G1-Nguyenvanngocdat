package ss0_baitap_oop.bai_tap2.service;

import ss0_baitap_oop.bai_tap2.model.Student;

public interface IStudentService {
    public void add();
    public void remove(int mssV);
    public void removeIndex(int index);
    public void search(String search);
    public void showAll();
    public void sort();
}
