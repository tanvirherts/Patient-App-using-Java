import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ✅ Creating Physiotherapists
        Physiotherapist physio1 = new Physiotherapist("P001", "Dr. James Smith", "London", "123456789",
                List.of("Sports Therapy", "Rehabilitation"));

        Physiotherapist physio2 = new Physiotherapist("P002", "Dr. Emily Johnson", "Manchester", "987654321",
                List.of("Pain Management", "Post-Surgery Recovery"));


        // ✅ Creating Treatments and Assigning to Physiotherapists
        Treatment treatment1 = new Treatment("Back Pain Therapy", "2025-04-22 10:00 AM", physio1);
        Treatment treatment2 = new Treatment("Sports Injury Rehab", "2025-04-22 02:00 PM", physio1);
        Treatment treatment3 = new Treatment("Post-Surgery Recovery", "2025-04-22 11:00 AM", physio2);
        Treatment treatment4 = new Treatment("Pain Management Session", "2025-04-22 03:00 PM", physio2);

        physio1.addTreatment(treatment1);
        physio1.addTreatment(treatment2);
        physio2.addTreatment(treatment3);
        physio2.addTreatment(treatment4);

        // ✅ Creating Patients
        Patient patient1 = new Patient("PA001", "John Doe", "Birmingham", "555123456");
        Patient patient2 = new Patient("PA002", "Jane Smith", "Liverpool", "555654321");

        // ✅ Creating Booking System
        List<Treatment> allTreatments = new ArrayList<>(List.of(treatment1, treatment2, treatment3, treatment4));
        Booking bookingSystem = new Booking(allTreatments);

        // ✅ Menu to Handle Bookings
        while (true) {
            System.out.println("\nWelcome to Boost Physio Clinic");
            System.out.println("1. Book Treatment");
            System.out.println("2. Cancel Treatment");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Treatment Name: ");
                    String treatmentName = scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();

                    Patient patient = patientName.equalsIgnoreCase(patient1.getName()) ? patient1 :
                            patientName.equalsIgnoreCase(patient2.getName()) ? patient2 : null;

                    if (patient != null) {
                        boolean booked = bookingSystem.bookTreatment(treatmentName, patient);
                        System.out.println(booked ? "Booking successful!" : "Booking failed.");
                    } else {
                        System.out.println("Error: Patient not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Treatment Name: ");
                    String cancelName = scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String cancelPatientName = scanner.nextLine();

                    Patient cancelPatient = cancelPatientName.equalsIgnoreCase(patient1.getName()) ? patient1 :
                            cancelPatientName.equalsIgnoreCase(patient2.getName()) ? patient2 : null;

                    if (cancelPatient != null) {
                        boolean cancelled = bookingSystem.cancelTreatment(cancelName, cancelPatient);
                        System.out.println(cancelled ? "Cancellation successful!" : "Cancellation failed.");
                    } else {
                        System.out.println("Error: Patient not found.");
                    }
                    break;

                case 3:
                    List<Physiotherapist> physiotherapists = new ArrayList<>(List.of(physio1, physio2));
                    ClinicReport report = new ClinicReport(physiotherapists);
                    report.generateReport();
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
