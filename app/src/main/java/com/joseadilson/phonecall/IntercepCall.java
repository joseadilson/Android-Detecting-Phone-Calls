package com.joseadilson.phonecall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jose on 02/02/2017.
 */

public class IntercepCall extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)) {
                Toast.makeText(context, "Está ligando! "+number, Toast.LENGTH_SHORT).show();
                Log.i("Ringing!"," " +number);
            } else if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                Toast.makeText(context, "Recebido! "+number, Toast.LENGTH_SHORT).show();
                Log.i("Received!"," " +number);
            } else if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE)) {
                Toast.makeText(context, "Ocioso! ", Toast.LENGTH_SHORT).show();
                Log.i("Idle!"," " +number);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
