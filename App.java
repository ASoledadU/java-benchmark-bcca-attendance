import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<String> classList = new ArrayList<>();
        classList.add("Angie U.");
        classList.add("Christian G.");
        classList.add("Dakota N.");
        classList.add("Derek S.");
        classList.add("Destiny M.");
        classList.add("Devin B.");
        classList.add("Dylan M.");
        classList.add("Gillian F.");
        classList.add("JD G.");
        classList.add("Oscar G.");
        classList.add("Patton B.");
        classList.add("Tyler I.");

        System.out.println("Goodmorning Base Camp Student!");
        for (String student : classList) {
            System.out.println(student);
        }

        System.out.println("Who is signing in?");
        String studentName = scanner.nextLine();
        if (classList.contains(studentName)) {
            Date dateTime = new java.util.Date();

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
        } else {
            System.out.println("NOT a valid student or a MISSPELLED student name. Please try again.");
        }
    }
}