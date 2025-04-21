import java.util.List;

public class Booking {
    private List<Treatment> treatments;

    public Booking(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public boolean bookTreatment(String treatmentName, Patient patient) {
        for (Treatment t : treatments) {
            if (t.getName().equalsIgnoreCase(treatmentName) && t.getPatient() == null) {
                t.bookAppointment(patient);
                System.out.println("Booking confirmed for " + treatmentName);
                return true;
            }
        }
        System.out.println("Error: Treatment is unavailable or already booked.");
        return false;
    }

    public boolean cancelTreatment(String treatmentName, Patient patient) {
        for (Treatment t : treatments) {
            if (t.getName().equalsIgnoreCase(treatmentName) && t.getPatient() == patient) {
                t.cancelAppointment();
                System.out.println("Cancellation successful for " + treatmentName);
                return true;
            }
        }
        System.out.println("Error: No booking found for " + treatmentName);
        return false;
    }
}
