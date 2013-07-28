package ru.diesel_ru.hosteshelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditStatus extends Activity {
	
	TextView tvDateTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_status);
		
		tvDateTime = (TextView) findViewById(R.id.tvDateTime);
	}
	
  	public void onClick(View v){
  		finish();
  	}
}
