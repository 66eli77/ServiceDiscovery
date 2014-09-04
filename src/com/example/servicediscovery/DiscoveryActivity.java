package com.example.servicediscovery;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class DiscoveryActivity extends Activity implements ServiceInfoListener{
	
	Helper mHelper;
	ScrollView mScroll;
	LinearLayout ll;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_discovery);
        
        mHelper = new Helper(this);
        mHelper.initializeNsd();
        
        mScroll = (ScrollView) findViewById(R.id.scrollView);
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        mScroll.addView(ll);
	}
	
	public void clickcancel(View v) {
		addServiceInfo("LVS-10-AF3F73      _pst_dt._tcp      192.168.1.1     6501");
	}
	
	public void addServiceInfo(String line) {
		TextView tv = new TextView(this);
		tv.setText(line);
		tv.setTextColor(Color.WHITE);
		tv.setTextSize(20);
		ll.addView(tv);
    }
	
	@Override
    protected void onPause() {
        if (mHelper != null) {
            mHelper.stopDiscovery();
        }
        super.onPause();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        if (mHelper != null) {
            mHelper.discoverServices();
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

	@Override
	public void onFinishServiceFound(String inputText) {
		// TODO Auto-generated method stub
		addServiceInfo(inputText);
	}

}
