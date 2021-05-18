package sg.edu.rp.c346.id20015553.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText editMobileNumber;
    EditText editSize;
    DatePicker datePicker;
    TimePicker timePicker;
    RadioGroup radioGroup;
    RadioButton radioSmoke;
    RadioButton radioNonSmoke;
    Button btnSubmit;
    Button btnReset;
    TextView textResult;
    String check;
    String stringDate;
    String stringTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        editMobileNumber = findViewById(R.id.editMobileNumber);
        editSize = findViewById(R.id.editSize);
        datePicker = findViewById(R.id.datepicker);
        timePicker = findViewById(R.id.timepicker);
        radioGroup = findViewById(R.id.radioGroup);
        radioSmoke = findViewById(R.id.radioSmoke);
        radioNonSmoke = findViewById(R.id.radioNonSmoke);
        btnReset = findViewById(R.id.btnReset);
        btnSubmit = findViewById(R.id.btnSubmit);
        textResult = findViewById(R.id.textResult);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editName.getText().toString().matches("" ) || editMobileNumber.getText().toString().matches("") || editSize.getText().toString().matches("") || radioGroup.getCheckedRadioButtonId() == -1){
                    Toast a = Toast.makeText(getApplicationContext(), "Missing Information!", Toast.LENGTH_SHORT);
                    a.show();
                }
                else{
                    if(radioSmoke.isChecked() == true){
                        check = "Smoking area";
                    }
                    else{
                        check = "Non-Smoking area";
                    }

                    stringTime =  timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                    stringDate =  datePicker.getDayOfMonth() + "/" +  datePicker.getMonth() + "/" + datePicker.getYear();


                    Toast b = Toast.makeText(getApplicationContext(), "Reservation: " + editName.getText().toString() + "\nMobile Number: " + editMobileNumber.getText().toString() + "\nSize of Group: " + editSize.getText().toString() + "\nSeating Position: " + check + "\nDate: " + stringDate + "\nTime: " + stringTime   , Toast.LENGTH_SHORT);
                    b.show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editMobileNumber.setText("");
                editSize.setText("");
                radioSmoke.setChecked(false);
                radioNonSmoke.setChecked(false);
                datePicker.updateDate(2020,5,1);
                timePicker.setCurrentHour(19);
                timePicker.setCurrentMinute(30);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay < 8 || (hourOfDay > 20 && minute > 59) ||  hourOfDay >= 21){
                    Toast d = Toast.makeText(getApplicationContext(), "Error! Only select 8AM - 8.59PM timings!", Toast.LENGTH_SHORT);
                    d.show();
                    timePicker.setCurrentHour(19);
                    timePicker.setCurrentMinute(30);
                }
                else{
                    Toast c = Toast.makeText(getApplicationContext(), "You have selected: " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT);
                    c.show();
                }
            }
        });
    }
}