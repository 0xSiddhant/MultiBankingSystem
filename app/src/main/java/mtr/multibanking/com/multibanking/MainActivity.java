package mtr.multibanking.com.multibanking;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = MainActivity.this;


   private EditText email;
   private EditText password;
   private TextView login;
   private CardView cardlogin;
   private TextView register;
   private TextView forget;
   private Spinner spinner;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();

    }
    private void initViews() {
        email = (EditText)findViewById(R.id.Email);
        password = (EditText)findViewById(R.id.Password);
        login = (TextView)findViewById(R.id.Login);
        cardlogin = (CardView)findViewById(R.id.Cardlogin);
        register = (TextView)findViewById(R.id.Register);
        forget = (TextView)findViewById(R.id.Forgetpwd);

    }

    private void initListeners() {
        cardlogin.setOnClickListener(this);
        register.setOnClickListener(this);
        forget.setOnClickListener(this);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);

    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.Cardlogin:
                verifyFromSQLite();
                break;

            case R.id.Register:
                Intent intentRegister = new Intent(getApplicationContext(),Customer.class);
                startActivity(intentRegister);
                break;

            case R.id.Forgetpwd:
                Intent i = new Intent(getApplicationContext(),ForgetPassword.class);
                startActivity(i);
                break;
        }
    }

    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(email)) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(email)) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(password)) {
            return;
        }

        if (databaseHelper.checkUser(email.getText().toString().trim()
                , password.getText().toString().trim())) {

            Intent accountsIntent = new Intent(activity, CustomerProfile.class);
            accountsIntent.putExtra("EMAIL", email.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);
        }
        else if (email.getText().toString().trim().equals("Admin@gmail.com") && password.getText().toString().trim().equals("Admin")) {
                Intent i = new Intent(activity, AdminProfile.class);
                startActivity(i);
                emptyInputEditText();
        }
        else if (email.getText().toString().trim().equals("Employee@gmail.com") && password.getText().toString().trim().equals("Employee")) {

                Intent i = new Intent(activity, EmployeeProfile.class);
                startActivity(i);
                emptyInputEditText();

        }
        else {

            Toast.makeText(activity, "Invalid Email/Password", Toast.LENGTH_SHORT).show();
        }
    }
    private void emptyInputEditText() {
        email.setText(null);
        password.setText(null);
    }
}
