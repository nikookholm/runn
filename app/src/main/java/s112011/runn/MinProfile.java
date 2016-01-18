package s112011.runn;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by amal on 11/01/16.
 */

public class MinProfile extends AppCompatActivity implements View.OnClickListener{

    Button okBtn, annullerBtn , choicePicture, takePicture;

    TextView name, email;
    ProfileDTO thisProfile;
    Spinner lvl;
    private int takePictureID = 123;
    private int cameraID = 321;
    private File file;
    LinearLayout saveImage;
    TableLayout photoTable;
    ImageView photo1;
    TableRow tableRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        thisProfile = (ProfileDTO) intent.getSerializableExtra("Profile");



        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_creation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spriner = (Spinner) findViewById(R.id.spinnerLevel);
        List<String> level = new ArrayList<>();
        level.add("Lav");
        level.add("Middel");
        level.add("Høj");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, level);
        spriner.setAdapter(dataAdapter);




//        spriner.setOnItemClickListener(new SpinnerListener());

        okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(this);

        annullerBtn = (Button) findViewById(R.id.annullerBtn);
        annullerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

       tableRow = (TableRow) findViewById(R.id.tb2);

        choicePicture = (Button) findViewById(R.id.choicePhoto);
        choicePicture.setOnClickListener(this);



        takePicture =(Button) findViewById(R.id.camera);
        takePicture.setOnClickListener(this);
       // tableRow.addView(takePicture);

        name = (TextView) findViewById(R.id.profileName);
        name.setText(thisProfile.getUsername());

        email = (TextView) findViewById(R.id.emailProfile);
        email.setText(thisProfile.getEmail());

        lvl = (Spinner) findViewById(R.id.spinnerLevel);
        lvl.setSelection(thisProfile.getLevel());

        photo1 =(ImageView) findViewById(R.id.pictureT);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setContentView(tableRow);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        ToolBar tb = new ToolBar();
        tb.t(item);
        return  true;
    }

        @Override
        public void onClick(View v) {

            if (v == choicePicture) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent, takePictureID);

            } else if (v == takePicture) {
                System.out.println("take pivture");
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                file = new File(Environment.getExternalStorageDirectory(), "billede.png");
                System.out.println("det er file: " + file);
                System.out.println("uri: "+Uri.fromFile(file));
                intent2.putExtra("output", Uri.fromFile(file));
                startActivityForResult(intent2, cameraID);
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


                            System.out.println("selve intent: "+dataI);
                            System.out.println("intentdata efter: " + dataI.getExtras().get("output"));
                            Bitmap bmp = (Bitmap) dataI.getExtras().get("output");
                            photo1.setImageBitmap(bmp);

                        } else {

                            Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
                            photo1.setImageBitmap(bitmap);
                        }

                    }
            }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}





