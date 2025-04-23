import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<Treatment> treatments;
    private List<Patient> patients;

    public Booking(List<Treatment> treatments) {
        this.treatments = treatments;
        this.patients = new ArrayList<>();
    }


    public void addPatient(String id, String name, String address, String phone) {
        Patient newPatient = new Patient(id, name, address, phone);
        patients.add(newPatient);
        System.out.println("Patient added: " + newPatient.getName() + " (Address: " + newPatient.getAddress() + ")");
    }


    public void removePatient(String id) {
        boolean removed = patients.removeIf(patient -> patient.getId().equals(id));
        if (removed) {
            System.out.println("Patient with ID " + id + " has been removed.");
        } else {
            System.out.println("No patient found with ID " + id);
        }
    }


    public void listPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        for (Patient p : patients) {
            System.out.println(p.getId() + ": " + p.getName() + " (" + p.getPhone() + ", Address: " + p.getAddress() + ")");
        }
    }


    public Patient getPatientById(String id) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        System.out.println("Patient with ID " + id + " not found.");
        return null;
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


    public boolean markAttendance(String treatmentName, Patient patient) {
        for (Treatment t : treatments) {
            if (t.getName().equalsIgnoreCase(treatmentName) && t.getPatient() == patient) {
                t.markAttendance(true); // Set attendance status to true
                System.out.println("Attendance marked for " + treatmentName);
                return true;
            }
        }
        System.out.println("Error: No booking found for " + treatmentName);
        return false;
    }


    public void checkAttendance(String treatmentName) {
        for (Treatment t : treatments) {
            if (t.getName().equalsIgnoreCase(treatmentName)) {
                String status = t.isAttended() ? "Attended" : "Not Attended";
                System.out.println("Treatment: " + treatmentName + " | Status: " + status);
                return;
            }
        }
        System.out.println("Error: Treatment not found.");
    }
}
