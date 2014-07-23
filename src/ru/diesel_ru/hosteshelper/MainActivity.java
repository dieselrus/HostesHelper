package ru.diesel_ru.hosteshelper;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.libsvg.SvgDrawable;

import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements ActionBar.TabListener{

    ImageView img1, img2, img3, img4, img5, img6, img7, img8 ,img9, img10;
	ImageView[] ImageViewArrayRoom1, ImageViewArrayRoom2, ImageViewArrayRoom3, ImageViewArrayRoom4;
	//ImageView[] ImageViewRoom =  {ImageViewArrayRoom1, ImageViewArrayRoom2, ImageViewArrayRoom3, ImageViewArrayRoom4};
	ArrayList<ImageView[]> ArrayListRoom;
	
	ViewPager viewPager;
	public static int roomNum;
	public static int tableNum;
	
	private TCPClient mTcpClient;
    //private final static int DIALOG_ID_VIEW = 0;
    //private final static int DIALOG_EDIT_ID = 1;
    
    private ProgressDialog pDialog;
    
	private SharedPreferences sp;
	String[] strTableName = null;
	String strTableDataGet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		roomNum = 0;
		tableNum = 0;
		
		// setup action bar for tabs
	    ActionBar actionBar = getActionBar();
//	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(true);


	    
        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> pages = new ArrayList<View>();
        
        View page = inflater.inflate(R.layout.activity_tab, null);
//        TextView textView = (TextView) page.findViewById(R.id.text_view);
//        textView.setText("—Ú‡ÌËˆ‡ 1");

        ImageViewArrayRoom1 = new ImageView[]{ 
    			img1 = (ImageView) page.findViewById(R.id.imageView1),
    			img2 = (ImageView) page.findViewById(R.id.imageView2),
    			img3 = (ImageView) page.findViewById(R.id.imageView3),
    			img4 = (ImageView) page.findViewById(R.id.imageView4),
    			img5 = (ImageView) page.findViewById(R.id.imageView5),
    			img6 = (ImageView) page.findViewById(R.id.imageView6),
    			img7 = (ImageView) page.findViewById(R.id.imageView7),
    			img8 = (ImageView) page.findViewById(R.id.imageView8),
    			img9 = (ImageView) page.findViewById(R.id.imageView9),
    			img10 = (ImageView) page.findViewById(R.id.imageView10)
    		};
        
        for(int i = 0; i < ImageViewArrayRoom1.length; i++){
        	ImageViewArrayRoom1[i].setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        	ImageViewArrayRoom1[i].setImageDrawable(new SvgDrawable(CreateSVGImage(i+1, false, 0, "blue"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
        	ImageViewArrayRoom1[i].setOnLongClickListener(bu);
        }
        
        pages.add(page);
        
	    //Tab tab = actionBar.newTab().setText(R.string.room1).setCustomView(page);
	    //actionBar.addTab(tab);
	    
        page = inflater.inflate(R.layout.activity_tab, null);
//        textView = (TextView) page.findViewById(R.id.text_view);
//        textView.setText("—Ú‡ÌËˆ‡ 2");
        
        ImageViewArrayRoom2 = new ImageView[]{ 
    			img1 = (ImageView) page.findViewById(R.id.imageView1),
    			img2 = (ImageView) page.findViewById(R.id.imageView2),
    			img3 = (ImageView) page.findViewById(R.id.imageView3),
    			img4 = (ImageView) page.findViewById(R.id.imageView4),
    			img5 = (ImageView) page.findViewById(R.id.imageView5),
    			img6 = (ImageView) page.findViewById(R.id.imageView6),
    			img7 = (ImageView) page.findViewById(R.id.imageView7),
    			img8 = (ImageView) page.findViewById(R.id.imageView8),
    			img9 = (ImageView) page.findViewById(R.id.imageView9),
    			img10 = (ImageView) page.findViewById(R.id.imageView10)
    		};
        
        for(int i = 0; i < ImageViewArrayRoom2.length; i++){
        	ImageViewArrayRoom2[i].setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        	ImageViewArrayRoom2[i].setImageDrawable(new SvgDrawable(CreateSVGImage(i+1, false, 0, "yellow"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));
        	ImageViewArrayRoom2[i].setOnLongClickListener(bu);
        }
        pages.add(page);
        
        page = inflater.inflate(R.layout.activity_tab, null);
//        textView = (TextView) page.findViewById(R.id.text_view);
//        textView.setText("—Ú‡ÌËˆ‡ 3");
        
        ImageViewArrayRoom3 = new ImageView[]{ 
    			img1 = (ImageView) page.findViewById(R.id.imageView1),
    			img2 = (ImageView) page.findViewById(R.id.imageView2),
    			img3 = (ImageView) page.findViewById(R.id.imageView3),
    			img4 = (ImageView) page.findViewById(R.id.imageView4),
    			img5 = (ImageView) page.findViewById(R.id.imageView5),
    			img6 = (ImageView) page.findViewById(R.id.imageView6),
    			img7 = (ImageView) page.findViewById(R.id.imageView7),
    			img8 = (ImageView) page.findViewById(R.id.imageView8),
    			img9 = (ImageView) page.findViewById(R.id.imageView9),
    			img10 = (ImageView) page.findViewById(R.id.imageView10)
    		};
        
        for(int i = 0; i < ImageViewArrayRoom3.length; i++){
        	ImageViewArrayRoom3[i].setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        	ImageViewArrayRoom3[i].setImageDrawable(new SvgDrawable(CreateSVGImage(i+1, false, 0, "green"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));
        	ImageViewArrayRoom3[i].setOnLongClickListener(bu);
        }
        pages.add(page);
        
        page = inflater.inflate(R.layout.activity_tab, null);
//        textView = (TextView) page.findViewById(R.id.text_view);
//        textView.setText("—Ú‡ÌËˆ‡ 4");
        
        ImageViewArrayRoom4 = new ImageView[]{ 
    			img1 = (ImageView) page.findViewById(R.id.imageView1),
    			img2 = (ImageView) page.findViewById(R.id.imageView2),
    			img3 = (ImageView) page.findViewById(R.id.imageView3),
    			img4 = (ImageView) page.findViewById(R.id.imageView4),
    			img5 = (ImageView) page.findViewById(R.id.imageView5),
    			img6 = (ImageView) page.findViewById(R.id.imageView6),
    			img7 = (ImageView) page.findViewById(R.id.imageView7),
    			img8 = (ImageView) page.findViewById(R.id.imageView8),
    			img9 = (ImageView) page.findViewById(R.id.imageView9),
    			img10 = (ImageView) page.findViewById(R.id.imageView10)
    		};
        
        for(int i = 0; i < ImageViewArrayRoom4.length; i++){
        	ImageViewArrayRoom4[i].setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        	ImageViewArrayRoom4[i].setImageDrawable(new SvgDrawable(CreateSVGImage(i+1, false, 0, "magenta"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));
        	ImageViewArrayRoom4[i].setOnLongClickListener(bu);
        }
        pages.add(page);
        
        SamplePagerAdapter pagerAdapter = new SamplePagerAdapter(pages);
//        ViewPager viewPager = new ViewPager(this);
        viewPager = new ViewPager(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0); 
        
        setContentView(viewPager);
//        
//	    Tab tab = actionBar.newTab();
//	    tab.setText("tab1");
//	    tab.setTabListener(this);
//	    actionBar.addTab(tab);
//
//	    tab = actionBar.newTab();
//	    tab.setText("tab2");
//	    tab.setTabListener(this);
//	    actionBar.addTab(tab);
        
//        ArrayListRoom.add(ImageViewArrayRoom1);
//        ArrayListRoom.add(ImageViewArrayRoom2);
//        ArrayListRoom.add(ImageViewArrayRoom3);
//        ArrayListRoom.add(ImageViewArrayRoom4);
        
        
		sp = PreferenceManager.getDefaultSharedPreferences(this);       
		String _address = null;
		_address = sp.getString("ServerAddress","");
		if (_address != null)
			TCPClient.SERVERIP = _address;
		String _port = null;
		_port = sp.getString("ServerPort","");
		if (_port != null && _port != "")
			TCPClient.SERVERPORT = Integer.parseInt(_port);
		//TCPClient.SERVERPORT = Integer.parseInt(sp.getString("ServerPort",""));
		
        // connect to the server
        //new connectTask().execute("");
		
		//new ConnectorMySQL().execute("192.168.1.44", "3306", "HostesHelper", "garcon", "123456", "SELECT  `room` ,  `table` ,  `guests` ,  `reserved`,  `busy` FROM  `table_status`;");
	    	    
	}

 	// Долгое нажатие на картинку
	ImageView.OnLongClickListener bu = new ImageView.OnLongClickListener() {
		@Override
		public boolean onLongClick(View v) {
//			Toast.makeText(getBaseContext(), "Long Clicked Button1.", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(MainActivity.this, EditStatus.class);
	  	    startActivity(intent);
			return true;
		}
	};
	
    
    // Обработка нажатия
  	public void onClick(View v){
  		Toast.makeText(getApplicationContext(), "Click view id " + v.getId() + " " + viewPager.getCurrentItem(), Toast.LENGTH_SHORT).show();
  		//Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
  		roomNum = viewPager.getCurrentItem() + 1;
  		//tableNum = (int) v.getTag();
  		tableNum = Integer.valueOf((String) v.getTag());
  		
  		//sendData("|ReadTableData|" + roomNum + "-"+ tableNum + "|\n");
  		
//  		Intent intent = new Intent(MainActivity.this, ViewStatus.class);
//  	    startActivity(intent);
  	}

	// Генерация svg файла
	public String CreateSVGImage(int bigNum, boolean Reserved, int smallNum, String Color) {
		String svg = getString(R.string.svg_begin);

		svg += getString(R.string.svg_rectangle);
		// Резервирование
		if (Reserved)
			svg += getString(R.string.svg_reserved);

		// Комнаты
		switch (bigNum) {
		case 1:
			svg += getString(R.string.svg_big1);
			break;
		case 2:
			svg += getString(R.string.svg_big2);
			break;
		case 3:
			svg += getString(R.string.svg_big3);
			break;
		case 4:
			svg += getString(R.string.svg_big4);
			break;
		case 5:
			svg += getString(R.string.svg_big5);
			break;
		case 6:
			svg += getString(R.string.svg_big6);
			break;
		case 7:
			svg += getString(R.string.svg_big7);
			break;
		case 8:
			svg += getString(R.string.svg_big8);
			break;
		case 9:
			svg += getString(R.string.svg_big9);
			break;
		case 10:
			svg += getString(R.string.svg_big10);
			break;
		}

		// гости
		switch (smallNum) {
		case 1:
			svg += getString(R.string.svg_small_1);
			break;
		case 2:
			svg += getString(R.string.svg_small_2);
			break;
		case 3:
			svg += getString(R.string.svg_small_3);
			break;
		case 4:
			svg += getString(R.string.svg_small_4);
			break;
		case 5:
			svg += getString(R.string.svg_small_5);
			break;
		case 6:
			svg += getString(R.string.svg_small_6);
			break;
		case 7:
			svg += getString(R.string.svg_small_7);
			break;
		case 8:
			svg += getString(R.string.svg_small_8);
			break;
		case 9:
			svg += getString(R.string.svg_small_9);
			break;
		case 10:
			svg += getString(R.string.svg_small_10);
			break;
		}

		svg += getString(R.string.svg_end);

		// красный цвет
		if (Color.compareToIgnoreCase("red") == 0) {
			Pattern pattern1 = Pattern.compile("color1");
			Matcher matcher1 = pattern1.matcher(svg);
			svg = matcher1.replaceAll(getString(R.string.svg_color_red1));

			Pattern pattern2 = Pattern.compile("color2");
			Matcher matcher2 = pattern2.matcher(svg);
			svg = matcher2.replaceAll(getString(R.string.svg_color_red2));
		}

		if (Color.compareToIgnoreCase("blue") == 0) {
			Pattern pattern1 = Pattern.compile("color1");
			Matcher matcher1 = pattern1.matcher(svg);
			svg = matcher1.replaceAll(getString(R.string.svg_color_blue1));

			Pattern pattern2 = Pattern.compile("color2");
			Matcher matcher2 = pattern2.matcher(svg);
			svg = matcher2.replaceAll(getString(R.string.svg_color_blue2));
		}

		if (Color.compareToIgnoreCase("yellow") == 0) {
			Pattern pattern1 = Pattern.compile("color1");
			Matcher matcher1 = pattern1.matcher(svg);
			svg = matcher1.replaceAll(getString(R.string.svg_color_yellow1));

			Pattern pattern2 = Pattern.compile("color2");
			Matcher matcher2 = pattern2.matcher(svg);
			svg = matcher2.replaceAll(getString(R.string.svg_color_yellow2));
		}

		if (Color.compareToIgnoreCase("green") == 0) {
			Pattern pattern1 = Pattern.compile("color1");
			Matcher matcher1 = pattern1.matcher(svg);
			svg = matcher1.replaceAll(getString(R.string.svg_color_green1));

			Pattern pattern2 = Pattern.compile("color2");
			Matcher matcher2 = pattern2.matcher(svg);
			svg = matcher2.replaceAll(getString(R.string.svg_color_green2));
		}

		if (Color.compareToIgnoreCase("magenta") == 0) {
			Pattern pattern1 = Pattern.compile("color1");
			Matcher matcher1 = pattern1.matcher(svg);
			svg = matcher1.replaceAll(getString(R.string.svg_color_magenta1));

			Pattern pattern2 = Pattern.compile("color2");
			Matcher matcher2 = pattern2.matcher(svg);
			svg = matcher2.replaceAll(getString(R.string.svg_color_magenta2));
		}
		// Drawable img =
		// SVGParser.getSVGFromString(svg).createPictureDrawable();
		return svg;
	}
    
	// меню	
	public boolean onCreateOptionsMenu(Menu menu) {
	      
	      MenuInflater inflater = getMenuInflater();
	      inflater.inflate(R.menu.main, menu);
	      return true;
    }

	// Обрабатывает нажатия на пунктах меню
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.settings:
//	        Log.i("LOG", "Settings");
	        Intent intent = new Intent(MainActivity.this, PrefActivity.class);
	  	    startActivity(intent);
	        return true;
	    case R.id.menu_update:
	    	//sendData("|ReadTableStatus|\n");
	    	new ConnectorMySQL().execute("192.168.1.44", "3306", "HostesHelper", "garcon", "123456", "SELECT  `room` ,  `table` ,  `guests` ,  `reserved` ,  `busy` FROM  `table_status`;");
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
		
	}

	@Override
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		
	}

	@Override
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {

	}
/*
	// Отправляем данные на сервер
    private void sendData(String _data){
        if (mTcpClient != null) {
            mTcpClient.sendMessage(_data);
        }
        else{
        	new connectTask().execute("");
        }
    }
    */
	
    public void setResultSQL(ResultSet res){
		try {
			while (res.next()) 
			{
	    		//System.out.println(str_res);
	    		String _color = "red";
	    				
	    		int roomID = res.getInt(1);
	    		int _tableID = res.getInt(2);
	    		int _guests = res.getInt(3);		
	    		boolean _reserved = res.getBoolean(4);
	    		boolean _busy = res.getBoolean(5);
	    				
	    		// Если столик занят, то красим его
	    		if(_busy){  				
		    		switch (roomID) {
					case 1:
						//SvgDrawable svgd = new SvgDrawable(CreateSVGImage(_tableID, _reserved, _guests, _color), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2);
						//ImageViewArrayRoom1[_tableID-1].setBackground(svgd);
						ImageViewArrayRoom1[_tableID-1].setImageDrawable(new SvgDrawable(CreateSVGImage(_tableID, _reserved, _guests, _color), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
					 	break;
					case 2:
					 	//ImageViewArrayRoom2[_tableID-1].setImageDrawable(new SvgDrawable(CreateSVGImage(_tableID, _reserved, _guests, _color), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
					 	break;
					case 3:
					 	//ImageViewArrayRoom3[_tableID-1].setImageDrawable(new SvgDrawable(CreateSVGImage(_tableID, _reserved, _guests, _color), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
					 	break;
					case 4:
						//ImageViewArrayRoom4[_tableID-1].setImageDrawable(new SvgDrawable(CreateSVGImage(_tableID, _reserved, _guests, _color), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
						break;
		    		}
	    		} 
	    		// Если столик не занят и зарезервирова, рисуем резерв
	    		else if (!_busy && _reserved) {
	    			/*
	    			switch (roomID) {
					case 1:
						ImageViewArrayRoom1[_tableID-1].setImageDrawable(new SvgDrawable(CreateSVGImage(_tableID, _reserved, 0, "blue"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
					 	break;
					 case 2:
					 	ImageViewArrayRoom2[_tableID-1].setImageDrawable(new SvgDrawable(CreateSVGImage(_tableID, _reserved, 0, "yellow"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
					 	break;
					 case 3:
					 	ImageViewArrayRoom3[_tableID-1].setImageDrawable(new SvgDrawable(CreateSVGImage(_tableID, _reserved, 0, "green"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
					 	break;
					 case 4:
					 	ImageViewArrayRoom4[_tableID-1].setImageDrawable(new SvgDrawable(CreateSVGImage(_tableID, _reserved, 0, "magenta"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
					 	break;
		    		}
		    		*/		
	    		}
	    	}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
    
    public class ConnectorMySQL extends AsyncTask<String, Void, ResultSet> {

    	Connection conexionMySQL;
    	String str_res = "";
    	
    	@Override
    	protected ResultSet doInBackground(String... arg) {
    		
    		ResultSet rs = null;
    		
    		try{
    			Class.forName("com.mysql.jdbc.Driver").newInstance();
    			
    			conexionMySQL = DriverManager.getConnection("jdbc:mysql://" + arg[0] + ":" + arg[1] + "/" + arg[2], arg[3], arg[4]);
    			
    			Statement st = conexionMySQL.createStatement();
    			String sql = arg[5];
    			rs = st.executeQuery(sql);
    			//rs.next();
    			//str_res = rs.getString(1);
    			//System.out.print(str_res);
    			
    		} catch (Exception e) {
    			System.out.println("Error" + e.getMessage());
    		}
    		
    		return rs;
    	}
    	
    	/**
         * Перед началом фонового потока Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Загрузка продуктов. Подождите...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
            
        }

        
    	protected void onPostExecute(ResultSet result) {
    		// закрываем прогресс диалог после получение все продуктов
            pDialog.dismiss();

    		//System.out.print("onPostExecute");
			setResultSQL(result);
    	}
    }
}
