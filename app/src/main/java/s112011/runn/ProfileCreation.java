package s112011.runn;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileCreation extends AppCompatActivity implements View.OnClickListener {

    Button cancel, create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_creation_part_one);

        cancel = (android.widget.Button) findViewById(R.id.button2);
        cancel.setOnClickListener(this);

        create= (Button) findViewById(R.id.button);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

    }

    @Override
    public void onClick(View v) {

            Intent intent = new Intent(this,MainActivity.class );
            startActivity(intent);



    }
}
