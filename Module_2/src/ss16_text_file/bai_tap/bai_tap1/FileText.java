package ss16_text_file.bai_tap.bai_tap1;

import java.io.*;

public class FileText {

    public static final String FILE_INPUT = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\ss16_text_file\\bai_tap\\bai_tap1\\soucrefile.txt";
    public static final String OUTPUT_FILE = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\ss16_text_file\\bai_tap\\bai_tap1\\targetfile.txt";

    public static void readFile() throws IOException {
        String count = "";
        try {
            FileReader fileRead = new FileReader(FILE_INPUT);
            FileWriter fileWrite = new FileWriter(OUTPUT_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileRead);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
            while ((count = bufferedReader.readLine()) != null) {
                bufferedWriter.write(count);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e) {
            System.out.println("Lỗi tại anh hoàng!");
        }
    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}
