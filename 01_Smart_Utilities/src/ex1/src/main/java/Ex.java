import java.util.Scanner;

public class Ex {

    public static void main (String []args){
        double xY[][] = new double[3][2];
        System.out.println("Enter triangle coordinates:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 2; j++){
                boolean repeat;
                do {
                    repeat = false;
                    try {
                        xY[i][j] = Double.parseDouble(scanner.nextLine().trim());
                    } catch (Exception e) {
                        repeat = true;
                        System.out.println("Could not parse a number. Please, try again");
                    }
                } while (repeat);
            }
        }
        if(isTriangle(xY)) {
            System.out.printf("Perimeter: %.3f", calculatePerimeter(xY));
        } else {
            System.out.println("It's not a triangle");
        }
        scanner.close();
    }

    static boolean isTriangle(double xY[][]) {
        double s = (xY[0][0] * (xY[1][1] - xY[2][1])
                + xY[1][0] * (xY[2][1] - xY[0][1])
                + xY[2][0] * (xY[0][1] - xY[1][1])) / 2;
        return s != 0;
    }

    static double calculatePerimeter(double[][] points) {
        double sideAB = distance(points[0], points[1]);
        double sideBC = distance(points[1], points[2]);
        double sideCA = distance(points[2], points[0]);
        return sideAB + sideBC + sideCA;
    }

    static double distance(double[] point1, double[] point2) {
        double dx = point2[0] - point1[0];
        double dy = point2[1] - point1[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}