import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        java.util.Date dateTime = new java.util.Date();

        System.out.println("Goodmorning Base Camp Student!");
        System.out.println("Who is signing in?");
        String studentName = scanner.nextLine();

        Checkin checkIn = new Checkin(studentName, dateTime);

        System.out.println("Thank you " + checkIn.studentName + " for signing in at " + checkIn.dateTime);
        scanner.close();

        try {
            FileOutputStream fileStream = new FileOutputStream("BCCAAttendance.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(checkIn);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save checkin.");
        }

    }
}