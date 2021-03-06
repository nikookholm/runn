package s112011.runn;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowAgreement extends AppCompatActivity implements View.OnClickListener {

    ImageView ivUser, ivMap;
    Button accept, cancel;
    TextView overskrift, lokation, tidspunkt, distance, løbeniveau, deltager, løbeBeskrivelse;
    AgreementDTO a = new AgreementDTO();
    String agreementDate;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_agreement);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        overskrift = (TextView) findViewById(R.id.textOverskrift);
        overskrift.setOnClickListener(this);

        lokation = (TextView) findViewById(R.id.textLokation);
        lokation.setOnClickListener(this);

        tidspunkt = (TextView) findViewById(R.id.textDato);
        tidspunkt.setOnClickListener(this);

        distance = (TextView) findViewById(R.id.textDistance);
        distance.setOnClickListener(this);

        løbeniveau = (TextView) findViewById(R.id.textLøbeNiveau);
        løbeniveau.setOnClickListener(this);

        deltager = (TextView) findViewById(R.id.textDeltagere);
        deltager.setOnClickListener(this);

        løbeBeskrivelse = (TextView) findViewById(R.id.textLøbeBeskrivelse);
        løbeBeskrivelse.setOnClickListener(this);

        ivUser = (ImageView) findViewById(R.id.ivUser);
        ivMap = (ImageView) findViewById(R.id.ivMap);

        cancel = (Button) findViewById(R.id.buttonCancel);
        cancel.setOnClickListener(this);

        accept = (Button) findViewById(R.id.buttonAccept);
        accept.setOnClickListener(this);

        Intent intent =  getIntent();
        a = (AgreementDTO) intent.getSerializableExtra("agreement");

        date = new Date(a.getTime());
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        agreementDate = simpleDate.format(date);

        populateFields(a);
    }

    @Override
    public void onClick(View view) {
       if(view == accept){
            Toast.makeText(getApplicationContext(), "Ikke implementeret", Toast.LENGTH_LONG).show();
           accept.setText("Du deltager!");
           accept.setBackgroundColor(0xff00ff00);

        }
        else if(view == cancel){
            Intent intent = new Intent(this, AgreementsList.class);
            startActivity(intent);
        }
    }

    public void populateFields(AgreementDTO aDTO){
        overskrift.setText(aDTO.getTitle());
        lokation.setText(aDTO.getLocation());
        tidspunkt.setText(String.valueOf(agreementDate));
        distance.setText(String.valueOf(aDTO.getDistance()));
        deltager.setText(String.valueOf(aDTO.getParticipants()));
        løbeBeskrivelse.setText(aDTO.getDescription());
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

}
