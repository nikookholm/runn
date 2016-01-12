package s112011.runn;

import android.widget.ImageView;

import java.io.File;
import java.io.Serializable;

/**
 * Created by KimDrewes on 26-11-2015.
 */
public class ProfileDTO implements Serializable {

    String name, location,date, description;

    public ProfileDTO(String name, String location, String description, String date){

        this.name = name;
        this.location = location;
        this.date = date;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getDate(){return date;}
    public String getDescription(){return description;}

}
