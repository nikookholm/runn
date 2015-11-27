package s112011.runn;

import android.app.Activity;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by KimDrewes on 26-11-2015.
 */
public class ProfileDAO{



    public ArrayList<ProfileDTO> profiles;


     public  ProfileDAO(){
         profiles = new ArrayList<ProfileDTO>();

         profiles.add(new ProfileDTO( "R.mipmap.a", "Lone Anderse", "København"));
         profiles.add(  new ProfileDTO( "R.mipmap.b", "Amal Jamal", "Kabul"));
         profiles.add(  new ProfileDTO( "R.mipmap.c", "Jacob Bajop", "Odense"));
         profiles.add(   new ProfileDTO( "R.mipmap.d", "Favad Kvavad", "Brøndby"));
         profiles.add(  new ProfileDTO( "R.mipmap.e", "Niko Diko", "Nordsjælland"));


    }

    public ArrayList<ProfileDTO> getProfiles(){
        return profiles;
    }


}
