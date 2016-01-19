package s112011.runn;
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

    public void getProfileAsync(int id, DAOEvent event) throws FirebaseDataException {
        final Query q = fb.orderByChild("id").equalTo(id).limitToFirst(1);
        final ProfileDTO p = new ProfileDTO();
        final FirebaseError fe;

        final DAOEvent e = event;

        Runnable runThis = new Runnable() {

            @Override
            public void run() {

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

//                        System.out.println("Vis mig !!!");
//                        ProfileDTO p2 = dataSnapshot.getValue(profile.getClass());
//
//                        p.setId(p2.getId());
//                        p.setUsername(p2.getUsername());
//                        p.setPassword(p2.getPassword());
//                        p.setEmail(p2.getEmail());
//                        p.setLevel(p2.getLevel());
//                        p.setDateCreated(p2.getDateCreated());
//                        p.setDescription(p2.getDescription());
//                        p.setPosLat(p2.getPosLong());
//                        p.setPosLong(p2.getPosLong());

                        System.out.println("Just BEFORE success!");
                        e.execute2(p);
                        System.out.println("Just AFTER success!");

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }

        };
        runThis.run();
    }

}