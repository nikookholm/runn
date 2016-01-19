package s112011.runn;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;

/**
 * Created by onepiece on 18/01/16.
 */
public class PrefManager {

    public static android.content.Context applicationContext = LoginActivity.getContextOfApplication();
    public static SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(applicationContext);



    //    public static SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(new Application().getApplicationContext());
    public static ProfileDTO getStoredValues(){

        ProfileDTO pDTO = new ProfileDTO();

        int level = 0;
        long dateCreated = 0;
        float posLat = 0;

        pDTO.setId(myPrefs.getInt("id", 0));
        pDTO.setUsername(myPrefs.getString("username", "kunne ikke finde bruger"));
        pDTO.setPassword(myPrefs.getString("password", "password findes ikke"));
        pDTO.setEmail(myPrefs.getString("email", "email findes ikke"));
        pDTO.setLevel(myPrefs.getInt("level", level));
        pDTO.setDateCreated(myPrefs.getLong("dateCreated", dateCreated));
        pDTO.setDescription(myPrefs.getString("description", "kunne ikke finde beskrivelse"));
        pDTO.setPosLat(myPrefs.getFloat("posLat", posLat));
        pDTO.setPosLong(myPrefs.getFloat("posLong", (float) pDTO.getPosLong()));

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
