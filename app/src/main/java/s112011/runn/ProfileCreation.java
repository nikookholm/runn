package s112011.runn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileCreation extends AppCompatActivity  {

    Button cancel, create;
    TextView getnaemText, getEmailText, getPasswordText1, getPasswordText2;
    String getPasswordText;
    public Activity activity = this;
    public Activity a = this;
    ProfileDTO pDTO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_creation_part_one);



        create = (android.widget.Button) findViewById(R.id.createBtn);
        create.setOnClickListener(new Createlistener());

        getnaemText = (TextView) findViewById(R.id.userName);
        getnaemText.setOnClickListener(new NameClickListener());

        getEmailText = (TextView) findViewById(R.id.createEmail);
        getEmailText.setOnClickListener(new EmailClickListener());

        getPasswordText1 = (TextView) findViewById(R.id.newPassword);
        getPasswordText1.setOnClickListener(new Password1ClickListener());

        getPasswordText2 = (TextView)findViewById(R.id.newPasswor2);
        getPasswordText2.setOnClickListener(new Password2ClickListener());

        cancel= (Button) findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(new CancelListener());

    }

    private void onCreate(ProfileDTO pDTO) {
        if (getnaemText.getText().length() != 0 && getEmailText.getText().length() != 0 &&
                getPasswordText1.getText().length() != 0 && getPasswordText2.getText().length() != 0 ) {

            PrefManager.StoreValues(pDTO);

            ProfileDAO pDAO = new ProfileDAO();

            try {
                pDAO.saveProfileAsync(pDTO, new DAOEvent(){

                    @Override
                    public void saveProfile(ProfileDTO profile) {
                        Intent goToMainMenu = new Intent(a, AgreementsList.class);
                        startActivity(goToMainMenu);
                    }
                });

            } catch (FirebaseDataException e) {
                e.printStackTrace();
            }
        }
    }

    public class Createlistener  implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            int id = 2;
            int level = 3;
            long dataCreate = 444444;
            String description = " description";
            double posLat = 5.5;
            double posLong = 5.5;


            if (getnaemText.getText().length() == 0 && getEmailText.getText().length() == 0 &&
                    getPasswordText1.getText().length() == 0 && getPasswordText2.getText().length() == 0 ) {
                Toast toast = Toast.makeText(getApplicationContext(), "Alle felterne er ikke udfyldt",
                        Toast.LENGTH_LONG);
                toast.show();
            }

            if (getPasswordText1.getText().toString().equals(getPasswordText2.getText().toString())) {

                getPasswordText = getPasswordText1.toString();


                ProfileDTO profileDTO = new ProfileDTO(id,
                        getnaemText.getText().toString(),
                        getPasswordText,
                        getEmailText.getText().toString(),
                        level, dataCreate,
                        description,
                        posLat,
                        posLong);
                onCreate(profileDTO);

            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Password matcher ikke",
                        Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }

    public class  CancelListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            onBackPressed();


        }
    }
    public class EmailClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
    public class NameClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
    public class Password1ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
    public class Password2ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
