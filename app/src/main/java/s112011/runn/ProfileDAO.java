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

    public ProfileDAO()
    {
        fb = new Firebase(FirebaseConnection.URL + "/profiles");
    }

    public void saveProfileAsync(final ProfileDTO profile, final DAOEvent event) throws FirebaseException
    {
        Runnable runThis = new Runnable() {
            @Override
            public void run() {

                Query q = fb;

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int count = (int)(dataSnapshot.getChildrenCount() + 1);
                        fb.child(String.valueOf(count)).setValue(profile);
                        event.saveProfile(profile);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        throw new FirebaseException("No data received!");
                    }
                });


            }
        };

        runThis.run();

    }

    public void updateProfile(ProfileDTO profile, final DAOEvent event) throws FirebaseException
    {
        // Mangler implmentering
    }

    public void loginAsync(String email, final String password, final DAOEvent event) throws FirebaseException
    {

        final String thisEmail = email;

        Runnable runThis = new Runnable() {
            @Override
            public void run() {

                Query q = fb.orderByChild("email").equalTo(thisEmail).limitToFirst(1);

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        ProfileDTO p = null;
                        for (DataSnapshot d : dataSnapshot.getChildren())
                        {
                            p = d.getValue(ProfileDTO.class);

                        }

                        if (p != null)
                        {
                            if (password.toLowerCase().equals(p.getPassword().toLowerCase()))
                            {
                                event.login(p);
                            }
                            else
                            {
                                throw new FirebaseException("Password er forkert");
                            }
                        }
                        else
                        {
                            throw new FirebaseException("Bruger findes ikke");
                        }

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        throw new FirebaseException("Ingen data fra serveren");
                    }
                });
            }
        };

        runThis.run();

    }

    public void getProfileAsync(int id, final DAOEvent event) throws FirebaseException {

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
                        System.out.println(newP.getUsername() + "?!?!?!?!?!?!?!?!?!?!?!");
                        thisEvent.getProfile(newP);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        throw new FirebaseException("No matching data ... ");
                    }
                });
            }
        };

        runThis.run();

    }
}