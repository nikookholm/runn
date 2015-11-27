package s112011.runn;

import android.widget.ImageView;

import java.io.File;
import java.io.Serializable;

/**
 * Created by KimDrewes on 26-11-2015.
 */
public class ProfileDTO implements Serializable {

    String picID;
    String name, location;

    public ProfileDTO(String PicID, String name, String location){
        this.picID = picID;
        this.name = name;
        this.location = location;
    }

    public String picID(){
        return picID;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }

}
