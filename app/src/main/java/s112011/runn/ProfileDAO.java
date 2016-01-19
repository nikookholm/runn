package s112011.runn;
import android.os.AsyncTask;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.FirebaseException;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niko Okholm on 12-01-2016.
 */

public class ProfileDAO {

    private Firebase fb;
    private ProfileDTO profile;

    public ProfileDAO()
    {
        fb = new Firebase(FirebaseConnection.URL + "/profiles");
    }

//    public ProfileDTO getProfile(final int id) throws FirebaseDataException, InterruptedException
//    {
//        final Query q = fb.orderByChild("id").equalTo(id).limitToFirst(1);
//
//        Runnable runThis = new Runnable() {
//            @Override
//            public void run() {
//
//                q.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        profile = dataSnapshot.child(String.valueOf(id)).getValue(ProfileDTO.class);
//                        System.out.println("Got this from db ----> " + profile.getUsername());
//                    }
//
//                    @Override
//                    public void onCancelled(FirebaseError firebaseError) {
//                    }
//
//                });
//
//            }
//        };
//
//        runThis.run();
//        runThis.wait();
//
//        return profile;
//    }


    public void saveProfileAsync(final ProfileDTO profile, final DAOEvent event) throws FirebaseDataException
    {
        Runnable runThis = new Runnable() {
            @Override
            public void run() {

                Query q = fb.child("profiles");

                fb.child("profiles").setValue(profile);
                event.saveProfile(profile);

            }
        };

        runThis.run();

    }

//    public List<ProfileDTO> getProfiles(int[] ids)
//    {
//
//        ArrayList<ProfileDTO> profiles = new ArrayList<ProfileDTO>();
//        ProfileDTO t;
//
//        for(int id : ids)
//        {
//            try {
//                profiles.add(getProfile(id));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        return profiles;
//
//    }

    public ProfileDTO login(String email, String password) throws FirebaseDataException
    {
        ProfileDTO p = new ProfileDTO(4, "Fede Fahvad", "musmus", "@", 3, 33, "test", 3, 3);
        if (email.equals(p.getEmail()) && password.equals(p.getPassword()))
        {
            return p;
        }
        else
        {
            throw new FirebaseException("Login er forkert, sucker!");
        }

    }

    public void getProfileAsync(int id, final DAOEvent event) throws FirebaseDataException {

        final int thisId = id;
        final DAOEvent thisEvent = event;

        Runnable runThis = new Runnable()
        {
            @Override
            public void run() {

                System.out.println("Tryna' catch me, " + thisId);
                Query q = fb.orderByChild("id").equalTo(thisId).limitToFirst(1);

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ProfileDTO newP = dataSnapshot.child(String.valueOf(thisId)).getValue(ProfileDTO.class);
                        thisEvent.getProfile(newP);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        try {
                            throw new FirebaseDataException("No matching data ... ");
                        } catch (Exception e) {

                        }
                    }
                });


            }
        };

        runThis.run();

    }
}