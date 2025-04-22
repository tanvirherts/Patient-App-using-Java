import java.util.List;
import java.util.Comparator;

public class ClinicReport {
    private List<Physiotherapist> physiotherapists;

    public ClinicReport(List<Physiotherapist> physiotherapists) {
        this.physiotherapists = physiotherapists;
    }

    private static int applyAsInt(Physiotherapist p) {
        return (int) Math.toIntExact(p.getTimetable()
                .stream()
                .filter(t -> t.getPatient() != null)
                .count());
    }

    public void generateReport() {
        System.out.println("Boost Physio Clinic - Appointment Report:");


        for (Physiotherapist physiotherapist : physiotherapists) {
            Physiotherapist p;
            p = (Physiotherapist) physiotherapist;

            System.out.println("\nPhysiotherapist: " + p.getName());

            List<Treatment> timetable = p.getTimetable();
            if (timetable == null || timetable.isEmpty()) {
                System.out.println("No treatments available.");
                continue;
            }

            for (Treatment t : timetable) {
                String status = (t.getPatient() == null) ? "Available" : "Booked by " + t.getPatient().getName();
                System.out.println(t.getName() + " - " + t.getDateTime() + " - " + status);
            }
        }






        System.out.println("\nPhysiotherapists sorted by attended appointments:");
        physiotherapists.stream()
                .filter(p -> p.getTimetable() != null)
                .sorted(Comparator.comparingInt(ClinicReport::applyAsInt).reversed())
                .forEach(p -> System.out.println(p.getName()));
    }
}
