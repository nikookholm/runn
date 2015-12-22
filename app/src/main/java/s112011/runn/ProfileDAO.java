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

         profiles.add(new ProfileDTO( "Lone Andersen", "København", "Jeg løber hverdag, hele tiden ", "24/12/2015 17:30"));
         profiles.add(  new ProfileDTO( "Jacob Bajop", "Odense", "løber Odense tyndt i weekenden", "27/12/2015 8:00"));
         profiles.add(  new ProfileDTO( "Amal Jamal", "Kabul", "Jeg er nybegynder!, vil løbe lørdag", "27/12/2015 12:00"));
         profiles.add(   new ProfileDTO("Favad Kvavad", "Brøndby", " En af Brøndbys slemme drenge, løber og løber" ,"28/12/2015 13:00"));
         profiles.add(  new ProfileDTO( "Niko Diko", "Nordsjælland", "snupper et halv maraton søndag aften", "28/12/2015 17:00"));
         profiles.add(new ProfileDTO( "Lone Andersen", "København", "Jeg løber hverdag, hele tiden ", "3/1/2016 17:30"));
         profiles.add(  new ProfileDTO( "Jacob Bajop", "Odense", "løber Odense tyndt i weekenden", "3/1/2016 8:00"));
         profiles.add(  new ProfileDTO( "Amal Jamal", "Kabul", "Jeg er nybegynder!, vil løbe lørdag", "6/1/2016 12:00"));
         profiles.add(   new ProfileDTO("Favad Kvavad", "Brøndby", " En af Brøndbys slemme drenge, løber og løber" ,"6/1/2016 13:00"));
         profiles.add(  new ProfileDTO( "Niko Diko", "Nordsjælland", "snupper et halv maraton søndag aften", "10/1/2016 17:00"));


    }

    public ArrayList<ProfileDTO> getProfiles(){
        return profiles;
    }


}
