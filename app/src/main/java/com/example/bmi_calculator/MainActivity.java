package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Used to connect layout file with the java file

        // Creating variables to target the elements in the xml
        TextView result = findViewById(R.id.txt_result);
        EditText edt_feet = findViewById(R.id.height_feet);
        EditText edt_inch = findViewById(R.id.height_inch);
        EditText edt_wt = findViewById(R.id.weight);
        Button btn_calc = findViewById(R.id.btn_calc);

        // Setting the click event on the button - The following event will be fired when the user clicks the button
        btn_calc.setOnClickListener(new View.OnClickListener() {
            // As button is a subclass of View class or the button class is derived from the View class so the reference of OnClickListner comes with View class
            @Override
            public void onClick(View view) {
                // Taking the value from the edittext boxes
                int weight = Integer.parseInt(edt_wt.getText().toString()); // Receiving the value from the edittext then converting it into string, and at last typecasting it into Integer
                int feet = Integer.parseInt(edt_feet.getText().toString());
                int inch = Integer.parseInt(edt_inch.getText().toString());

                // Calculating BMI
                int total_inches = feet*12 + inch; // Converting feet into inches
                double total_cm = total_inches*2.53; // Converting inches to centimeters
                double total_m = total_cm/100; // Converting centimeters into meters
                double bmi = weight/Math.pow(total_m,2);  // bmi = weight/square(height)

                if(bmi>25)
                {
                    result.setText("BMI : "+bmi+"\nYou are overweight");
                }
                else if(bmi<18)
                {
                    result.setText("BMI : "+bmi+"\nYou are underweight");
                }
                else
                {
                    result.setText("BMI : "+bmi+"\nYou are healthy");
                }
            }
        });
    }
}