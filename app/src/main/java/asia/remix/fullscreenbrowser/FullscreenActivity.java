package asia.remix.fullscreenbrowser;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

public class FullscreenActivity extends AppCompatActivity{
	WebView webView;

	@Override
	protected void onCreate( Bundle savedInstanceState ){
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_fullscreen );

		webView = (WebView)findViewById( R.id.webView );
		webView.getSettings().setJavaScriptEnabled( true );
		//No start default web browser by link.
		webView.setWebViewClient( new android.webkit.WebViewClient() );

		//MUST !
		// app\src\main\AndroidManifest.xml
		// <uses-permission android:name="android.permission.INTERNET" />
		webView.loadUrl( "https://remix.asia/" );
		//MUST !
		// <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
		// "Setting" > "Applications" > this app > "Permissions" > "Storage" > ok
	//  webView.loadUrl( "file:///storage/emulated/0/Download/index.html" );

		ActionBar actionBar = getSupportActionBar();
		if( actionBar != null ){
			actionBar.hide();
		}
		fullScreen();
	}

	@Override
	public void onWindowFocusChanged( boolean hasFocus ){
		super.onWindowFocusChanged(hasFocus);
		fullScreen();
	}

	@Override
	protected void onResume(){
		super.onResume();
		fullScreen();
	}

	void fullScreen(){
		webView.setSystemUiVisibility(
			View.SYSTEM_UI_FLAG_LOW_PROFILE
		|	View.SYSTEM_UI_FLAG_FULLSCREEN //API16Ver4.1～ステータスバー非表示
		|	View.SYSTEM_UI_FLAG_LAYOUT_STABLE
		|	View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY //API19Ver4.4～一定時間経過すると再度非表示
		|	View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
		|	View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //API14Ver4.0～インタラクションがない間ナビゲーションバー非表示
		);
	}
/*
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
   findViewById(R.id.layout).setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
   findViewById(R.id.layout).setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
} else {
   findViewById(R.id.layout).setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
}
*/
}
