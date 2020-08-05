package com.hrdijital.networkcheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView network;
    Boolean isNetwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        network = findViewById(R.id.network);


    }
    public void checkNetwork(){
        ConnectivityManager connection = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        Network networkInterface = connection.getActiveNetwork();
        if (networkInterface != null ){
            if (networkInterface.getNetworkHandle() == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(this,"MOBILE Enabled",Toast.LENGTH_SHORT).show();
                network.setText("MOBILE Enabled");
            }else if (networkInterface.getNetworkHandle() == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this,"WIFI Enabled",Toast.LENGTH_SHORT).show();
                network.setText("MOBILE Enabled");
            }else{
                Toast.makeText(this,"Disconenction",Toast.LENGTH_SHORT).show();
                network.setText("Disconenction");
            }
        }
    }
    private Boolean registerNetworkCallback(Context context) {
        final ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);

        manager.registerNetworkCallback(
                new NetworkRequest.Builder()
                        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                        .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
                        .build(),
                new ConnectivityManager.NetworkCallback() {
                    @Override
                    public void onAvailable(Network network) {
                        if (network.getNetworkHandle() == ConnectivityManager.TYPE_MOBILE){
                            Toast.makeText(MainActivity.this,"MOBILE Enabled",Toast.LENGTH_SHORT).show();
                        }else if (network.getNetworkHandle() == ConnectivityManager.TYPE_WIFI){
                            Toast.makeText(MainActivity.this,"WIFI Enabled",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,"Disconenction",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onUnavailable() {
                        super.onUnavailable();

                            Toast.makeText(MainActivity.this,"onUnavailable",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLost(@NonNull Network network) {
                        super.onLost(network);
                        Toast.makeText(MainActivity.this,"onLost",Toast.LENGTH_SHORT).show();
                    }
                });

        return isNetwork;
    }
}