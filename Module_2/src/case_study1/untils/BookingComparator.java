package case_study1.untils;

import case_study1.model.BookingModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BookingComparator implements Comparator<BookingModel> {

    @Override
    public int compare(BookingModel o1, BookingModel o2) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate starDate1 = LocalDate.parse(o1.getFirstDay(), dateTimeFormatter);
        LocalDate starDate2 = LocalDate.parse(o2.getFirstDay(), dateTimeFormatter);
        LocalDate endDate1 = LocalDate.parse(o1.getLastDay(), dateTimeFormatter);
        LocalDate endDate2 = LocalDate.parse(o2.getLastDay(), dateTimeFormatter);

        if (starDate1.compareTo(starDate2) < 0) {
            return 1;
        }else if (starDate1.compareTo(starDate2) > 0 ) {
            return -1;
        }else {
            if (endDate1.compareTo(endDate2) < 0) {
                return 1;
            }else if (endDate1.compareTo(endDate2) == 0){
                return 0;
            }else {
                return -1;
            }
        }
    }
}
