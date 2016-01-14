package s112011.runn;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.List;

/**
 * Created by Niko Okholm on 12-01-2016.
 */
public class ProfileDAO {

    private Firebase fb;

    public ProfileDAO()
    {
        //fb = new Firebase(FirebaseConnection.URL + "profiles");
    }

    public ProfileDTO getProfile(int id) throws FirebaseDataException {
//
//
//        Query q = fb.orderByChild("id");
//
//        final ProfileDTO profile = new ProfileDTO();
//
//        q.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                ProfileDTO t = dataSnapshot.getValue(ProfileDTO.class);
//                System.out.println(t.getUsernaame());
//
//                profile.setId(t.getId());
//                profile.setEmail(t.getEmail());
//                profile.setLevel(t.getLevel());
//                profile.setDateCreated(t.getDateCreated());
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//
//        });

//        if (profile.getName() != "")
//        {
//            return profile;
//        }
//        else
//        {
//            throw new FirebaseDataException("No profile recieved!");
//        }

        return null;



    }

    public boolean saveProfile(ProfileDTO profile)
    {
        return false;
    }

    public List<ProfileDTO> getProfiles(int[] ids)
    {
        return null;
    }



}
