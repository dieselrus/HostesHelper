package ru.diesel_ru.hosteshelper;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

public class EditStatus extends Activity {
	
	TextView tvDateTime;
	int DIALOG_TIME = 1;
	int myHour = 14;
	int myMinute = 35;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_status);
		
		tvDateTime = (TextView) findViewById(R.id.tvDateTime);
	}
	
  	public void onClick(View v){
  		
  		switch (v.getId()) {
		case R.id.tvDateTime:
			showDialog(DIALOG_TIME);
			break;

		default:
			break;
		}
  		showDialog(DIALOG_TIME);
  	}
  	
	// Диалог просмотра статуса столика
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, myHour, myMinute, true);
            return tpd;
          }
          return super.onCreateDialog(id);
    }
	
    OnTimeSetListener myCallBack = new OnTimeSetListener() {
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
	          myHour = hourOfDay;
	          myMinute = minute; 
	          //tvTime.setText("Time is " + myHour + " hours " + myMinute + " minutes");
		}
      };
}
