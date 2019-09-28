package mtr.multibanking.com.multibanking;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Customer extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = Customer.this;

    CardView customer;
    EditText Cname;
    EditText Username;
    EditText Cemail;
    EditText Cpassword;
    EditText Cconformpass;
    CardView Csubmit;
    TextView csubmit;
    private DatabaseHelper databaseHelper;
    private Contact user;
    private InputValidation inputValidation;

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        getSupportActionBar().hide();


        initViews();
        initListeners();
        initObjects();

    }

    private void initViews() {
        Cname = (EditText) findViewById(R.id.cname);
        Username = (EditText) findViewById(R.id.c_username);
        Cemail = (EditText) findViewById(R.id.c_email);
        Cpassword = (EditText) findViewById(R.id.c_pass);
        Cconformpass = (EditText) findViewById(R.id.C_conform_pass);
        Csubmit = (CardView) findViewById(R.id.customersubmit);
        csubmit = (TextView)findViewById(R.id.c_submit);
    }

    private void initListeners() {
        Csubmit.setOnClickListener(this);
        csubmit.setOnClickListener(this);
    }

    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new Contact();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.customersubmit:
                postDataToSQLite();
                break;
            case R.id.c_submit:
                postDataToSQLite();
                break;
        }

    }

    private void postDataToSQLite() {

        String strCname = Cname.getText().toString();
        String strUsername = Username.getText().toString();
        String strCemail = Cemail.getText().toString();
        String strCpassword = Cpassword.getText().toString();
        String strCconformpass = Cconformpass.getText().toString();

       if (!inputValidation.isInputEditTextFilled(Cname)) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(Username)) {
            return;
        }

          if (!inputValidation.isInputEditTextFilled(Cpassword)) {
            return;
        }
        
        if (!inputValidation.isInputEditTextEmail(Cemail)) {
            return;
        }

        if (!inputValidation.isInputEditTextMatches(Cpassword,Cconformpass)) {
            return;
        }


        if (!databaseHelper.checkUser(Cemail.getText().toString().trim())) {

            user.setName(Cname.getText().toString().trim());
            user.setEmail(Cemail.getText().toString().trim());
            user.setPassword(Cpassword.getText().toString().trim());

            databaseHelper.addUser(user);
            // Snack Bar to show success message that record saved successfully
            Toast.makeText(Customer.this, "Login Success", Toast.LENGTH_SHORT).show();
            emptyEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(Customer.this, "User already Exists", Toast.LENGTH_SHORT).show();
        }
    }

    private void emptyEditText() {
        Cname.setText(null);
        Username.setText(null);
        Cemail.setText(null);
        Cpassword.setText(null);
        Cconformpass.setText(null);
    }
}
