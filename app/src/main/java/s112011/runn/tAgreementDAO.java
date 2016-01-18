package s112011.runn;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niko Okholm on 15-01-2016.
 */
public class tAgreementDAO {

    private Firebase fb;
    List<tAgreementDTO> agreements;

    public tAgreementDAO()
    {

        fb = new Firebase(FirebaseConnection.URL + "runs");

        agreements = new ArrayList<tAgreementDTO>();
        //int id, long createdTime, int createdBy, String description, int distance, String location, int participants, long time, String title
        agreements.add(new tAgreementDTO(42, 43, 44, "YaYOOOOHU", 45, "Hille", 46, 47, "Det blir sååå fedt!"));
        agreements.add(new tAgreementDTO(1, 1, 1, "Da", 1, "Hølle", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new tAgreementDTO(1, 1, 1, "Bø", 1, "Sælle", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new tAgreementDTO(1, 1, 1, "Nå", 1, "Molle", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new tAgreementDTO(1, 1, 1, "description", 1, "location", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new tAgreementDTO(1, 1, 1, "description", 1, "location", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new tAgreementDTO(1, 1, 1, "description", 1, "location", 1, 1, "Det blir sååå fedt!"));

    }

    public boolean saveAgreement(tAgreementDTO Agreement)
    {
        return false;
    }

    public tAgreementDTO getAgreement(int agreementId) throws FirebaseDataException
    {
        Query q = fb.orderByChild("id").equalTo(agreementId).limitToFirst(1);

        final tAgreementDTO agreement = new tAgreementDTO();

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.getChildren())
                {
                    tAgreementDTO t = new tAgreementDTO();
                    agreement.setId(t.getId());
                    agreement.setCreatedBy(t.getCreatedBy());
                    agreement.setCreatedTime(t.getCreatedTime());
                    agreement.setDescription(t.getDescription());
                    agreement.setDistance(t.getDistance());
                    agreement.setLocation(t.getLocation());
                    agreement.setParticipants(t.getParticipants());
                    agreement.setTime(t.getTime());
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        if (agreement.getDescription() != "")
        {
            return agreement;
        } else
        {
            throw new FirebaseDataException("No agreement found!");
        }

    }

    public List<tAgreementDTO> getHotAgreements()
    {
        return agreements;
    }

}