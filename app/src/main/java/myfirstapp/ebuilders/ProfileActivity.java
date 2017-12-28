package myfirstapp.ebuilders;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtemail= (TextView) findViewById(R.id.txtemail);

        Bundle extars=getIntent().getExtras();
        String email;

        if(extars != null){
            email=extars.getString("email");
            txtemail.setText(email);
        }
    }
}
