package s112011.runn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by amal on 11/01/16.
 */

public class MinProfile extends AppCompatActivity {

    Button okBtn, annullerBtn;
    ImageView choicePicture, takePicture;
    TextView name, email;
    ProfileDTO thisProfile;
    Spinner lvl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        thisProfile = (ProfileDTO) intent.getSerializableExtra("Profile");



        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_creation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spriner = (Spinner) findViewById(R.id.spinnerLevel);
        List<String> level = new ArrayList<>();
        level.add("Lav");
        level.add("Middel");
        level.add("Høj");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, level);
        spriner.setAdapter(dataAdapter);




//        spriner.setOnItemClickListener(new SpinnerListener());

        okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new OkButtonListner());

        annullerBtn = (Button) findViewById(R.id.annullerBtn);
        annullerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        choicePicture = (ImageView) findViewById(R.id.picture);
        choicePicture.setOnClickListener(new PictureListener());

        name = (TextView) findViewById(R.id.profileName);
        name.setText(thisProfile.getUsername());

        email = (TextView) findViewById(R.id.emailProfile);
        email.setText(thisProfile.getEmail());

        lvl = (Spinner) findViewById(R.id.spinnerLevel);
        lvl.setSelection(thisProfile.getLevel());








        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TableLayout tableLayout = new TableLayout(this);

      //  choicePicture = (Button) findViewById(R.id.picture);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        ToolBar tb = new ToolBar();
        tb.t(item);
        return  true;
    }


    //indeClass til onItemClickListener
    private class SpinnerListener implements AdapterView.OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), "selected: " + item, Toast.LENGTH_LONG).show();

        }
    }

    //indeKlass til buttons
    private class OkButtonListner implements View.OnClickListener {

        @Override
        public void onClick(View v) {

       /*     ProfileDAO dao = new ProfileDAO();
            ProfileDTO profile = new ProfileDTO(2,
                    name.getText().toString(),
                    "password", email.getText().toString(), 3, 43434334);*/

            //dao.update(profile);
        }
    }

    private class PictureListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {





        }
    }


}





