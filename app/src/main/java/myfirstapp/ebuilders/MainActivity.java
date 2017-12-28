package myfirstapp.ebuilders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myfirstapp.ebuilders.model.ResObj;
import myfirstapp.ebuilders.remote.ApiUtils;
import myfirstapp.ebuilders.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   EditText editemail;
    EditText editPassword;
    Button btnlogin;
    UserService mauserService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editemail= (EditText) findViewById(R.id.editemail);
        editPassword= (EditText) findViewById(R.id.editPassword);
        btnlogin= (Button) findViewById(R.id.btnlogin);

        mauserService= ApiUtils.getUserService();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=editemail.getText().toString();
                String password=editPassword.getText().toString();
                if(validateLogin (email, password)){

                    sendPost(email, password);

                }
            }
        });
    }
    private boolean validateLogin(String email,String Password){

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
         email=editemail.getText().toString();
        Matcher matcher= Pattern.compile(emailPattern).matcher(email);

        if(email==null || email.trim().length()==0|| !matcher.matches()){
            Toast.makeText(this, "email is required" ,Toast.LENGTH_SHORT).show();
            return false;


        }

        if(Password==null || Password.trim().length()==0) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return  true;


    }
    private  void  sendPost(final String email, final String password){
      mauserService.savePost(email,password).enqueue(new Callback<ResObj>() {
          @Override
          public void onResponse(Call<ResObj> call, Response<ResObj> response) {
              if(response.isSuccessful()){
                  ResObj resObj=response.body();
                  if(resObj.getEmail().equals("true")&&resObj.getPassword().equals("true")){
                      Intent intent=new Intent(MainActivity.this, ProfileActivity.class);
                      intent.putExtra("email",email);
                      startActivity(intent);

                  }else {
                      Toast.makeText(MainActivity.this,"email or password is incorrect",Toast.LENGTH_SHORT).show();
                  }
              }
          }

          @Override
          public void onFailure(Call<ResObj> call, Throwable t) {
              Toast.makeText(MainActivity.this,"Error,Please try again",Toast.LENGTH_SHORT).show();



              }


      });

    }


}
