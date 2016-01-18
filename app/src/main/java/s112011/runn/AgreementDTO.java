package s112011.runn;

/**
 * Created by nehfi on 11-01-16.
 */
public class AgreementDTO {

    String location, date, time, description;
    int participants, distance;
    boolean repeat;

    AgreementDTO(String location, String date, String time, String description, int participants, int distance, boolean repeat){
        this.location = location;
        this.date = date;
        this.time = time;
        this.description = description;
        this.participants = participants;
        this.distance = distance;
        this.repeat = repeat;
    }

    public String getLocation(){ return location; }
    public String getDate(){ return date; }
    public String getTime(){ return time; }
    public String getDescription(){ return description; }
    public int getParticipants(){ return participants; }
    public int getDistance(){ return distance; }
    public boolean getRepeat(){ return repeat; }
}
