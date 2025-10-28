import java.io.FileNotFoundException;

public class Main {
    public static int read() throws FileNotFoundException{
        int meetings = 0;
        File f = new File ("Schedules.txt");
        Scanner s = Scanner(f);
        String schedules= "";
        While(s.hasNext()) {
            while (s.hasNextBoolean()){
                schedules+= s.hasNextBoolean() + " ";
                AppointmentBook a = new AppointmentBook(readSchedule(schedules))
            }
        }
    }

    public static void main(String[] args) {
        boolean[][] schedule = new boolean[8][60];
        AppointmentBook a = new AppointmentBook(schedule);
        for (int i = 10; i < 15; i++) schedule[1][i] = true;
        a.printPeriod(2);
        System.out.println(a.findFreeBlock(2,15));
        System.out.println(a.findFreeBlock(2,9));
        System.out.println(a.findFreeBlock(2,20));
        System.out.println(a.makeAppointment(2, 4, 22));
        a.printPeriod(4);
        System.out.println(a.makeAppointment(3, 4, 3));
        System.out.println(a.makeAppointment(2, 4, 30));
    }
}