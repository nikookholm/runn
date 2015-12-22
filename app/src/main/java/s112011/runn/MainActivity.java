package s112011.runn;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
ImageButton search, createAppoint, settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (ImageButton) findViewById(R.id.imageButton);
        search.setImageResource(R.drawable.ic_search_black_48dp);


        createAppoint = (ImageButton) findViewById(R.id.imageButton2);
        createAppoint.setImageResource(R.drawable.ic_add_black_48dp);
        createAppoint.setElevation(2);
        createAppoint.setOnClickListener(this);


        settings = (ImageButton) findViewById(R.id.imageButton3);
        settings.setImageResource(R.drawable.ic_settings_applications_black_48dp);

        Fragment create =new listAgreements();
        getSupportFragmentManager().beginTransaction()
               .add(R.id.fragmentView, create )  // tom container i layout
               .commit();

    }

    @Override
    public void onClick(View v) {
        if(v == createAppoint){
            Fragment create =new AgreementCreate();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentView, create)  // tom container i layout
                    .commit();
        }
    }
}

