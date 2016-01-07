package s112011.runn;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment create =new listAgreements();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentView, create )  // tom container i layout
                .commit();
       //addPreferencesFromResour(R.xml.indstilling, );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void onClickTilføj(){
        Intent intent= new Intent(MainActivity.this, CreateAgreement.class);
        startActivity(intent);

    }
    private void onClickSøg(){

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.tilbag:
                onBackPressed();
            break;
            case R.id.søg:
                onSearchRequested();
                break;

            case R.id.tilføj:
                onClickTilføj();
                break;
            case R.id.indstilling:
                break;


        }
        return true;

    }
}


