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

    public ProfileDAO()
    {
        fb = new Firebase("https://dazzling-inferno-7067.firebaseio.com/profiles");
    }

    public ProfileDTO getProfile(final int id) throws FirebaseDataException
    {
        Query q = fb.orderByChild("id").equalTo(id).limitToFirst(1);

        final ProfileDTO profile = new ProfileDTO();

        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ProfileDTO t = dataSnapshot.child(String.valueOf(id)).getValue(ProfileDTO.class);

                profile.setId(t.getId());
                profile.setEmail(t.getEmail());
                profile.setLevel(t.getLevel());
                profile.setDateCreated(t.getDateCreated());
                profile.setUsername(t.getUsername());
                profile.setDescription(t.getDescription());
                profile.setPassword(t.getPassword());
                profile.setPosLat(t.getPosLat());
                profile.setPosLong(t.getPosLong());

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }

        });

        if (profile.getUsername() != "")
        {
            return profile;
        }
        else
        {
            throw new FirebaseDataException("No profile recieved!");
        }

    }

    public boolean saveProfile(ProfileDTO profile)
    {
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
            } catch (FirebaseDataException e) {
                e.printStackTrace();
            }
        }

        return profiles;

    }

}
