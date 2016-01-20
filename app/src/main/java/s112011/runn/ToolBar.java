package s112011.runn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

/**
 * Created by amal on 14/01/16.
 */
public class ToolBar {

    public static android.content.Context app = LoginActivity.getContextOfApplication();


    private void onClickTilføj(){
        Intent intent= new Intent(app , CreateAgreement.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        app.startActivity(intent);

    }

    private void onClikMinProfile() {

        Intent intent1 = new Intent(app, MinProfile.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.putExtra("Profile", new ProfileDTO());
        app.startActivity(intent1);
    }

    public  void t(MenuItem item){


        switch (item.getItemId()) {
            case android.R.id.home:

                //onBackPressed();
                break;
            case R.id.søg:
              //  app.onSearchRequested();
                break;

            case R.id.tilføj:
                onClickTilføj();
                break;
            case R.id.indstilling:
                break;
            case R.id.MinProfil:
                onClikMinProfile();
                break;
            case R.id.logud:
                Intent intent = new Intent(app,LoginActivity.class );
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                app.startActivity(intent);
                break;
            default:
        }
    }

}
