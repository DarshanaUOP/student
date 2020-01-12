package student.values;

/**
 * Created by acer on 27-Apr-19.
 */
public class Values {
    public static String appName = "Student Monitoring System";
    public static String instituteName = "MyInstitute";

    public static int windowHeight = 900;
    public static int windowWidth = 1400;
    public static int totstudents = 10;
    public static int totteachers = 16;
    public static int totClasses = 30;

    public String getInstituteName() {
        return instituteName;
    }

    public static void setInstituteName(String instituteName) {
        Values.instituteName = instituteName;
    }
}
