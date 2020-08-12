package bar.foo.pota;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.VideoView;

public class MainActivity extends Activity implements OnTouchListener {
	
	VideoView videoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		videoView = (VideoView)findViewById(R.id.videoView1);
		videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.clip));
		videoView.setOnTouchListener(this);
	}
	
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		if (videoView.isPlaying()) {
			videoView.pause();
		} else {
			videoView.start();
		}
		return false;
	}	
	
	@Override
	protected void onResume() {
		super.onResume();		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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


}
