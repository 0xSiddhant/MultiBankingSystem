package mtr.multibanking.com.multibanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class CustomerProfile extends AppCompatActivity {
    private EditText email;
    private TextView textViewName;
    private List<Contact> listUsers;
    private DatabaseHelper databaseHelper;
    private AppCompatActivity activity = CustomerProfile.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        email = (EditText)findViewById(R.id.Email);

        CardView   lgt = (CardView) findViewById(R.id.logout1);
        lgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                CustomerProfile.super.onBackPressed();
            }
        });

        CardView addaccount = (CardView) findViewById(R.id.addaccount1);
        addaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddAccount.class);
                startActivity(i);
            }
        });
        CardView transfer = (CardView) findViewById(R.id.transfermoney);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Transfer.class);
                startActivity(i);
            }
        });

        CardView cprofile = (CardView)findViewById(R.id.Cprofile);
        cprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),UsersListActivity.class);
                startActivity(i);
            }
        });
        textViewName =(TextView)findViewById(R.id.textViewName);
        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);

    }

}
