package ss16_text_file.bai_tap.bai_tap2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static final String FILE_CSV = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\ss16_text_file\\bai_tap\\bai_tap2\\csvfile.csv";

    public static void main(String[] args) throws IOException {
        List<Country> list = new ArrayList<>();
        try {
            File fileRead = new File(FILE_CSV);
            FileReader fileReader = new FileReader(FILE_CSV);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
//                System.out.println(strings[2]);
            Country country = new Country(Integer.parseInt(strings[0]), strings[1], strings[2] );
            list.add(country);
            }
        }catch (IOException e) {
            System.out.println("Lỗi tại ai?");
        }
        for(Country list1 : list) {
            System.out.println(list1.getName());
        }

    }
}
