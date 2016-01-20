package s112011.runn;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
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

   // public static android.content.Context app = LoginActivity.getContextOfApplication();

    Activity act;

    public ToolBar(Activity act) {

        this.act = act;




    }


    private void onClickTilføj(){
        Intent intent= new Intent(act , CreateAgreement.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        act.startActivity(intent);

    }

    private void onClikMinProfile() {

        Intent intent1 = new Intent(act, MinProfile.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.putExtra("Profile", new ProfileDTO());
        act.startActivity(intent1);
    }

    public  void t(MenuItem item){


        switch (item.getItemId()) {
            case android.R.id.home:
                act.onBackPressed();
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
                Intent intent = new Intent(act,LoginActivity.class );
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                act.startActivity(intent);
                break;
            default:
        }
    }

}
