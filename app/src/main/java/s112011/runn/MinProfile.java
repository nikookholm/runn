package s112011.runn;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.FirebaseException;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by amal on 11/01/16.
 */

public class MinProfile extends AppCompatActivity implements View.OnClickListener{

    Button okBtn, cancelBtn , choicePicture, takePicture, createPhoto, crop_image;

    TextView name, email, password, password2, createPassword,description;
    ProfileDTO thisProfile;

    Spinner lvl;
    private int takePictureID = 123;
    private int cameraID = 321;
    private int cropId = 132;
    private File file;
    ImageView photo1;
    TableRow tableRow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        thisProfile = PrefManager.getStoredValues();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_creation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spriner = (Spinner) findViewById(R.id.spinnerLevel);
        List<String> level = new ArrayList<>();
        level.add("Lav");
        level.add("Middel");
        level.add("Høj");
       /* ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, level);
        spriner.setAdapter(dataAdapter);
*/



//        spriner.setOnItemClickListener(new SpinnerListener());

        okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new OkListener());

        cancelBtn = (Button) findViewById(R.id.annullerBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tableRow = (TableRow) findViewById(R.id.tb2);

        choicePicture = (Button) findViewById(R.id.choicePhoto);
        choicePicture.setVisibility(View.INVISIBLE);
        choicePicture.setOnClickListener(this);

        takePicture =(Button) findViewById(R.id.camera);
        takePicture.setVisibility(View.INVISIBLE);
        takePicture.setOnClickListener(this);

        crop_image = (Button) findViewById(R.id.cropImage);
        crop_image.setVisibility(View.INVISIBLE);
        crop_image.setOnClickListener(this);

        name = (TextView) findViewById(R.id.profileName);
        name.setText(thisProfile.getUsername());
        name.setEnabled(false);

        email = (TextView) findViewById(R.id.emailProfile);
        email.setText(thisProfile.getEmail());

        lvl = (Spinner) findViewById(R.id.spinnerLevel);
        lvl.setSelection(thisProfile.getLevel());

        password = (TextView) findViewById(R.id.kode1);
        password.setVisibility(View.INVISIBLE);
        password.setText(thisProfile.getPassword());

        password2 = (TextView) findViewById(R.id.kode2);
        password2.setVisibility(View.INVISIBLE);
        password2.setText(thisProfile.getPassword());

        findViewById(R.id.Klb1).setVisibility(View.INVISIBLE);
        findViewById(R.id.Kl2).setVisibility(View.INVISIBLE);

        photo1 =(ImageView) findViewById(R.id.pictureT);



        createPhoto =(Button) findViewById(R.id.create_Photo);
        createPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicePicture.setVisibility(View.VISIBLE);
                takePicture.setVisibility(View.VISIBLE);
                createPhoto.setVisibility(View.INVISIBLE);

            }
        });

        createPassword = (Button)findViewById(R.id.create_password);
        createPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setVisibility(View.VISIBLE);
                password2.setVisibility(View.VISIBLE);
                createPassword.setVisibility(View.INVISIBLE);
                findViewById(R.id.Klb1).setVisibility(View.VISIBLE);
                findViewById(R.id.Kl2).setVisibility(View.VISIBLE);

            }
        });

        description = (TextView) findViewById(R.id.descriptionText);
        description.setText(thisProfile.getDescription());







        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        ToolBar tb = new ToolBar(this);
        tb.t(item);
        return  true;
    }

        @Override
        public void onClick(View v) {
            try {

                if (v == choicePicture) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    startActivityForResult(intent, takePictureID);
                    choicePicture.setVisibility(View.INVISIBLE);
                    takePicture.setVisibility(View.INVISIBLE);
                    createPhoto.setVisibility(View.VISIBLE);
                    Toast toast = Toast.makeText(getApplicationContext(), "vent venligst",
                            Toast.LENGTH_LONG);
                    toast.show();

                } else if (v == takePicture) {

                    Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    file = new File(Environment.getExternalStorageDirectory(), "billede.png");
                    intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                    startActivityForResult(intent2, cameraID);

                    choicePicture.setVisibility(View.INVISIBLE);
                    takePicture.setVisibility(View.INVISIBLE);
                    createPhoto.setVisibility(View.INVISIBLE);
                    crop_image.setVisibility(View.VISIBLE);
                    Toast toast = Toast.makeText(getApplicationContext(), "husk beskær billedet beefter!",
                            Toast.LENGTH_LONG);
                    toast.show();
                } else if (v == crop_image) {
                    if (file == null) {
                        Toast.makeText(this, "Vælg først et billede", Toast.LENGTH_LONG).show();
                        return;
                    }
                    Uri photoUri = Uri.fromFile(file);
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(photoUri, "image/*");
                    intent.putExtra("crop", "true");
                    intent.putExtra("aspectX", 2);
                    intent.putExtra("aspectY", 2);
                    intent.putExtra("outputX", 200);
                    intent.putExtra("outputY", 160);
                    intent.putExtra("return-data", true);
                    startActivityForResult(intent, cropId);

                    choicePicture.setVisibility(View.INVISIBLE);
                    takePicture.setVisibility(View.INVISIBLE);
                    createPhoto.setVisibility(View.VISIBLE);
                    crop_image.setVisibility(View.INVISIBLE);
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://developer.android.com/reference/android/content/Intent.html")));


                }
            } catch (Exception e){
                Toast.makeText(this, "Denne telefon mangler en funktion:\n" + e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent dataI) {



            if (resultCode == Activity.RESULT_OK) {

                try {
                     if (requestCode == takePictureID) {

                         AssetFileDescriptor fileDescriptor = getContentResolver()
                                 .openAssetFileDescriptor(dataI.getData(), "r");
                          Bitmap bitmap = BitmapFactory.decodeStream(fileDescriptor.createInputStream());

                         photo1.setImageBitmap(bitmap);


                     }  else if (requestCode == cameraID) {
                        if (file == null) {
                            Bitmap bmp = (Bitmap) dataI.getExtras().get("data");
                            photo1.setImageBitmap(bmp);

                        } else {
                            Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                                bitmap.setHeight(24);
                                bitmap.setWidth(24);
                            }
                            photo1.setImageBitmap(bitmap);
                        }

                    } else if(requestCode == cropId){
                         Bitmap bitmap = (Bitmap) dataI.getExtras().get("data");
                         photo1.setImageBitmap(bitmap);

                     }
            }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    public class OkListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            thisProfile.setUsername(name.getText().toString());
            thisProfile.setEmail(email.getText().toString());
            thisProfile.setLevel(lvl.getSelectedItemPosition());
            if (password.getText().toString().equals(password2.getText().toString()) ){
            thisProfile.setPassword(password.getText().toString());}
            thisProfile.setDescription(description.getText().toString());
            PrefManager.StoreValues(thisProfile);
            try {
                new ProfileDAO().updateProfile(thisProfile, new DAOEvent());
            } catch (FirebaseException e) {
                e.printStackTrace();
            }
            onBackPressed();

            }
        }
}





