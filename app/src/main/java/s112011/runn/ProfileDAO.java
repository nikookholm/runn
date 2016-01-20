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

    public void getProfiles(int[] ids, DAOEvent event) throws FirebaseDataException
    {

        final int[] thisIds = ids;
        final DAOEvent thisEvent = event;

        Runnable runThis = new Runnable()
        {
            @Override
            public void run() {

                try {
                    throw new FirebaseDataException("Er ved at blive implementeret");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };

        runThis.run();

    }

    public void loginAsync(String email, final String password, final DAOEvent event) throws FirebaseDataException
    {

        final String thisEmail = email;

        Runnable runThis = new Runnable() {
            @Override
            public void run() {

                Query q = fb.orderByChild("email").equalTo(thisEmail).limitToFirst(1);

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        ProfileDTO p = new ProfileDTO();
                        for (DataSnapshot d : dataSnapshot.getChildren())
                        {
                            p = d.getValue(ProfileDTO.class);

                        }
                        if (p.getPassword().equals(password))
                        {
                            event.login(p);
                        }
                        else
                        {
                            try {
                                throw new FirebaseDataException("Password matcher ikke");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        try {
                            throw new FirebaseDataException("Kunne ikke logge ind!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                });
            }
        };

        runThis.run();

    }

    public void getProfileAsync(int id, final DAOEvent event) throws FirebaseDataException {

        final int thisId = id;
        final DAOEvent thisEvent = event;

        Runnable runThis = new Runnable()
        {
            @Override
            public void run() {

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