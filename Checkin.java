import java.io.Serializable;
import java.util.*;

public class Checkin implements Serializable {
    private static final long serialVersionUID = 1L;
    String studentName;
    Date dateTime;

    public Checkin(String studentName, Date dateTime) {
        this.studentName = studentName;
        this.dateTime = dateTime;
    }
}