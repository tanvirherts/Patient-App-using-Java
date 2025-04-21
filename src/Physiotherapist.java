import java.util.ArrayList;
import java.util.List;

public class Physiotherapist {
    private String id;
    private String name;
    private String address;
    private String phone;
    private List<String> expertise;
    private List<Treatment> timetable;
    private List<Physiotherapist> physiotherapists;

    public Physiotherapist(String id, String name, String address, String phone, List<String> expertise) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.expertise = expertise;
        this.timetable = new ArrayList<>(); // ✅ Fix: Prevent null errors
    }

    public void setTimetable(List<Treatment> timetable) {
        this.timetable = timetable;
    }

    public void addTreatment(Treatment treatment) { // ✅ Fix: Allow adding treatments individually
        this.timetable.add(treatment);
    }

    public List<Treatment> getTimetable() {
        return timetable;
    }

    public List<String> getExpertise() {
        return expertise;
    }

    public String getName() {
        return name;
    }
}
