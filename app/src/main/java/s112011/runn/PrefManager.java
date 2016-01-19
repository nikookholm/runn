package s112011.runn;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by onepiece on 18/01/16.
 */
public class PrefManager {

    public static SharedPreferences myPrefs = android.preference.PreferenceManager.getDefaultSharedPreferences(new Application().getApplicationContext());
    public static ProfileDTO getStoredValues(){

        ProfileDTO pDTO = new ProfileDTO();


        int level = 0;
        long dateCreated = 0;
        float posLat = 0;

        SharedPreferences myPrefs = android.preference.PreferenceManager.getDefaultSharedPreferences(new Application().getApplicationContext());

        myPrefs.getInt("id", pDTO.getId());
        myPrefs.getString("username", "kunne ikke finde bruger");
        myPrefs.getString("password", "password findes ikke");
        myPrefs.getString("email", "email findes ikke");
        myPrefs.getInt("level", level);
        myPrefs.getLong("dateCreated", dateCreated);
        myPrefs.getString("description", "kunne ikke finde beskrivelse");
        myPrefs.getFloat("posLat", posLat);
        myPrefs.getFloat("posLong", (float) pDTO.getPosLong());

        return pDTO;
    }


    public static void StoreValues(ProfileDTO pDTO){

        float posLong = 0;

        System.out.println(" ><<<<<<<<<<<<<<<<<<<<<<<<<<<< ude ");
        SharedPreferences.Editor editor = myPrefs.edit();
        System.out.println(" <<<<<<<<<<<<<<< vi er inde i myPrefs.edit");

        editor.putInt("id", pDTO.getId()).commit();
        editor.putString("username", pDTO.getUsername()).commit();
        editor.putString("password", pDTO.getPassword()).commit();
        editor.putString("email", pDTO.getEmail()).commit();
        editor.putInt("level", pDTO.getLevel()).commit();
        editor.putLong("dateCreated", pDTO.getDateCreated()).commit();
        editor.putString("description", pDTO.getDescription()).commit();
        editor.putFloat("postLat", (float) pDTO.getPosLat()).commit();
        editor.putFloat("posLong", posLong);


    }
}
