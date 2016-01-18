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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nehfi on 17-01-16.
 */
public class AgreementsList extends AppCompatActivity {

    ImageView imgLoc, imgEvent, imgPeople, imgPerson;
    List<tAgreementDTO> Agreements = new ArrayList<tAgreementDTO>();
    ListView lVAll, lvOwn;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_agreements);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("all");
        tabSpec.setContent(R.id.tabAll);
        tabSpec.setIndicator("Alle");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("own");
        tabSpec.setContent(R.id.tabOwn);
        tabSpec.setIndicator("Egne");
        tabHost.addTab(tabSpec);

        imgLoc = (ImageView) findViewById(R.id.imgLocation);
        imgEvent = (ImageView) findViewById(R.id.imgDate);

        lVAll = (ListView) findViewById(R.id.listVAll);
        lVAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                populateAllList();
            }
        });

        lvOwn = (ListView) findViewById(R.id.listVOwn);
        lvOwn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                populateOwnList();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent touchevent) {
        float lastX = 0;
        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                lastX = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP: {
                float currentX = touchevent.getX();
                // if left to right swipe on screen
                if (lastX < currentX)
                    switchTabs(false);
                // if right to left swipe on screen
                if (lastX > currentX)
                    switchTabs(true);

                break;
            }
        }
        return false;
    }

    public void switchTabs(boolean direction) {
        if (direction) // true = move left
        {
            if (tabHost.getCurrentTab() == 0)
                tabHost.setCurrentTab(tabHost.getTabWidget().getTabCount() - 1);
            else
                tabHost.setCurrentTab(tabHost.getCurrentTab() - 1);
        } else        // move right
        {
            if (tabHost.getCurrentTab() != (tabHost.getTabWidget()
                    .getTabCount() - 1))
                tabHost.setCurrentTab(tabHost.getCurrentTab() + 1);
            else
                tabHost.setCurrentTab(0);
        }
    }

    private void populateAllList(){
        ArrayAdapter<tAgreementDTO> adapter = new AgreementListAdapter();
        lVAll.setAdapter(adapter);
    }

    private void populateOwnList(){
        ArrayAdapter<tAgreementDTO> adapter = new AgreementListAdapter();
        lvOwn.setAdapter(adapter);
    }

    private class AgreementListAdapter extends ArrayAdapter<tAgreementDTO> {

        public AgreementListAdapter() {
            super(AgreementsList.this, R.layout.agreement_item, Agreements);
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup){
            if(view == null)
                view = getLayoutInflater().inflate(R.layout.agreement_item, viewGroup, false);

            tAgreementDTO currentAagreement = Agreements.get(position);

            TextView location = (TextView) view.findViewById(R.id.textViewLocationPlaceholder);
            TextView date = (TextView) view.findViewById(R.id.textViewDatePlaceholder);
            TextView description = (TextView) view.findViewById(R.id.textViewDescriptionPlaceholder);

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
