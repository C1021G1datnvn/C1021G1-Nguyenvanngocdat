package ss16_text_file.thuc_hanh.thuc_hanh2;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

        //readAndWriteFile.readFile("D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\ss16_text_file\\thuc_hanh\\thuc_hanh2\\numbers.txt");
        List<Integer> numbers = readAndWriteFile.readFile("D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\ss16_text_file\\thuc_hanh\\thuc_hanh2\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\ss16_text_file\\thuc_hanh\\thuc_hanh2\\result.txt", maxValue);
    }
}
