package s112011.runn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
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
    List<tAgreementDTO> agreements;
    ListView lVAll, lvOwn;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_agreements);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(getApplicationContext());

        tAgreementDAO t = new tAgreementDAO();
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

        //imgEvent = (ImageView) findViewById(R.id.imgDate);
        //imgEvent.setImageResource(R.drawable.ic_event_white_24dp);
        //imgLoc = (ImageView) findViewById(R.id.imgLocation);
        //imgLoc.setImageResource(R.drawable.ic_place_white_48dp);
        //imgUser = (ImageView) findViewById(R.id.imgUser);
        //imgUser.setImageResource(R.drawable.ic_person_white_48dp);

        lVAll = (ListView) findViewById(R.id.listVAll);
        lVAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });

        populateAllList();


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

     private void populateAllList(){
        ArrayAdapter<tAgreementDTO> adapter = new AgreementListAdapter();
        lVAll.setAdapter(adapter);
    }

    private void populateOwnList(){
        //Til Videre implementering!
    }

    private class AgreementListAdapter extends ArrayAdapter<tAgreementDTO> {
        ImageView imgLoc, imgEvent, imgUser;
        public AgreementListAdapter() {
            super(AgreementsList.this, R.layout.agreement_item, agreements);

        }
        @Override
        public View getView(int position, View view, ViewGroup viewGroup){
            //if(view == null)
                view = getLayoutInflater().inflate(R.layout.agreement_item, viewGroup, false);

            imgEvent = (ImageView) findViewById(R.id.imgItemDate);
            //imgEvent.setImageResource(R.drawable.ic_event_white_24dp);

            tAgreementDTO currentAagreement = agreements.get(position);

            TextView tTitle = (TextView) view.findViewById(R.id.textViewTitlePlaceholder);
            TextView tLocation = (TextView) view.findViewById(R.id.textViewLocationPlaceholder);
            TextView tUser = (TextView) view.findViewById(R.id.textViewUserPlaceholder);
            TextView tDate = (TextView) view.findViewById(R.id.textViewDatePlaceholder);

            tTitle.setText(currentAagreement.getTitle());
            tLocation.setText(currentAagreement.getLocation());
            tUser.setText("" + currentAagreement.getCreatedBy());
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
        pdto.setUsername("Made by Amal)))");
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
