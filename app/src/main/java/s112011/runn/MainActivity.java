package s112011.runn;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
ImageButton search, createAppoint, settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       

        Fragment create =new showProfil();
        getSupportFragmentManager().beginTransaction()
               .add(R.id.fragmentView, create )  // tom container i layout
               .commit();
// NEJNEJ
        //Commit
        //HEHE
    }
}
//NEEJee
