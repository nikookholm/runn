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
 * Created by Niko Okholm on 15-01-2016.
 */
public class AgreementDAO {

    private Firebase fb;
    List<AgreementDTO> agreements;

    public AgreementDAO()
    {
        fb = new Firebase(FirebaseConnection.URL + "/runs");
    }

    public void getAgreementAsync(int id, final DAOEvent event) throws FirebaseException
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

        runThis.run();
    }

    public void getHotAgreementsAsync(DAOEvent event) throws FirebaseException
    {
        final DAOEvent thisEvent = event;

        Runnable runThis = new Runnable() {
            @Override
            public void run() {

                Query q = fb.orderByChild("runs").limitToFirst(10);

                q.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        List<AgreementDTO> as = new ArrayList<AgreementDTO>();

                        for (DataSnapshot d : dataSnapshot.getChildren())
                        {
                            as.add(d.getValue(AgreementDTO.class));
                        }

                        thisEvent.getHotAgreements(as);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        try {
                            throw new FirebaseDataException("No agreements");
                        } catch (FirebaseDataException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        };

        runThis.run();
    }

    public void saveAgreementAsync(final AgreementDTO agreement, DAOEvent event) throws FirebaseException {

        final DAOEvent thisEvent = event;

        Runnable runThis = new Runnable() {
            @Override
            public void run() {

                Query q = fb;

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int count = (int) (dataSnapshot.getChildrenCount() + 1);
                        fb.child(String.valueOf(count)).setValue(agreement);
                        thisEvent.saveAgreement(agreement);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }

        };

    }

    public void updateAgreement(AgreementDTO agreementDTO, final DAOEvent event) throws FirebaseException
    {

    }

}