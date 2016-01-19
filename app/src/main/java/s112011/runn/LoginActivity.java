package s112011.runn;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Firebase.setAndroidContext(a);

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

    }

    private void onLoginSucces(ProfileDTO p) {

        System.out.println("din password " + textPassword.getText() + "email " + textEmail.getText() + "Username " + p.getUsername());
//        PrefManager.StoreValues(p);

        Intent intent = new Intent(a, MainActivity.class);
        startActivity(intent);

    }

    public class LoginClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

//            if (textPassword.getText().length() != 0 && textEmail.getText().length() != 0) {

//            } else {
//                Toast toast = Toast.makeText(getApplicationContext(), "Your must enter Email and Password",
//                        Toast.LENGTH_LONG);
//                toast.show();
//            }

            pDAO = new ProfileDAO();

            try {

                ProfileDTO pDTO = pDAO.login(textEmail.getText().toString(), textPassword.getText().toString());
                onLoginSucces(pDTO);

                System.out.println("din email " + pDTO.getEmail() + pDTO.getId());
            } catch (FirebaseDataException e) {
                Toast toast = Toast.makeText(getApplicationContext(), "Your must enter Email and Password",
                        Toast.LENGTH_LONG);
                toast.show();
                System.out.println("Firebase fejler" + e.getMessage());
            }
        }
    }

    public static void hidenot(Activity activity){
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromInputMethod(activity.getCurrentFocus().getWindowToken(), 1);

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
    }
}
