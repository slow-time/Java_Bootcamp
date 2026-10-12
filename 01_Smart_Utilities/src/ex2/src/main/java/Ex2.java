import java.util.Scanner;
public class Ex2 {
    public static void main(String[] args) {
        int seconds = 0;
        System.out.println("Enter seconds: ");
        Scanner scanner = new Scanner(System.in);
        seconds = input(scanner);
        scanner.close();
        if (seconds >= 0) {
            Time time = calculateTime(seconds);
            print(time);
        } else {
            System.out.println("Incorrect time");

        }
    }

    static int input (Scanner scanner) {
        boolean err;
        int seconds = 0;
        do {
            err = false;
            try {
                seconds = scanner.nextInt();;
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.nextLine();
                err = true;
            }
        } while(err);
        return seconds;
    }

    static Time calculateTime (int sec) {
        int h = sec / 60 / 60;
        int m = sec / 60 - h * 60;
        int s = sec - h * 60 * 60 - m * 60;
        return new Time(s, m, h);
    }

    static void print(Time t) {
        System.out.printf("%02d:%02d:%02d", t.hours, t.minutes, t.seconds);
    }
}

class Time {
    int seconds;
    int minutes;
    int hours;

    Time (int s, int m, int h) {
        seconds = s;
        minutes = m;
        hours = h;
    }
}

class Scan {
    Scanner scanner;
    Scan () {
        scanner = new Scanner(System.in);
    }
}
