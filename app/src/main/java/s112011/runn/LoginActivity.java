package s112011.runn;

import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.content.SharedPreferences;
        import android.preference.PreferenceManager;

import com.firebase.client.Firebase;

public class LoginActivity extends AppCompatActivity {
    Button login, create;
    ImageView logo;
    TextView textPassword, textEmail;
    public Activity a = this;
    ProfileDAO pDAO;
    SharedPreferences myPrefs;
    SharedPreferences.Editor editor;

    // email er @
    // password musmus

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new LoginClickListener());

        create = (Button) findViewById(R.id.brugerButton);
        create.setOnClickListener(new CreateClickListener());

        logo = (ImageView) findViewById(R.id.imageView3);
        logo.setImageResource(R.mipmap.runapplogo_n);

        textEmail = (TextView) findViewById(R.id.textEmail);
        textEmail.setOnClickListener(new EmailClickListener());

        textPassword = (TextView) findViewById(R.id.textPassword);
        textPassword.setOnClickListener(new PasswordClickListener());



//        ProfileDAO profileDAO = new ProfileDAO();
//        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);

    }

    private void onLoginSucces() {
        if (textPassword.getText().length() != 0 && textEmail.getText().length() != 0) {
            Intent intent = new Intent(a, MainActivity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Your must enter an Email and Password",
                    Toast.LENGTH_LONG);
            toast.show();
        }
        Intent intent = new Intent(a, MainActivity.class);
        startActivity(intent);
    }

    public class LoginClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == login) {
//                try {
//                    pDAO = new ProfileDAO();
//                    pDAO.login(textEmail.getText().toString(), textPassword.getText().toString());
//                    Firebase.setAndroidContext(a);
//                    System.out.println("Email og password er gemt!");
//                } catch (Exception e) {
//                    System.out.println("Firebase fejler" + e);
//                }
//                myPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                editor = myPrefs.edit();

////                onLoginSucces();
                Intent intent = new Intent(a, MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public class CreateClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == create) {
                Intent goToProfileCreation = new Intent(a, ProfileCreation.class);
                startActivity(goToProfileCreation);
            }

        }
    }

    public class EmailClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

    public class PasswordClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
//    }
    }
}
