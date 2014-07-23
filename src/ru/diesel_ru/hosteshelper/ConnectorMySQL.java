package ru.diesel_ru.hosteshelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.os.AsyncTask;

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
        /*
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Загрузка продуктов. Подождите...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
        */
    }

    
	protected void onPostExecute(ResultSet result) {
		System.out.print(result);
		MainActivity.setResultSQL(result);	
	}
}
