package me.blog.eyeballs.davidsprofile;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by eye on 17. 8. 6.
 */

public class Utility {
    public int isNetworkConnected(Context context){
        int isConnected = 0;

        ConnectivityManager manager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (mobile.isConnected()){
            isConnected = 1;
        }else if(wifi.isConnected()){
            isConnected = 2;
        }else{
            isConnected = 0;
        }
        return isConnected;
    }

}
