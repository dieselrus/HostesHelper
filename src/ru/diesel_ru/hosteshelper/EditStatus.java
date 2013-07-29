package ru.diesel_ru.hosteshelper;

import java.net.DatagramPacket;
import java.text.SimpleDateFormat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class EditStatus extends Activity {
	
	TextView tvDateTime;
	int DIALOG_TIME = 1;
	int DIALOG_DATA_TIME = 2;
	int myHour = 14;
	int myMinute = 35;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_status);
		
		tvDateTime = (TextView) findViewById(R.id.tvDateTime);
	}
	
  	@SuppressWarnings("deprecation")
	public void onClick(View v){
  		
  		switch (v.getId()) {
		case R.id.tvDateTime:
			showDialog(DIALOG_TIME);
			break;

		default:
			break;
		}
  		showDialog(DIALOG_DATA_TIME);
  	}
  	
	// Диалог просмотра статуса столика
    @SuppressWarnings("deprecation")
	protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, myHour, myMinute, true);
            return tpd;
          }
        
        // Создаем диалог ввода даты и времени
        if(id == DIALOG_DATA_TIME){
            AlertDialog.Builder adb = new AlertDialog.Builder(this);    
            adb.setTitle("Дата и время");    
            // создаем view из dialog.xml    
            LinearLayout view = (LinearLayout) getLayoutInflater().inflate(R.layout.date_time, null);   
            // устанавливаем ее, как содержимое тела диалога    
            adb.setView(view);    
            // находим TexView для отображения кол-ва    
            DatePicker dpData = (DatePicker) view.findViewById(R.id.datePicker1);   
            dpData.setCalendarViewShown(false);
            
            TimePicker tpTime = (TimePicker) view.findViewById(R.id.timePicker1);
            tpTime.setIs24HourView(true);
            
            adb.setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
	    		@SuppressWarnings("deprecation")
				@SuppressLint("SimpleDateFormat")
				public void onClick(DialogInterface dialog, int id) {
		    		//MainActivity.this.finish();
//	    			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
//	    			sendData("|AddData|" + spnTableName.getSelectedItem().toString() + 
//	    					"|" + spnTableStatus.getSelectedItem().toString() + 
//	    					"|" + sdf.format(System.currentTimeMillis()) +
//	    					"|" + timeOrder.getCurrentHour() + ":" + timeOrder.getCurrentMinute() +
//	    					"|" + edtGuests.getText().toString() + 
//	    					"|" + spnGarcon.getSelectedItem().toString() + "|\n");	    			
//		    		// Обновление состояния столиков
//		    		sendData("|ReadTableStatus|\n"); 
		    		removeDialog(DIALOG_DATA_TIME);
	    		}
    		});

            adb.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
	    		@SuppressWarnings("deprecation")
				public void onClick(DialogInterface dialog, int id) {
	    			//dialog.cancel();
	    			removeDialog(DIALOG_DATA_TIME);
	    		}
    		});
    		
            return adb.create();
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
