package com.android.ajaysharma.iflost;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class first_activity extends AppCompatActivity {
    TextView tv1,tv2;
    SharedPreferences sp;
    SharedPreferences.Editor spe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        AudioManager am=(AudioManager)getSystemService(AUDIO_SERVICE);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        if(b!=null)
        {
            String cno=b.getString("k1");
            String message=b.getString("k2");

            tv1.setText(cno);
            tv2.setText(message);

            if(message.equals("SILENT"))
            {
                am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            }
            else if(message.equals("NORMAL"))
            {
                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       super.onCreateOptionsMenu(menu);
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.iflostmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.keywordschange:
            {
                Toast.makeText(this,"you can change the keywords",Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.about:
            {
                Toast.makeText(this, "This App is Developed by Mr. Ajay Sharma", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.logout:
            {
                sp = getSharedPreferences("preference_file_key",MODE_PRIVATE);
                spe=sp.edit();
                spe.clear();
                spe.apply();
                Intent intent = new Intent(first_activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            default:
            return super.onOptionsItemSelected(item);
        }



    }
}
