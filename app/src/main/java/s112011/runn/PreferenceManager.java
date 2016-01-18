package s112011.runn;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by onepiece on 18/01/16.
 */
public class PreferenceManager {


    static ProfileDTO getStoredValues(){


        return null;
    }


    static void StoreValues(ProfileDTO pDTO){


//        myPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        editor = myPrefs.edit();
        int level = 0;
        long dateCreated = 0;
        float posLat = 0;
        float posLong = 0;



        SharedPreferences myPrefs = android.preference.PreferenceManager.getDefaultSharedPreferences(new Application().getApplicationContext());
        SharedPreferences.Editor editor = myPrefs.edit();

        myPrefs.getInt("id", pDTO.getId());
        editor.putInt("id", pDTO.getId()).commit();

        myPrefs.getString("username", "kunne ikke finde bruger");
        editor.putString("username", pDTO.getUsername()).commit();

        myPrefs.getString("password", "password findes ikke");
        editor.putString("password", pDTO.getPassword()).commit();

        myPrefs.getString("email", "email findes ikke");
        editor.putString("email", pDTO.getEmail()).commit();

        myPrefs.getInt("level", level);
        editor.putInt("level", pDTO.getLevel()).commit();

        myPrefs.getLong("dateCreated", dateCreated);
        editor.putLong("dateCreated", pDTO.getDateCreated()).commit();

        myPrefs.getString("description", "kunne ikke finde beskrivelse");
        editor.putString("description", pDTO.getDescription()).commit();

        myPrefs.getFloat("posLat", posLat);
        editor.putFloat("postLat", (float) pDTO.getPosLat()).commit();

        myPrefs.getFloat("posLong", (float) pDTO.getPosLong());
        editor.putFloat("posLong", posLong);


    }
}
