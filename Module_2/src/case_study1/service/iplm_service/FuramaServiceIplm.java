package case_study1.service.iplm_service;

import case_study1.model.facility.Facility;
import case_study1.model.facility.House;
import case_study1.model.facility.Room;
import case_study1.model.facility.Villa;
import case_study1.service.interface_service.IFacilityService;
import case_study1.untils.Validation;

import java.io.*;
import java.util.*;

public class FuramaServiceIplm implements IFacilityService {
    public static final String VILLA = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\case_study1\\data\\data_facility\\villa.csv";
    public static final String HOUSE = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\case_study1\\data\\data_facility\\house.csv";
    public static final String ROOM = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\case_study1\\data\\data_facility\\room.csv";
    public static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    public static Scanner scanner = new Scanner(System.in);


    @Override
    public void maintenance() {
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (entry.getValue() == 5) {
                System.out.println("Chờ công việc bảo trì!");
            }
        }
    }

    public void wirteFacility() {
        try {
            FileWriter fileWriterVilla = new FileWriter(VILLA);
            FileWriter fileWriterHouse = new FileWriter(HOUSE);
            FileWriter fileWriterRoom = new FileWriter(ROOM);

            BufferedWriter bufferedWriterVilla = new BufferedWriter(fileWriterVilla);
            BufferedWriter bufferedWriterHouse = new BufferedWriter(fileWriterHouse);
            BufferedWriter bufferedWriterRoom = new BufferedWriter(fileWriterRoom);

            for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
                if (facilityIntegerEntry.getKey() instanceof Villa) {
                    Villa villa = (Villa) facilityIntegerEntry.getKey();
                    bufferedWriterVilla.write(villa.getNameService() + "," + villa.getUseArea() + "," + villa.getRentPrice() + ","
                    + villa.getMaxPax()  + "," + villa.getRentType() + "," + villa.getMaintenance() + "," + villa.getRoomStandard()
                            + "," + villa.getPoolArea() + "," + villa.getFloorNumber());
                    bufferedWriterVilla.newLine();
                    bufferedWriterVilla.close();
                }else if (facilityIntegerEntry.getKey() instanceof House) {
                    House house = (House) facilityIntegerEntry.getKey();
                    bufferedWriterHouse.write(house.getNameService() + "," + house.getUseArea() + "," + house.getRentPrice() + ","
                            + house.getMaxPax()  + "," + house.getRentType() + "," + house.getMaintenance() + "," + house.getRoomStandard()
                            +  "," + house.getFloorNumber());
                    bufferedWriterHouse.newLine();
                    bufferedWriterHouse.close();
                }else if (facilityIntegerEntry.getKey() instanceof  Room) {
                    Room room = (Room) facilityIntegerEntry.getKey();
                    bufferedWriterRoom.write(room.getNameService() + "," + room.getUseArea() + "," + room.getRentPrice() + ","
                            + room.getMaxPax()  + "," + room.getRentType() + "," + room.getMaintenance());
                    bufferedWriterRoom.newLine();
                    bufferedWriterRoom.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFuramaServiceIplm(){
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : readVilla().entrySet()) {
            facilityIntegerMap.put(facilityIntegerEntry.getKey(), 1);
        }
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : readHouse().entrySet()) {
            facilityIntegerMap.put(facilityIntegerEntry.getKey(), 1);
        }
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : readRoom().entrySet()) {
            facilityIntegerMap.put(facilityIntegerEntry.getKey(), 1);
        }
    }
    public FuramaServiceIplm() {
        readFuramaServiceIplm();
    }
    static {
        readVilla();
        readHouse();
        readRoom();
    }
    public static Map<Facility, Integer> readVilla() {
        Map<Facility, Integer> villaRead = new LinkedHashMap<>();
        try {
            FileReader fileReaderVilla = new FileReader(VILLA);
            BufferedReader bufferedReaderVilla = new BufferedReader(fileReaderVilla);
            String line;
            String[] temp;
            Villa villa;
            while ((line = bufferedReaderVilla.readLine()) != null) {
                temp = line.split(",");
                villa = new Villa(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2]), Integer.parseInt(temp[3]),
                        temp[4],temp[5],temp[6],Double.parseDouble(temp[7]),Integer.parseInt(temp[8]));
                villaRead.put(villa, 1);
            }
            bufferedReaderVilla.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villaRead;
    }
    public static Map<Facility, Integer> readHouse() {
        Map<Facility, Integer> houseRead = new LinkedHashMap<>();
        try {
            FileReader fileReaderHouse = new FileReader(HOUSE);
            BufferedReader bufferedReaderHouse = new BufferedReader(fileReaderHouse);
            String line;
            String[] temp;
            House house;
            while ((line = bufferedReaderHouse.readLine()) != null) {
                temp = line.split(",");
                 house = new House(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2]), Integer.parseInt(temp[3]),
                        temp[4],temp[5],temp[6],Integer.parseInt(temp[7]));
                houseRead.put(house, 1);
            }
            bufferedReaderHouse.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseRead;
    }
    public static Map<Facility, Integer> readRoom() {
        Map<Facility, Integer> roomRead = new LinkedHashMap<>();
        try {
            FileReader fileReaderRoom = new FileReader(ROOM);
            BufferedReader bufferedReaderRoom = new BufferedReader(fileReaderRoom);
            String line;
            String[] temp;
            Room room;
            while ((line = bufferedReaderRoom.readLine()) != null) {
                temp = line.split(",");
                room = new Room(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2]), Integer.parseInt(temp[3]),
                        temp[4],temp[5], temp[6]);
                roomRead.put(room, 1);
            }
            bufferedReaderRoom.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomRead;
    }


    public void updateFacility(Facility facility) {
        if (facilityIntegerMap.containsKey(facility)) {
            facilityIntegerMap.put(facility, facilityIntegerMap.get(facility) + 1);
        }else {
            facilityIntegerMap.put(facility, 1);
        }
    }

    @Override
    public void addNewVilla() {
        String nameService = null;
        Double useArea = 0.0;
        Double rentPrice = 0.0;
        int maxPax = 0;
        String rentType = null;
        String maintenance = null;
        String roomStandard = null;
        Double pollArea = 0.0;
        int floorNumber = 0;
        boolean check;
        do {
            check = false;
            try {
                System.out.println("Nhập ID dịch vụ: (SVVL-XXXX)");
                nameService = Validation.checkId();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập diện tích sử dụng: ");
                useArea = Validation.checkArea();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập giá thuê: ");
                rentPrice =Validation.checkRoomRate();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập số người tối đa: ");
                maxPax = Validation.checkPersonNumber();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập kiểu thuê: (day/month/year)");
                rentType = Validation.checkServiceName();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập sự bảo trì: ");
                maintenance = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập tiêu chuẩn phòng: (vip/normal)");
                roomStandard = Validation.checkServiceName();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập diện tích hồ bơi: ");
                pollArea = Validation.checkArea();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập số số tầng: ");
                floorNumber = Validation.checkFloorNumber();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        Villa villa = new Villa(nameService, useArea, rentPrice, maxPax, rentType, maintenance ,roomStandard, pollArea, floorNumber);
//        facilityIntegerMap.put(villa, 0);
        updateFacility(villa);
        wirteFacility();
        System.out.println("Đã thêm mới Villa thành công!");
    }
    public static void dissPlayVilla() {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (facilityIntegerEntry.getKey() instanceof Villa) {
                System.out.println(facilityIntegerEntry.getKey());
                System.out.println(facilityIntegerEntry.getValue());
            }
        }
    }
    public static  void dissPlayHouse() {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (facilityIntegerEntry.getKey() instanceof House) {
                System.out.println(facilityIntegerEntry.getKey());
                System.out.println(facilityIntegerEntry.getValue());
            }
        }
    }
    public static void dissPlayRoom() {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (facilityIntegerEntry.getKey() instanceof Room) {
                System.out.println(facilityIntegerEntry.getKey());
                System.out.println(facilityIntegerEntry.getValue());
            }
        }
    }
    @Override
    public void addNewHouse() {
        String nameService = null;
        Double useArea = 0.0;
        Double rentPrice = 0.0;
        int maxPax = 0;
        String rentType = null;
        String maintenance = null;
        String roomStandard = null;
        int floorNumber = 0;
        boolean check;
        do {
            check = false;
            try {
                System.out.println("Nhập ID dịch vụ: (SVHO-XXXX)");
                nameService = Validation.checkId();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập diện tích sử dụng: ");
                useArea = Validation.checkArea();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập giá thuê: ");
                rentPrice =Validation.checkRoomRate();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập số người tối đa: ");
                maxPax = Validation.checkPersonNumber();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập kiểu thuê: (day/month/year)");
                rentType = Validation.checkServiceName();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập sự bảo trì: ");
                maintenance = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập tiêu chuẩn phòng: (vip/normal)");
                roomStandard = Validation.checkServiceName();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập số số tầng: ");
                floorNumber = Validation.checkFloorNumber();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);
        House house = new House(nameService, useArea, rentPrice, maxPax, rentType, maintenance ,roomStandard, floorNumber);
//        facilityIntegerMap.put(house, 0);
        updateFacility(house);
        wirteFacility();
        System.out.println("Đã thêm mới House thành công!");
    }

    @Override
    public void addNewRoom() {
        String nameService = null;
        Double useArea = 0.0;
        Double rentPrice = 0.0;
        int maxPax = 0;
        String rentType = null;
        String maintenance = null;
        String freeServiceIncluded = null;
        boolean check;
        do {
            check = false;
            try {
                System.out.println("Nhập ID dịch vụ: (SVRO-XXXX)");
                nameService = Validation.checkId();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập diện tích sử dụng: ");
                useArea = Validation.checkArea();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập giá thuê: ");
                rentPrice =Validation.checkRoomRate();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập số người tối đa: ");
                maxPax = Validation.checkPersonNumber();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập kiểu thuê: (day/month/year)");
                rentType = Validation.checkServiceName();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập sự bảo trì: ");
                maintenance = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Miễn phí dịch vụ: ");
                freeServiceIncluded = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        Room room = new Room(nameService, useArea, rentPrice, maxPax, rentType, maintenance, freeServiceIncluded);
//        facilityIntegerMap.put(room, 0);
        updateFacility(room);
        wirteFacility();
        System.out.println("Đã thêm mới Room thành công!");
    }

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            System.out.println("Service: " + facilityIntegerEntry.getKey() + "Số lần đã thuê: " + facilityIntegerEntry.getValue());
        }
    }
}
