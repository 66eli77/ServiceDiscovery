package com.example.servicediscovery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity{
	
	//Helper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void clickDiscover(View v) {
     //   mHelper.discoverServices();
        
        Intent discoveryIntent = new Intent(this, DiscoveryActivity.class);
		startActivity(discoveryIntent);
    }
    
}
