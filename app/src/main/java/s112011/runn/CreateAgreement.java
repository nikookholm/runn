package s112011.runn;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreateAgreement extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Calendar calendar;
    private int year, month, day, hour, minute;
    Button btnDate, btnTime, cancel, create;
    EditText title, location, participants, distance, description;
    ToggleButton toogleButtonRepeat;
    Spinner spinnerNiveau;
    static final int DATE_PICKER_ID = 1111;
    static final int TIME_PICKER_ID = 2222;
    public Activity a = this;
    AgreementDAO aDAO;
    AgreementDTO aDTO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_agreement);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinnerNiveau);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Lav");
        categories.add("Middel");
        categories.add("Høj");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        spinner.setAdapter(dataAdapter);

        calendar = Calendar.getInstance();

        //The DatePicker
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        title = (EditText) findViewById(R.id.editTextTitel);
        title.setOnClickListener(this);

        location = (EditText) findViewById(R.id.editTextLoation);
        location.setOnClickListener(this);

        toogleButtonRepeat = (ToggleButton)findViewById(R.id.toggleButtonRepeat);
        toogleButtonRepeat.setOnClickListener(this);

        spinnerNiveau = (Spinner) findViewById(R.id.spinnerNiveau);

        participants = (EditText) findViewById(R.id.editTextParticipants);
        participants.setOnClickListener(this);

        distance = (EditText) findViewById(R.id.editTextDistance);
        distance.setOnClickListener(this);

        description = (EditText) findViewById(R.id.editTextDescription);
        description.setOnClickListener(this);


        btnDate = (Button) findViewById(R.id.buttonDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // On button click show datepicker dialog
                showDialog(DATE_PICKER_ID);
            }
        });

        //The TimePicker
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);


        btnTime = (Button) findViewById(R.id.buttonTime);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Button click to show timepicker dialog
                showDialog(TIME_PICKER_ID);
            }
        });

        //Knapper
        cancel = (Button) findViewById(R.id.buttonCancel);
        cancel.setOnClickListener(this);
        create = (Button) findViewById(R.id.buttonCreateAgreement);
        create.setOnClickListener(this);

//        AgreementDTO agreeDTO = new AgreementDTO();
//        setFields(agreeDTO);
    }


//    public void onCreateAgreement(AgreementDTO aDTO){
//        if(title.getText().length() != 0 && location.getText().length() != 0 && btnDate.getText().length() != 0 &&
//                btnTime.getText().length() != 0 && participants.getText().length() != 0 && distance.getText().length() != 0
//                && title.getText().length() != 0){
//
//            setFields(aDTO);
//
//            AgreementDAO aDAO = new AgreementDAO();
//
//            aDAO.saveAgreementAsync(aDTO, new DAOEvent(){
//
//                @Override
//                public void saveAgreement(AgreementDTO agreement) {
//
//                }
//            });
//        }
//    }

//    public void setFields(AgreementDTO agreementDTO){
//        agreementDTO.setTitle(title.getText().toString());
//        agreementDTO.setLocation(location.getText().toString());
//        agreementDTO.setTime(btnDate);
//        agreementDTO.setParticipants(participants.getText().toString());
//        agreementDTO.getDescription(description.getText().toString());
//    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:
                return new DatePickerDialog(this, myDateListener, year, month, day);
            case TIME_PICKER_ID:
                return new TimePickerDialog(this, myTimeListener, hour, minute, true);
        }
        System.out.println("år" + year + "månede" + month + "dag" + day);
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg_Y, int arg_M, int arg_D) {
            StringBuilder stringBuilder = new StringBuilder();
            String dateSaver = stringBuilder.append(arg_D).append("-").append(arg_M+1).append("-").append(arg_Y).toString();
            btnDate.setText(dateSaver);
        }
    };

    private TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int arg_h, int arg_m) {
            btnTime.setText(new StringBuilder().append(arg_h).append(":").append(arg_m));
        }
    };

    @Override
    public void onClick(View v) {
        if (v == cancel) {
            Intent intent = new Intent(this, AgreementsList.class);
            startActivity(intent);
        }
        if (v == create) {

            if(title.getText().length() != 0 && location.getText().length() != 0 && btnDate.getText().length() != 0 &&
                    btnTime.getText().length() != 0 && participants.getText().length() != 0 && distance.getText().length() != 0
                    && title.getText().length() != 0){
                create.setEnabled(false);
                cancel.setEnabled(false);
                Toast.makeText(a, "Opretter aftale ...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, AgreementsList.class);
                startActivity(intent);


            }else{
                Toast.makeText(this, "Alle felter skal udfyldes", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String item = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    private void onClickSøg(){

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ToolBar Tb = new ToolBar(this);
        Tb.t(item);
        return true;

    }

}
