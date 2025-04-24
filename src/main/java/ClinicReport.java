import java.util.List;

public class ClinicReport {
    private List<Physiotherapist> physiotherapists;

    public ClinicReport(List<Physiotherapist> physiotherapists) {
        this.physiotherapists = physiotherapists;
    }

    public void generateReport() {
        System.out.println("\n### Clinic Report ###");
        System.out.println("Treatments available and booking status:");

        for (Physiotherapist physiotherapist : physiotherapists) {
            System.out.println("\nPhysiotherapist: " + physiotherapist.getName());
            for (Treatment treatment : physiotherapist.getTreatments()) {
                System.out.println("Treatment: " + treatment.getName() + " | Date & Time: " + treatment.getDateTime() +
                        " | Status: " + (treatment.getPatient() != null ? "Booked" : "Available"));
            }
        }

        System.out.println("\n### Physiotherapist Booking Stats ###");
        for (Physiotherapist physiotherapist : physiotherapists) {
            int bookedCount = 0;
            for (Treatment treatment : physiotherapist.getTreatments()) {
                if (treatment.getPatient() != null) {
                    bookedCount++;
                }
            }
            System.out.println(physiotherapist.getName() + " has " + bookedCount + " booked treatments.");
        }
    }
}
