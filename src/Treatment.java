public class Treatment {
    private String name;
    private String dateTime;
    private Physiotherapist physiotherapist;
    private Patient patient;
    private boolean attended;

    public Treatment(String name, String dateTime, Physiotherapist physiotherapist) {
        this.name = name;
        this.dateTime = dateTime;
        this.physiotherapist = physiotherapist;
        this.attended = false;
    }

    public String getName() {
        return name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }

    public Patient getPatient() {
        return patient;
    }

    public boolean isAttended() {
        return attended;
    }

    public void bookAppointment(Patient patient) {
        this.patient = patient;
    }

    public void cancelAppointment() {
        this.patient = null;
    }

    public void markAttendance(boolean attended) {
        this.attended = attended; 
    }
}
