package s112011.runn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by amal on 11/01/16.
 */

public class MinProfile extends AppCompatActivity {

    Button okBtn, annullerBtn;
    TextView name, email;
    ProfileDTO thisProfile;


    public MinProfile() {
       /* Intent intent = getIntent();
        try {
            thisProfile = new ProfileDAO().getProfile(intent.getIntExtra("id", -666));
        } catch (FirebaseDataException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_creation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spriner = (Spinner) findViewById(R.id.spinnerLevel);
        spriner.setOnItemClickListener(new SpinnerListener());
        List<String> level = new ArrayList<>();
        level.add("Lav");
        level.add("Middel");
        level.add("Høj");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, level);
        spriner.setAdapter(dataAdapter);

        okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new OkButtonListner());

        annullerBtn = (Button) findViewById(R.id.annullerBtn);
        annullerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });


        name = (TextView) findViewById(R.id.profileName);
        name.setText(thisProfile.getUsername());
         email = (TextView) findViewById(R.id.emailProfile);

    }

    //indeClass til onItemClickListener
    private class SpinnerListener implements AdapterView.OnItemClickListener{


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), "selected: " + item, Toast.LENGTH_LONG).show();

        }
    }
    //indeKlass til buttons
    private  class  OkButtonListner implements View.OnClickListener{

        @Override
        public void onClick(View v) {

       /*     ProfileDAO dao = new ProfileDAO();
            ProfileDTO profile = new ProfileDTO(2,
                    name.getText().toString(),
                    "password", email.getText().toString(), 3, 43434334);*/

            //dao.update(profile);
        }
    }
    private  class  PictureListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {





        }
    }


}


































