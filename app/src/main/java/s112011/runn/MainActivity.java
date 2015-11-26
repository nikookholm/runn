package s112011.runn;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment create =new ProfileCreation();
        getSupportFragmentManager().beginTransaction()
               .add(R.id.fragmentView, create )  // tom container i layout
               .commit();

        //Commit
        //HEHE
    }
}
