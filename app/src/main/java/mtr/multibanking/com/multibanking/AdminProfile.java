package mtr.multibanking.com.multibanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class AdminProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        CardView lgt = (CardView) findViewById(R.id.alogout);
        lgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                AdminProfile.super.onBackPressed();
            }
        });
        CardView cardView =(CardView)findViewById(R.id.listofcustomer);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),UsersListActivity.class);
                startActivity(i);
            }
        });
    }
}
