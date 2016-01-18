package s112011.runn;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
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

    public ProfileDTO getProfile(final int id) throws FirebaseDataException, InterruptedException
    {
        final Query q = fb.orderByChild("id").equalTo(id).limitToFirst(1);

        Runnable runThis = new Runnable() {
            @Override
            public void run() {

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        profile = dataSnapshot.child(String.valueOf(id)).getValue(ProfileDTO.class);
                        System.out.println("Got this from db ----> " + profile.getUsername());
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }

                });

                System.out.println(profile.getUsername());
            }
        };

        runThis.run();
        runThis.wait();

        return profile;
    }


    public boolean saveProfile(ProfileDTO profile) throws FirebaseDataException, InterruptedException
    {
        Runnable thisRunnable = new Runnable() {
            @Override
            public void run() {

                Query q = fb.orderByChild("what");

                // Code for setting shit up...
            }
        };

        thisRunnable.run();
        thisRunnable.wait();

        return false;
    }

    public List<ProfileDTO> getProfiles(int[] ids)
    {

        ArrayList<ProfileDTO> profiles = new ArrayList<ProfileDTO>();
        ProfileDTO t;

        for(int id : ids)
        {
            try {
                profiles.add(getProfile(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return profiles;

    }

    public ProfileDTO login(String email, String password) throws FirebaseDataException
    {
        //Query q =

        throw new FirebaseDataException("Login er ikke færdig :'(");

    }

    public void getProfileAsync(DAOEvent event)
    {
        final Query q = fb.orderByChild("id").equalTo(id).limitToFirst(1);


        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                profile = dataSnapshot.child(String.valueOf(id)).getValue(ProfileDTO.class);
                System.out.println("Got this from db ----> " + profile.getUsername());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }

        });

        System.out.println(profile.getUsername());

    }
}