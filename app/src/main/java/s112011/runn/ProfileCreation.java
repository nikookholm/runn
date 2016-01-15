package s112011.runn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileCreation extends AppCompatActivity  {

    Button cancel, create;
    TextView getnaemText, getEmailText, getPasswordText, getPasswordText2, getPasswordText1;
    public Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_creation_part_one);



        create = (android.widget.Button) findViewById(R.id.createBtn);
        create.setOnClickListener(new Createlistener());

        getnaemText = (TextView) findViewById(R.id.userName);

        getEmailText = (TextView) findViewById(R.id.createEmail);

        getPasswordText1 = (TextView) findViewById(R.id.newPassword);

        getPasswordText2 = (TextView)findViewById(R.id.newPasswor2);

        cancel= (Button) findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(new CancelListener());

    }


    public class  CancelListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            onBackPressed();


        }
    }


    public  class Createlistener  implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            if (v==create) {
                int id = 2;
                int level = 3;
                long dataCreate = 444444;
                String description = " description";
                double posLat = 5.5;
                double posLong = 5.5;

                if(getPasswordText1 != getPasswordText2) {

                    onBackPressed();
                }

                getPasswordText = getPasswordText1;


                ProfileDTO profileDTO = new ProfileDTO(id,
                        getnaemText.getText().toString(),
                        getPasswordText.getText().toString(),
                        getEmailText.getText().toString(),
                        level, dataCreate,
                        description,
                        posLat,
                        posLong);

                Intent intent = new Intent(activity, MainActivity.class);
                startActivity(intent);




            }
        }
    }
}
