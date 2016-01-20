package s112011.runn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by amal on 14/01/16.
 */
public class ToolBar extends AppCompatActivity{


    private void onClickTilføj(){
        Intent intent= new Intent(ToolBar.this, CreateAgreement.class);
        startActivity(intent);

    }

    private void onClikMinProfile() {

        Intent intent = new Intent(this, MinProfile.class);
        intent.putExtra("Profile", new ProfileDTO());
        startActivity(intent);
    }

    public  void t(MenuItem item){

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
            default:
        }
    }

}
