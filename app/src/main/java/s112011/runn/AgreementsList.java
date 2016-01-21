package s112011.runn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import com.firebase.client.Firebase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nehfi on 17-01-16.
 */
public class AgreementsList extends AppCompatActivity {

    List<AgreementDTO> agreements;
    ListView listViewAll;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_agreements);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Firebase.setAndroidContext(getApplicationContext());

        AgreementDAO t = new AgreementDAO();
        t.getHotAgreementsAsync(new DAOEvent() {
            @Override
            public void getHotAgreements(List<AgreementDTO> agreements) {
                populateAgreementsList(agreements);
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

    private void populateAgreementsList(List<AgreementDTO> ListAgreementsDTO){
        agreements = ListAgreementsDTO;
        listViewAll = (ListView) findViewById(R.id.listVAll);
        ArrayAdapter<AgreementDTO> adapter = new AgreementListAdapter();
        listViewAll.setAdapter(adapter);
        listViewAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), ShowAgreement.class);
                intent.putExtra("agreement", agreements.get(position));
                startActivity(intent);
            }
        });
    }

    private class AgreementListAdapter extends ArrayAdapter<AgreementDTO> {
        ImageView imgLoc, imgEvent, imgUser;
        TextView tTitle, tLocation, tUser, tDate;
        AgreementDTO currentAgreement;
        ProfileDAO profDAO;

        String userName;
        Date date;
        String agreementDate;

        public AgreementListAdapter() {
            super(AgreementsList.this, R.layout.agreement_item, agreements);
        }
        @Override
        public View getView(int position, View view, ViewGroup viewGroup){
            if(view == null)
                view = getLayoutInflater().inflate(R.layout.agreement_item, viewGroup, false);

            imgEvent = (ImageView) view.findViewById(R.id.imgItemDate);
            imgEvent.setImageResource(R.drawable.ic_event_black_18dp);
            imgLoc = (ImageView) view.findViewById(R.id.imgLocation);
            imgLoc.setImageResource(R.drawable.ic_place_black_18dp);
            imgUser = (ImageView) view.findViewById(R.id.imgUser);
            imgUser.setImageResource(R.drawable.ic_person_black_18dp);

            currentAgreement = agreements.get(position);
            populateProfile(currentAgreement);

            date = new Date(currentAgreement.getTime());
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
            agreementDate = simpleDate.format(date);

            tTitle = (TextView) view.findViewById(R.id.textViewTitlePlaceholder);
            tLocation = (TextView) view.findViewById(R.id.textViewLocationPlaceholder);
            tUser = (TextView) view.findViewById(R.id.textViewUserPlaceholder);
            tDate = (TextView) view.findViewById(R.id.textViewDatePlaceholder);

            return view;
        }

        private void populateProfile(AgreementDTO agreementDTO){
            agreementDTO = currentAgreement;
            profDAO = new ProfileDAO();

            try {
                profDAO.getProfileAsync(currentAgreement.getCreatedBy(), new DAOEvent(){
                    @Override
                    public void getProfile(ProfileDTO profile) {
                        userName = profile.getUsername();
                        populateTextViews();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void populateTextViews(){
            tTitle.setText("" + currentAgreement.getTitle());
            tLocation.setText("" + currentAgreement.getLocation());
            tUser.setText("" + userName);
            tDate.setText("" + agreementDate);
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

}
