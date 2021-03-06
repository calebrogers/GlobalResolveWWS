package com.example.globalresovlewws;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Handler;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final int []imageArray={R.drawable.sunny_icon,R.drawable.night_rain};

		final ImageView imageView = (ImageView) findViewById(R.id.imageView);
		final Handler handler = new Handler();
		         Runnable runnable = new Runnable() {
		            int i=0;
		            public void run() {
		                imageView.setImageResource(imageArray[i]);
		                i++;
		                if(i>imageArray.length-1)
		                {
		                i=0;    
		                }
		                handler.postDelayed(this, 5000);  //for interval...
		            }
		        };
		        handler.postDelayed(runnable, 2000); //for initial delay..
		Button btnDockedMode = (Button) findViewById(R.id.button1);
		
		btnDockedMode.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
					Intent dockedScreen = new Intent(getApplicationContext(), SecondScreen.class );
					startActivity(dockedScreen);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
