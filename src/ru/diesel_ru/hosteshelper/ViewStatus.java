package ru.diesel_ru.hosteshelper;

import ru.diesel_ru.hosteshelper.MainActivity.connectTask;
import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewStatus extends Activity {
	Typeface helv3thin, helv4light;
	TextView tv;
	
	String strTableDataGet;
	
	private TCPClient mTcpClient;
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_status);
		
		helv3thin = Typeface.createFromAsset(getAssets(),"fonts/helv3thin.otf");
        helv4light = Typeface.createFromAsset(getAssets(),"fonts/helv4light.otf");
        
//		sp = PreferenceManager.getDefaultSharedPreferences(this);       
//		String _address = null;
//		_address = sp.getString("ServerAddress","");
//		if (_address != null)
//			TCPClient.SERVERIP = _address;
//		String _port = null;
//		_port = sp.getString("ServerPort","");
//		if (_port != null && _port != "")
//			TCPClient.SERVERPORT = Integer.parseInt(_port);
		//TCPClient.SERVERPORT = Integer.parseInt(sp.getString("ServerPort",""));
		
        // connect to the server
        //new connectTask().execute("");
        //sendData("|ReadTableData|" + MainActivity.roomNum + "-" + MainActivity.tableNum + "|\n"); 
        
//        ArrayList<EditText> myEditTextList = new ArrayList<EditText>();
//
//        for( int i = 0; i < myLayout.getChildCount(); i++ )
//          if( myLayout.getChildAt( i ) instanceof EditText )
//            myEditTextList.add( (EditText) myLayout.getChildAt( i ) );
        
        //myIdList.add( child.getId() );
        
        RelativeLayout myRelativeLayout = (RelativeLayout) findViewById( R.id.rl1 );

        for( int i = 0; i < myRelativeLayout.getChildCount(); i++ ){
        	  if( myRelativeLayout.getChildAt( i ) instanceof TextView )
        		  ((TextView) myRelativeLayout.getChildAt(i)).setTypeface(helv4light);
        }

        TextView tvRoom = (TextView) findViewById(R.id.tvRoom);
        tvRoom.setTypeface(helv3thin);
        tvRoom.setText(getString(R.string.room) + MainActivity.roomNum);
        
        TextView tvTable = (TextView) findViewById(R.id.tvTable);
        tvTable.setTypeface(helv3thin);
        tvTable.setText(getString(R.string.table) + MainActivity.tableNum);
        
        ActionBar actionBar = getActionBar();
//	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(true);
	    actionBar.hide();
//	    actionBar.setTitle(getString(R.string.room) + _room);
	}
	
  	public void onClick(View v){
  		finish();
  	}
  	
	// Отправляем данные на сервер
    private void sendData(String _data){
        if (mTcpClient != null) {
            mTcpClient.sendMessage(_data);
        }
        else{
        	new connectTask().execute("");
        }
    }
    
	//  Асинхронный поток для передачи и получения данных
    public class connectTask extends AsyncTask<String,String,TCPClient> {
 
        @Override
        protected TCPClient doInBackground(String... message) {
 
            //we create a TCPClient object and
            mTcpClient = new TCPClient(new TCPClient.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {
                    //this method calls the onProgressUpdate
                    publishProgress(message);
                }
            });
            mTcpClient.run();
 
            return null;
        }
 
		@Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            System.out.println(values);

            ParsingData(values[0]);
        }
		
		@SuppressWarnings("deprecation")
		private void ParsingData(String _data)
		{
			String a = _data.split("\\|", -1)[1];
//			String string1;
//			String string2;
//			//две строки равны, если
//			(string1).compareToIgnoreCase(getString(string2)) == 0
			strTableDataGet = null;
			// Получаем данные по столику
			if(a.compareToIgnoreCase("ReadTableData") == 0)
			{
				strTableDataGet = _data;
				//showDialog(DIALOG_ID_VIEW);
			}
			
			// Получаем состояние столиков
			if(a.compareToIgnoreCase("ReadTableStatus") == 0)
			{
				String btnStatus[] = _data.split("\\|", -1);
				for(String str:btnStatus){
//					for (ImageView button : ImageViewArray) {		
//						if(button.getTag().toString().compareToIgnoreCase(str.split("\\:", -1)[0]) == 0){
//							if(str.split("\\:", -1)[1].compareToIgnoreCase("free") == 0)
//								button.setImageDrawable(blueImg[Integer.valueOf(button.getTag().toString()) - 1]);
//							if(str.split("\\:", -1)[1].compareToIgnoreCase("busy") == 0)
//								button.setImageDrawable(redImg[Integer.valueOf(button.getTag().toString()) - 1]);
////							if(str.split("\\:", -1)[1].compareToIgnoreCase("order") == 0)
////								button.setBackgroundDrawable(new PaintDrawable(Color.YELLOW));
//						}
//			        }
				}
			}
			
			// Получаем состояние записи данных
//			if(a.compareToIgnoreCase("StatusWrite") == 0)
//			{
//				String StatusWrite[] = _data.split("\\|", -1);
//				if(StatusWrite[2].compareToIgnoreCase("true") == 0){
//					Toast.makeText(getBaseContext(), "Данные записаны!", Toast.LENGTH_SHORT).show();
//				}
//				if(StatusWrite[2].compareToIgnoreCase("false") == 0){
//					Toast.makeText(getBaseContext(), "Данные не записаны!", Toast.LENGTH_SHORT).show();
//				}
//			}
		}
    }
}
