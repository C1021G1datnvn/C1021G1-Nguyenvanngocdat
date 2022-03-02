package ss0_baitap_oop.bai_tap1.controller;

import ss0_baitap_oop.bai_tap1.model.Candidate;
import ss0_baitap_oop.bai_tap1.service.CandidateService;

import java.util.Scanner;

public class CandidateController {
    public static void main(String[] args) {
        do {
            System.out.println("------Menu--------");
            System.out.println("1. Add new Candidate");
            System.out.println("2. List all");
            System.out.println("0. Exit");
            Scanner scanner = new Scanner(System.in);
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    CandidateService.addNew();
                    break;
                case 2:
                    CandidateService.findAll();
                    break;
                case 3:
                    System.exit(0);
            }
        }while (true);
    }
}
