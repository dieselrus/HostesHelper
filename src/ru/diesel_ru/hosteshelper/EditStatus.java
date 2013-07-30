package ru.diesel_ru.hosteshelper;

import java.net.DatagramPacket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

public class EditStatus extends Activity {
	
	TextView tvDateTime;
	int DIALOG_TIME = 1;
	int DIALOG_DATA_TIME = 2;
	int myHour = 14;
	int myMinute = 35;
	
	static final ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_status);
		
		// получаем экземпляр элемента ListView
		ListView lv = (ListView)findViewById(R.id.listEdit);
		
		
		HashMap<String,String> temp = new HashMap<String,String>();
		temp.put("pen","MONT Blanc");
		temp.put("price", "200.00$");
		temp.put("color", "Silver, Grey, Black");
		list.add(temp);
		HashMap<String,String> temp1 = new HashMap<String,String>();
		temp1.put("pen","Gucci");
		temp1.put("price", "300.00$");
		temp1.put("color", "Gold, Red");
		list.add(temp1);
		HashMap<String,String> temp2 = new HashMap<String,String>();
		temp2.put("pen","Parker");
		temp2.put("price", "400.00$");
		temp2.put("color", "Gold, Blue");
		list.add(temp2);
		HashMap<String,String> temp3 = new HashMap<String,String>();
		temp3.put("pen","Sailor");
		temp3.put("price", "500.00$");
		temp3.put("color", "Silver");
		list.add(temp3);
		HashMap<String,String> temp4 = new HashMap<String,String>();
		temp4.put("pen","Porsche Design");
		temp4.put("price", "600.00$");
		temp4.put("color", "Silver, Grey, Red");
		list.add(temp4);
		
		// используем адаптер данных
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, new String[] {"pen","price","color"},);
		//SimpleAdapter adapter = new SimpleAdapter(this,list,android.R.layout.simple_list_item_1,new String[] {"pen","price"},new int[] {R.id.tvListMenu,R.id.tvListComment});
		SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_1, new String[] {"pen","price"}, new int[] {R.id.tvListMenu,R.id.tvListComment});

		lv.setAdapter(adapter);
	    
	}
	
  	@SuppressWarnings("deprecation")
	public void onClick(View v){
  		
  		switch (v.getId()) {
//		case R.id.tvDateTime:
//			showDialog(DIALOG_TIME);
//			break;

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
      
      @SuppressWarnings("deprecation")
	  @Override  
      protected void onPrepareDialog(int id, Dialog dialog) {    
    	  super.onPrepareDialog(id, dialog);    
    	  if (id == DIALOG_DATA_TIME) {
    		  
    	  }
      }
}
