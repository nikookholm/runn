package s112011.runn;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ShowAgreement extends AppCompatActivity implements View.OnClickListener {

    ImageView ivUser, ivMap;
    Button accept, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_agreement);

        ivUser = (ImageView) findViewById(R.id.ivUser);
        ivMap = (ImageView) findViewById(R.id.ivMap);

        accept = (Button) findViewById(R.id.createBtn);
        accept.setOnClickListener(this);
        cancel = (Button) findViewById(R.id.buttonCancel);
        cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       if(view == accept){
            Toast.makeText(getApplicationContext(), "Du er tilmeldt aftalen", Toast.LENGTH_LONG).show();
        }
        else if(view == cancel){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
