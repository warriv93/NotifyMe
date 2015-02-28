package com.example.notifyme;

//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;
//import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class NotifyMe extends Activity implements OnClickListener{
	
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notify_me);
		
		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notify_me, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
	 Intent intent = new Intent();
	 PendingIntent pending = PendingIntent.getActivity(this, 0, intent, 0);
	 
	 Notification noti = new Notification.Builder(this)
	 .setTicker("Dags att �ta!")
	 .setContentTitle("Matdags!")
	 .setContentText("Kurrar det inte lite i magen?")
	 .setSmallIcon(R.drawable.clock_icon)
	 .setContentIntent(pending).getNotification();
	 noti.flags = Notification.FLAG_AUTO_CANCEL;
	 
	 NotificationManager notManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	 
	 notManager.notify(0, noti);
		
	}

}
