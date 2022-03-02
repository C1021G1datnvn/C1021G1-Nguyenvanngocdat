package ss4_class_and_object_java.bai_tap;

import java.util.Arrays;
import java.util.Date;

public class StopWatch {
    private Date starttime;
    private Date endtime;
    public Date getStarttime() {

        return this.starttime;
    }
    public Date getEndtime() {
        return this.endtime;
    }
    public StopWatch() {

        this.starttime = new Date();
    }
    public void start() {

        this.starttime = new Date();
    }
    public void end() {

        this.endtime = new Date();
    }
    public double getElapsedTime() {

        return this.getEndtime().getTime() - this.getStarttime().getTime();
    }

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        double array[] = new double[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = Math.random() * 1000;
        }
        System.out.println(Arrays.toString(array));
        stopwatch.end();
        System.out.println("Elapsed time: " + stopwatch.getElapsedTime());
    }
}
