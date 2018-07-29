package com.android.ajaysharma.iflost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by AJAYSHARMA on 7/11/2017.
 */

public class MyBR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        Object obj=bundle.get("pdus");
        Object mes[]=(Object[])obj;

        for (int i=0;i<mes.length;i++)
        {
            byte b[]=(byte[])mes[i];
            SmsMessage sms=SmsMessage.createFromPdu(b);

            String  from_num=sms.getDisplayOriginatingAddress();
            String msg=sms.getDisplayMessageBody();
            if(!msg.equals("")) {
                try {
                    Intent intent1 = new Intent();
                    intent1.setClassName("com.android.ajaysharma.iflost", "com.android.ajaysharma.iflost.first_activity");
                    intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent1.putExtra("k1", from_num);
                    intent1.putExtra("k2", msg);
                    context.startActivity(intent1);
                } catch (Exception e) {
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                    Log.e("There is some error in MyBr class........ ", "hello");
                    e.printStackTrace();
                }
            }
        }


    }
}
