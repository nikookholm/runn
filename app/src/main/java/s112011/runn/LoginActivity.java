package s112011.runn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login, create;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.button3);
        login.setOnClickListener(this);

        create = (Button) findViewById(R.id.button4);
        create.setOnClickListener(this);

        logo = (ImageView) findViewById(R.id.imageView3);
        logo.setImageResource(R.mipmap.runapplogo_n);
    }

    @Override
    public void onClick(View v) {
        if (v == login) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (v == create) {
            Intent intent = new Intent(this, ProfileCreation.class);
            startActivity(intent);
        }

    }
}
