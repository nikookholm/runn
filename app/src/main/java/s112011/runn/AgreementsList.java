package s112011.runn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nehfi on 17-01-16.
 */
public class AgreementsList extends AppCompatActivity {

    //ImageView imgLoc, imgEvent, imgUser;
    List<AgreementDTO> agreements;
    ProfileDAO profDAO;
    ProfileDTO profDTO;
    ListView lVAll, lvOwn;
    TabHost tabHost;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_agreements);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(getApplicationContext());

        AgreementDAO t = new AgreementDAO();
        t.getHotAgreementsAsync(new DAOEvent() {
            @Override
            public void getHotAgreements(List<AgreementDTO> agreements) {
                PopulateAgreementsList(agreements);
            }
        });

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpecAll = tabHost.newTabSpec("all");
        tabSpecAll.setContent(R.id.tabAll);
        tabSpecAll.setIndicator("Alle");
        tabHost.addTab(tabSpecAll);

        TabHost.TabSpec tabSpecOwn = tabHost.newTabSpec("own");
        tabSpecOwn.setContent(R.id.tabOwn);
        tabSpecOwn.setIndicator("Egne");
        tabHost.addTab(tabSpecOwn);

    }

    //Alle agreementDAOer
    //Alle ProfileDAOer

    private void PopulateAgreementsList(List<AgreementDTO> ListAgreementsDTO){
        agreements = ListAgreementsDTO;
        lVAll = (ListView) findViewById(R.id.listVAll);
        ArrayAdapter<AgreementDTO> adapter = new AgreementListAdapter();
        lVAll.setAdapter(adapter);
        lVAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "OnItemClick", Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(getBaseContext(), ShowAgreement.class);
                //startActivity(intent);
            }
        });
    }

    private class AgreementListAdapter extends ArrayAdapter<AgreementDTO> {
        ImageView imgLoc, imgEvent, imgUser;
        AgreementDTO currentAgreement;

        public AgreementListAdapter() {
            super(AgreementsList.this, R.layout.agreement_item, agreements);

            System.out.println(">>>>>>>>><<<<<<<<<<<< Super metode, agreementListAdapter");
        }
        @Override
        public View getView(int position, View view, ViewGroup viewGroup){
            if(view == null)
                view = getLayoutInflater().inflate(R.layout.agreement_item, viewGroup, false);

            System.out.println("-------------<<<<<<<<->>>>>>>>>> GETVIEW------------------------");

            imgEvent = (ImageView) view.findViewById(R.id.imgItemDate);
            imgEvent.setImageResource(R.drawable.ic_event_black_18dp);
            imgLoc = (ImageView) view.findViewById(R.id.imgLocation);
            imgLoc.setImageResource(R.drawable.ic_place_black_18dp);
            imgUser = (ImageView) view.findViewById(R.id.imgUser);
            imgUser.setImageResource(R.drawable.ic_person_black_18dp);

            currentAgreement = agreements.get(position);

            PopulateProfile(currentAgreement);

            System.out.println("------------------------------<<<<<<<ID: " + currentAgreement.getCreatedBy());

            TextView tTitle = (TextView) view.findViewById(R.id.textViewTitlePlaceholder);
            TextView tLocation = (TextView) view.findViewById(R.id.textViewLocationPlaceholder);
            TextView tUser = (TextView) view.findViewById(R.id.textViewUserPlaceholder);
            TextView tDate = (TextView) view.findViewById(R.id.textViewDatePlaceholder);

            tTitle.setText("" + currentAgreement.getTitle());
            tLocation.setText("" + currentAgreement.getLocation());
            tUser.setText("" + currentAgreement.getCreatedBy());
            tDate.setText("" + currentAgreement.getTime());
/*
            tTitle.setText("TITELLØØØØB");
            tLocation.setText("STEDDDETLØØB");
            tUser.setText("MickeyMouseDenUberAwesomme");
            tDate.setText("d24/8-2266");
*/
            return view;
        }

        private void PopulateProfile(AgreementDTO agreementDTO){
            agreementDTO = currentAgreement;
            System.out.println("!!!!!!!!!!!!!!!!!!!");
            try {
                profDAO.getProfileAsync(1, new DAOEvent(){
                    //currentAgreement.getCreatedBy()
                    @Override
                    public void getProfile(ProfileDTO profile) {
                        System.out.println("################");
                        //userName = profile.getUsername();
                        //if(userName==null)
                            //userName="FalskBrugernavn";
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("******************");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    ToolBar bar = new ToolBar(this);
        bar.t(item);
        return true;

    }

    private void onClikMinProfile() {

        Intent intent = new Intent(this, MinProfile.class);
        ProfileDTO pdto = new ProfileDTO();
//        pdto.setUsername("Made by Amal)))");
        intent.putExtra("Profile", pdto);boolean isPswdAMatch = false;
        startActivity(intent);
    }

    private void onClickTilføj(){
        Intent intent= new Intent(AgreementsList.this, CreateAgreement.class);
        startActivity(intent);

    }
    private void onClickSøg(){

    }
}
