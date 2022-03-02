package ss10_arraylist.bai_tap.bai_tap1.model;

import java.util.Arrays;

public class MyArrayList<E> {
    // Số lượng phần tử có trong  MyArraylist
    private int size = 0;
    // Sức chứa của MyArraylist
    static final int DEFAULT_CAPACITY = 10;
    // Mảng chứa các phần tử
    public Object[] elements;

    //  Sức chứa mặc định khi khởi tạo constructor không có tham số
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructor với sức chứa được truyền vào
     *
     * @param : capacity
     */

    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("capacity : " + capacity);
        }
    }

    /**
     * method trả về số lượng phần tử
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /*
    phương thức clear ArrayList
     */
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    /**
     * phương thức add 1 phần tử vào MyArrayList
     */
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    /**
     * Phương thức add 1 phần tử bằng index
     * @param element
     * @param index
     */

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index : " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    /**
     * Phương thức tăng kích thước của MyArrayList
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity : " + minCapacity);
        }
    }

    /**
     * Phương thức lấy element tại vị trí index
     *
     * @param index
     * @return
     */
    public E get(int index) {
        return (E) elements[index];
    }

    /**
     * Phương thức lấy index của 1 phần tử
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    /**
     * Phương thức kiểm tra 1 phần tử có trong MyArrayList không?
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    /**
     * Phương thức tạo 1 bản sao của MyArrayList
     *
     * @return
     */

    public MyArrayList<E> clone() {
        MyArrayList<E> v = new MyArrayList<>();
        v.elements = Arrays.copyOf(this.elements, this.size);
        v.size = this.size;
        return v;
    }

    /**
     * Phương thức xóa phần tử tại vị trí index
     *
     * @param index
     * @return
     */

    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index : " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
}
