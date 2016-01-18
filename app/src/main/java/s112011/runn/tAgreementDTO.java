package s112011.runn;

/**
 * Created by Niko Okholm on 15-01-2016.
 */
public class tAgreementDTO {


    private int    id;
    private long   createdTime;
    private int    createdBy;
    private String description;
    private int    distance;
    private String location;
    private int    participants;
    private long   time;

    public tAgreementDTO()
    {

    }

    public tAgreementDTO(int id, long createdTime, int createdBy, String description, int distance, String location, int participants, long time)
    {
        this.id = id;
        this.createdTime = createdTime;
        this.createdBy = createdBy;
        this.description = description;
        this.distance = distance;
        this.location = location;
        this.participants = participants;
        this.time = time;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
    public int getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getParticipants() {
        return participants;
    }
    public void setParticipants(int participants) {
        this.participants = participants;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }

}
