import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class Main {
    public static int read() throws FileNotFoundException{
        int meetings = 0;
        File f = new File ("src/Schedules.txt");
        Scanner s = new Scanner(f);
        String schedules= "";
        while(s.hasNext()) {
            while (s.hasNextBoolean()) {
                schedules += s.nextBoolean() + " ";
            }
            AppointmentBook a = new AppointmentBook(readSchedule(schedules));
            schedules = "";
            if (a.makeAppointment(s.nextInt(), s.nextInt(), s.nextInt())){
                meetings++;
            }
        }
        return meetings;
    }
    public static boolean[][] readSchedule(String lines) throws FileNotFoundException{
        Scanner s = new Scanner(lines);
        boolean [][] schedule = new boolean[8][60];
        for (int i = 0; i < schedule.length; i++){
            for (int j = 0; j < schedule[i].length; j++){
                schedule[i][j] = s.nextBoolean();
            }
        }
        return schedule;
    }
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println(read());
    }

}