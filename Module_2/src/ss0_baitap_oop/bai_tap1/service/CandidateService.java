package ss0_baitap_oop.bai_tap1.service;

import ss0_baitap_oop.bai_tap1.model.Candidate;

import java.util.Scanner;

public class CandidateService {
    private static Candidate[] candidates = new Candidate[100];
    private static int count = 0;
    public static void addNew() {
        if (count < candidates.length) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input ID: ");
            int idPerson = Integer.parseInt(scanner.nextLine());
            System.out.print("Input name: ");
            String namePerson = scanner.nextLine();
            System.out.print("Input Date of Birth: ");
            String dateOffBirth = scanner.nextLine();
            System.out.print("Input Score Math: ");
            int scoreToan = Integer.parseInt(scanner.nextLine());
            System.out.print("Input Score Literature: ");
            int scoreVan = Integer.parseInt(scanner.nextLine());
            System.out.print("Input Score English: ");
            int scoreAnh = Integer.parseInt(scanner.nextLine());
            candidates[count] = new Candidate(idPerson, namePerson, dateOffBirth, scoreToan, scoreVan, scoreAnh);
            count++;
        }else {
            System.out.println("Erroll....");
        }
    }

    public static void findAll() {
        for(Candidate candidate : candidates){
            if (candidate == null) {
                break;
            }else {
                int sum = candidate.getScoreToan() + candidate.getScoreVan() + candidate.getScoreAnh();
                if (sum > 15) {
                    System.out.println(candidate);
                }else {
                    System.out.println("Điểm 3 môn không thoả mản yêu cầu.");
                }
            }
        }
    }
}
