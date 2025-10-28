public class AppointmentBook {
    private boolean[][] schedule;

    public AppointmentBook(boolean[][] schedule) {
        this.schedule = schedule;
    }

    private boolean isMinuteFree(int period, int minute) {
        return schedule[period - 1][minute];
    }


    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        schedule = new boolean[8][60];
        for (int i=25; i <30; i++) schedule [1][i] = true;
        for (int i=0; i <15; i++) schedule [2][i] = true;
        for (int i=41; i <60; i++) schedule [2][i] = true;
        for (int i=5; i <30; i++) schedule [3][i] = true;
        for (int i=44; i <60; i++) schedule [3][i] = true;
        AppointmentBook b = new AppointmentBook(schedule);
        int period = 2;
        while(period < 5){
            System.out.println("Period: " + period);
            b.printPeriod(period);
            period++;
        }
        for(int i = startPeriod; i <= endPeriod; i++) {
            int freeBlock = findFreeBlock(i, duration);
            if (freeBlock > -1) {
                reserveBlock(freeBlock, duration, i);
                return true;
            }
        }
        return false;
    }

    public void printPeriod(int period) {
        for (int i = 0; i < schedule[period - 1].length; i++)
            System.out.println(i + " " + schedule[period - 1][i]);
    }

    public int findFreeBlock(int period, int duration) {
        int block = 0;

        for (int i = 0; i < 60; i++) {
            if (isMinuteFree(period, i)) {
                block++;
                if (block == duration) {
                    return i - duration + 1;
                }
            } else {
                block = 0; // reset only if minute is not free
            }
        }

        return -1;
    }
    public void reserveBlock (int startMinute, int duration,int period){
        for(int i = startMinute; i < startMinute + duration; i++){
            schedule[period-1][i]= false;
        }
    }
}


