import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Physiotherapist physio1 = new Physiotherapist("P001", "Dr. James Smith", "London", "123456789",
                List.of("Sports Therapy", "Rehabilitation"));

        Physiotherapist physio2 = new Physiotherapist("P002", "Dr. Emily Johnson", "Manchester", "987654321",
                List.of("Pain Management", "Post-Surgery Recovery"));


        Treatment treatment1 = new Treatment("Back Pain Therapy", "2025-04-22 10:00 AM", physio1);
        Treatment treatment2 = new Treatment("Sports Injury Rehab", "2025-04-22 02:00 PM", physio1);
        Treatment treatment3 = new Treatment("Post-Surgery Recovery", "2025-04-22 11:00 AM", physio2);
        Treatment treatment4 = new Treatment("Pain Management Session", "2025-04-22 03:00 PM", physio2);

        physio1.addTreatment(treatment1);
        physio1.addTreatment(treatment2);
        physio2.addTreatment(treatment3);
        physio2.addTreatment(treatment4);


        List<Treatment> allTreatments = new ArrayList<>(List.of(treatment1, treatment2, treatment3, treatment4));
        Booking bookingSystem = new Booking(allTreatments);


        while (true) {
            System.out.println("\nWelcome to Boost Physio Clinic");
            System.out.println("1. Manage Treatments (Book/Cancel)");
            System.out.println("2. Manage Patients (Add/Remove/List)");
            System.out.println("3. Generate Report");
            System.out.println("4. Manage Attendance (Mark/Check)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Book Treatment");
                    System.out.println("2. Cancel Treatment");
                    System.out.print("Choose an option: ");
                    int treatmentChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (treatmentChoice == 1) {
                        System.out.print("Enter Treatment Name: ");
                        String treatmentName = scanner.nextLine();
                        System.out.print("Enter Patient ID: ");
                        String patientID = scanner.nextLine();
                        Patient bookingPatient = bookingSystem.getPatientById(patientID);

                        if (bookingPatient != null) {
                            boolean booked = bookingSystem.bookTreatment(treatmentName, bookingPatient);
                            System.out.println(booked ? "Booking successful!" : "Booking failed.");
                        } else {
                            System.out.println("Error: Patient not found.");
                        }
                    } else if (treatmentChoice == 2) {
                        System.out.print("Enter Treatment Name: ");
                        String cancelName = scanner.nextLine();
                        System.out.print("Enter Patient ID: ");
                        String cancelPatientID = scanner.nextLine();
                        Patient cancelPatient = bookingSystem.getPatientById(cancelPatientID);

                        if (cancelPatient != null) {
                            boolean cancelled = bookingSystem.cancelTreatment(cancelName, cancelPatient);
                            System.out.println(cancelled ? "Cancellation successful!" : "Cancellation failed.");
                        } else {
                            System.out.println("Error: Patient not found.");
                        }
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 2:
                    System.out.println("1. Add Patient");
                    System.out.println("2. Remove Patient");
                    System.out.println("3. List Patients");
                    System.out.print("Choose an option: ");
                    int patientChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (patientChoice == 1) {
                        System.out.print("Enter Patient ID: ");
                        String newPatientID = scanner.nextLine();
                        System.out.print("Enter Patient Name: ");
                        String newPatientName = scanner.nextLine();
                        System.out.print("Enter Patient Address: ");
                        String newPatientAddress = scanner.nextLine();
                        System.out.print("Enter Patient Phone: ");
                        String newPatientPhone = scanner.nextLine();
                        bookingSystem.addPatient(newPatientID, newPatientName, newPatientAddress, newPatientPhone);
                    } else if (patientChoice == 2) {
                        System.out.print("Enter Patient ID to remove: ");
                        String removeID = scanner.nextLine();
                        bookingSystem.removePatient(removeID);
                    } else if (patientChoice == 3) {
                        bookingSystem.listPatients();
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 3:
                    List<Physiotherapist> physiotherapists = new ArrayList<>(List.of(physio1, physio2));
                    ClinicReport report = new ClinicReport(physiotherapists);
                    report.generateReport();
                    break;

                case 4:
                    System.out.println("1. Mark Attendance");
                    System.out.println("2. Check Attendance");
                    System.out.print("Choose an option: ");
                    int attendanceChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (attendanceChoice == 1) {
                        System.out.print("Enter Treatment Name: ");
                        String attendanceTreatmentName = scanner.nextLine();
                        System.out.print("Enter Patient ID: ");
                        String attendancePatientID = scanner.nextLine();
                        Patient attendancePatient = bookingSystem.getPatientById(attendancePatientID);

                        if (attendancePatient != null) {
                            boolean marked = bookingSystem.markAttendance(attendanceTreatmentName, attendancePatient);
                            System.out.println(marked ? "Attendance marked successfully!" : "Failed to mark attendance.");
                        } else {
                            System.out.println("Error: Patient not found.");
                        }
                    } else if (attendanceChoice == 2) {
                        System.out.print("Enter Treatment Name to check attendance: ");
                        String checkTreatmentName = scanner.nextLine();
                        bookingSystem.checkAttendance(checkTreatmentName);
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
