package com.android.ajaysharma.iflost;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    String uname,password;
    SharedPreferences sp;
    SharedPreferences.Editor spe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.username);
        et2=(EditText)findViewById(R.id.password);

        sp=getSharedPreferences("preference_file_key",MODE_PRIVATE);
        spe=sp.edit();

        boolean sps=sp.getBoolean("k1",false);
        String un = sp.getString("k2",uname);
        String up = sp.getString("k3",password);
        if(sps)
        {
            Intent i=new Intent(this,first_activity.class);
            //i.putExtra("p1",un);
            //i.putExtra("p2",up);
            startActivity(i);
            finish();
        }
    }
    public void authenticate(View view)
    {
        uname=et1.getText().toString().trim();
        password=et2.getText().toString().trim();
        myDatabase md=new myDatabase(this);
        SQLiteDatabase db=md.getWritableDatabase();
        String qry="select password from user_detail where username='"+uname+"'";
        Cursor c=db.rawQuery(qry,null);
        boolean result=c.moveToFirst();
        if(result)
        {
            String db_pass=c.getString(0);
            if(db_pass.equals(password))
            {
                spe.putBoolean("k1",true);
                spe.putString("k2",uname);
                spe.putString("k3",password);
                spe.commit();
                finish();
                Intent i=new Intent(this,first_activity.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this,"Password is Incorrect",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this,"Invalid User",Toast.LENGTH_SHORT).show();
        }


    }
    public void registeration(View view)
            
    {
        Intent i=new Intent(this,register_activity.class);
        startActivity(i);
    }
}
