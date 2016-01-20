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
public class AgreementDAO {

    private Firebase fb;
    List<AgreementDTO> agreements;

    public AgreementDAO()
    {

        fb = new Firebase(FirebaseConnection.URL + "/runs");

        agreements = new ArrayList<AgreementDTO>();
        //int id, long createdTime, int createdBy, String description, int distance, String location, int participants, long time, String title
        agreements.add(new AgreementDTO(42, 43, 44, "YaYOOOOHU", 45, "Hille", 46, 47, "Det blir sååå fedt!"));
        agreements.add(new AgreementDTO(1, 1, 1, "Da", 1, "Hølle", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new AgreementDTO(1, 1, 1, "Bø", 1, "Sælle", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new AgreementDTO(1, 1, 1, "Nå", 1, "Molle", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new AgreementDTO(1, 1, 1, "description", 1, "location", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new AgreementDTO(1, 1, 1, "description", 1, "location", 1, 1, "Det blir sååå fedt!"));
        agreements.add(new AgreementDTO(1, 1, 1, "description", 1, "location", 1, 1, "Det blir sååå fedt!"));

    }

    public boolean saveAgreement(AgreementDTO Agreement)
    {
        return false;
    }

//    public AgreementDTO getAgreement(int agreementId) throws FirebaseDataException
//    {
//        Query q = fb.orderByChild("id").equalTo(agreementId).limitToFirst(1);
//
//        final AgreementDTO agreement = new AgreementDTO();
//
//        q.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot d : dataSnapshot.getChildren())
//                {
//                    AgreementDTO t = new AgreementDTO();
//                    agreement.setId(t.getId());
//                    agreement.setCreatedBy(t.getCreatedBy());
//                    agreement.setCreatedTime(t.getCreatedTime());
//                    agreement.setDescription(t.getDescription());
//                    agreement.setDistance(t.getDistance());
//                    agreement.setLocation(t.getLocation());
//                    agreement.setParticipants(t.getParticipants());
//                    agreement.setTime(t.getTime());
//                }
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//
//        if (agreement.getDescription() != "")
//        {
//            return agreement;
//        } else
//        {
//            throw new FirebaseDataException("No agreement found!");
//        }
//
//    }

    public void getAgreementAsync(int id, final DAOEvent event)
    {
        final int thisId = id;
        final DAOEvent thisEvent = event;

        Runnable runThis = new Runnable() {
            @Override
            public void run() {

                Query q = fb.orderByChild("runs").equalTo(thisId).limitToFirst(1);

                q.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        AgreementDTO a = dataSnapshot.getValue(AgreementDTO.class);

                        event.getAgreement(a);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }
        };
    }

    public List<AgreementDTO> getHotAgreements()
    {
        return agreements;
    }

    public void saveAgreementAsync(final AgreementDTO agreement, DAOEvent event)
    {

        final DAOEvent thisEvent = event;

        Runnable runThis = new Runnable()
        {
            @Override
            public void run() {

                Query q = fb.orderByChild("runs");

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        try {
                            agreement.setId((int)dataSnapshot.getChildrenCount() + 1);
                            System.out.println("Så mange agreements: " + dataSnapshot.getChildrenCount());
                            fb.child("runs").setValue(agreement);
                            thisEvent.getAgreement(agreement);
                        }
                        catch (Exception e)
                        {

                        }
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