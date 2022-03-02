package ss17_binary_serialization.bai_tap.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IProductService {
    public void addProduct();
    public void listProduct();
    public void searchProduct();
    public void readList() throws IOException, ClassNotFoundException;
}
