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
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.List;

/**
 * Created by nehfi on 17-01-16.
 */
public class AgreementsList extends AppCompatActivity {

    //ImageView imgLoc, imgEvent, imgUser;
    List<AgreementDTO> agreements;
    ProfileDAO prfDAO;
    ProfileDTO prfDTO;
    ListView lVAll, lvOwn;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_agreements);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(getApplicationContext());

        AgreementDAO t = new AgreementDAO();
        agreements = t.getHotAgreements();

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

//Intent intent = new Intent(view.getContext(), ShowAgreement.class);
                //startActivity(intent);

        /***
         * Til videre implementering
         */
        /*
        lvOwn = (ListView) findViewById(R.id.listVOwn);
        lvOwn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
        */

    }

/*     private void populateAllList(){
        ArrayAdapter<tAgreementDTO> adapter = new AgreementListAdapter();
        lVAll.setAdapter(adapter);
    }

    private void populateOwnList(){
        //Til Videre implementering!
    }
*/

    private class AgreementListAdapter extends ArrayAdapter<AgreementDTO> {
        ImageView imgLoc, imgEvent, imgUser;
        public AgreementListAdapter() {
            super(AgreementsList.this, R.layout.agreement_item, agreements);

        }
        @Override
        public View getView(int position, View view, ViewGroup viewGroup){
            //if(view == null)
                view = getLayoutInflater().inflate(R.layout.agreement_item, viewGroup, false);

            imgEvent = (ImageView) view.findViewById(R.id.imgItemDate);
            imgEvent.setImageResource(R.drawable.ic_event_black_18dp);
            imgLoc = (ImageView) view.findViewById(R.id.imgLocation);
            imgLoc.setImageResource(R.drawable.ic_place_black_18dp);
            imgUser = (ImageView) view.findViewById(R.id.imgUser);
            imgUser.setImageResource(R.drawable.ic_person_black_18dp);

            AgreementDTO currentAagreement = agreements.get(position);
/*
            try {
                prfDTO = prfDAO.getProfile(currentAagreement.getCreatedBy());
            } catch (FirebaseDataException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String userName = prfDTO.getUsername();
*/
            TextView tTitle = (TextView) view.findViewById(R.id.textViewTitlePlaceholder);
            TextView tLocation = (TextView) view.findViewById(R.id.textViewLocationPlaceholder);
            TextView tUser = (TextView) view.findViewById(R.id.textViewUserPlaceholder);
            TextView tDate = (TextView) view.findViewById(R.id.textViewDatePlaceholder);

            tTitle.setText(currentAagreement.getTitle());
            tLocation.setText(currentAagreement.getLocation());
           // tUser.setText(userName);
            tUser.setText("MickeyMouseDenUberAwesomme");
            tDate.setText("" + currentAagreement.getTime());

            return view;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.søg:
                onSearchRequested();
                break;
            case R.id.tilføj:
                onClickTilføj();
                break;
            case R.id.indstilling:
                //?????
                break;
            case R.id.MinProfil:
                onClikMinProfile();
                break;
            case R.id.logud:
                Intent intent = new Intent(this,LoginActivity.class );
                startActivity(intent);
                break;
        }
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
