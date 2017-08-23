package com.android.ajaysharma.iflost;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register_activity extends AppCompatActivity {
    String s1,s2,s3,s4,s5;
    EditText et1,et2,et3,et4,et5;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);
        et1=(EditText)findViewById(R.id.name);
        et2=(EditText)findViewById(R.id.username);
        et3=(EditText)findViewById(R.id.contno);
        et4=(EditText)findViewById(R.id.password);
        et5=(EditText)findViewById(R.id.repassword);

    }
    public void registeruser(View v)
    {
        s1=et1.getText().toString().trim();
        s2=et2.getText().toString().trim();
        s3=et3.getText().toString().trim();
        s4=et4.getText().toString().trim();
        s5=et5.getText().toString().trim();

        if(s1.isEmpty())
        {
            et1.setError("Empty");
        }
        else if(s2.isEmpty())
        {
            et2.setError("Empty");
        }
        else if(s3.isEmpty())
        {
            et3.setError("Empty");
        }
        else if(s4.isEmpty())
        {
            et4.setError("Empty");
        }
        else if(s5.isEmpty())
        {
            et5.setError("Empty");
        }
        else
        {
            if(s4.equals(s5))
            {
                myDatabase md=new myDatabase(this);
                SQLiteDatabase db=md.getWritableDatabase();
               String r_query="insert into user_detail values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
                db.execSQL(r_query);
                Toast.makeText(this,"User's Details have been stored ",Toast.LENGTH_SHORT).show();
                finish();
            }
            else
            {
                et5.setError("Does Not Match");
            }
        }


    }
}
