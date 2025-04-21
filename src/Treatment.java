public class Treatment {
    private String name;
    private String dateTime;
    private Physiotherapist physiotherapist;
    private Patient patient;

    public Treatment(String name, String dateTime, Physiotherapist physiotherapist) {
        this.name = name;
        this.dateTime = dateTime;
        this.physiotherapist = physiotherapist;
    }

    public void bookAppointment(Patient patient) {
        this.patient = patient;
    }

    public void cancelAppointment() {
        this.patient = null;
    }

    public String getName() {
        return name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Patient getPatient() {
        return patient;
    }
}
