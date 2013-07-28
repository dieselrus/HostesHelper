package ru.diesel_ru.hosteshelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.libsvg.SvgDrawable;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements ActionBar.TabListener{

    ImageView img1, img2, img3, img4, img5, img6, img7, img8 ,img9, img10;
	ImageView[] ImageViewArrayRoom1, ImageViewArrayRoom2, ImageViewArrayRoom3, ImageViewArrayRoom4;
	ViewPager viewPager;
	public static int roomNum;
	public static int tableNum;
	
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
        	ImageViewArrayRoom1[i].setImageDrawable(new SvgDrawable(CreateSVGImage(i+1, true, i+1, "blue"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));   
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
        	ImageViewArrayRoom2[i].setImageDrawable(new SvgDrawable(CreateSVGImage(i+1, true, i+1, "yellow"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));
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
        	ImageViewArrayRoom3[i].setImageDrawable(new SvgDrawable(CreateSVGImage(i+1, true, i+1, "green"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));
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
        	ImageViewArrayRoom4[i].setImageDrawable(new SvgDrawable(CreateSVGImage(i+1, true, i+1, "magenta"), (getResources().getDisplayMetrics().xdpi + getResources().getDisplayMetrics().ydpi) / 2));
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
  		
  		Intent intent = new Intent(MainActivity.this, ViewStatus.class);
  	    startActivity(intent);
  	}
  	
	// Генерация svg файла
    public String CreateSVGImage(int bigNum, boolean Reserved, int smallNum, String Color){
 		String svg = getString(R.string.svg_begin);
 		
 			svg += getString(R.string.svg_rectangle);
 			// Резервирование
 			if(Reserved)
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
 		if (Color.compareToIgnoreCase("red") == 0){
     		Pattern pattern1  = Pattern.compile("color1");
     		Matcher matcher1 = pattern1.matcher(svg);
     		svg = matcher1.replaceAll(getString(R.string.svg_color_red1));
     		
     		Pattern pattern2  = Pattern.compile("color2");
     		Matcher matcher2 = pattern2.matcher(svg);
     		svg = matcher2.replaceAll(getString(R.string.svg_color_red2));        		
 		}

 		if (Color.compareToIgnoreCase("blue") == 0){
     		Pattern pattern1  = Pattern.compile("color1");
     		Matcher matcher1 = pattern1.matcher(svg);
     		svg = matcher1.replaceAll(getString(R.string.svg_color_blue1));
     		
     		Pattern pattern2  = Pattern.compile("color2");
     		Matcher matcher2 = pattern2.matcher(svg);
     		svg = matcher2.replaceAll(getString(R.string.svg_color_blue2));  
 		}
 	    
 		if (Color.compareToIgnoreCase("yellow") == 0){
     		Pattern pattern1  = Pattern.compile("color1");
     		Matcher matcher1 = pattern1.matcher(svg);
     		svg = matcher1.replaceAll(getString(R.string.svg_color_yellow1));
     		
     		Pattern pattern2  = Pattern.compile("color2");
     		Matcher matcher2 = pattern2.matcher(svg);
     		svg = matcher2.replaceAll(getString(R.string.svg_color_yellow2));  
 		}
 		
 		if (Color.compareToIgnoreCase("green") == 0){
     		Pattern pattern1  = Pattern.compile("color1");
     		Matcher matcher1 = pattern1.matcher(svg);
     		svg = matcher1.replaceAll(getString(R.string.svg_color_green1));
     		
     		Pattern pattern2  = Pattern.compile("color2");
     		Matcher matcher2 = pattern2.matcher(svg);
     		svg = matcher2.replaceAll(getString(R.string.svg_color_green2));  
 		}
 		
 		if (Color.compareToIgnoreCase("magenta") == 0){
     		Pattern pattern1  = Pattern.compile("color1");
     		Matcher matcher1 = pattern1.matcher(svg);
     		svg = matcher1.replaceAll(getString(R.string.svg_color_magenta1));
     		
     		Pattern pattern2  = Pattern.compile("color2");
     		Matcher matcher2 = pattern2.matcher(svg);
     		svg = matcher2.replaceAll(getString(R.string.svg_color_magenta2));  
 		}
 		//Drawable img = SVGParser.getSVGFromString(svg).createPictureDrawable();
 		return svg;
 	}
    
	// меню	
	public boolean onCreateOptionsMenu(Menu menu) {
	      
	      MenuInflater inflater = getMenuInflater();
	      inflater.inflate(R.menu.main, menu);
	      return true;
    }

	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
