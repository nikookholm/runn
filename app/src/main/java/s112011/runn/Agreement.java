package s112011.runn;

/**
 * Created by nehfi on 17-01-16.
 */
public class Agreement {

    private String location, date, description;

    public Agreement(String location, String date, String description) {
        this.location = location;
        this.date = date;
        this.description = description;
    }

    public String getLocation(){ return location; }
    public String getDate(){ return date; }
    public String getDescription(){ return description; }

}
