import java.util.ArrayList;
import java.util.List;

public class Physiotherapist {
    private String id;
    private String name;
    private String address;
    private String phone;
    public List<String> expertise;
    private List<Treatment> treatments;

    public Physiotherapist(String id, String name, String address, String phone, List<String> expertise) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.expertise = expertise;
        this.treatments = new ArrayList<>();
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }
}
