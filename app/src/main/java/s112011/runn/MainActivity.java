package s112011.runn;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.firebase.client.Firebase;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private class Temp extends DAOEvent
    {
        @Override
        public void execute2(ProfileDTO profile) {

            System.out.println("test <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Test af firebase
        Firebase.setAndroidContext(this);
//        ProfileDTO pDto = PreferenceManager.getStoredValues();

//        System.out.println("din DTO er : " + pDto.getUsername() + pDto.getPassword() + pDto.getEmail());
        ProfileDAO p = new ProfileDAO();

        ProfileDTO pDTO = PrefManager.getStoredValues();

        System.out.println(">>>>>>>>>>>> -- <<<<<<<<<<<" + pDTO.getUsername() + pDTO.getId());


        setContentView(R.layout.activity_main);
        if (savedInstanceState==null) {
            Intent intent = new Intent(MainActivity.this, AgreementsList.class);
            startActivity(intent);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    private void onClikMinProfile(){

        Intent intent = new Intent(this, MinProfile.class);
        ProfileDTO pdto = new ProfileDTO();
        pdto.setUsername("Made by Amal)))");
        intent.putExtra("Profile", pdto);
        startActivity(intent);
       // intent.putExtra("id", 1);


       // try {
//            ProfileDTO p = new ProfileDAO().getProfile(1);
//            ProfileDTO p = new ProfileDTO();
//            p.setName("Favad");
//            Intent intent = new Intent(this, mp.getClass());
//
//
//            startActivity();
      /*  } catch (FirebaseDataException e) {
            e.printStackTrace();
        }
*/
/*
       Fragment fragment = new Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, fragment).addToBackStack(null).commit();*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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

}


