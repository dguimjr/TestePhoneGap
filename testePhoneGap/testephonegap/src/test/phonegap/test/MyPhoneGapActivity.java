package test.phonegap.test;

import com.phonegap.*;
import android.os.Bundle;

public class MyPhoneGapActivity extends DroidGap {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/index.html");
		//super.setContentView(test.phonegap.test.R.layout.main);
	}
}
