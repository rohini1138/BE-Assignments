package com.example.beep;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText etUsername;
	private EditText etPassword;
	private Button bSignIn;
	private Button bClear;
	int count=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etUsername = (EditText)findViewById(R.id.etUsername);
		etPassword = (EditText)findViewById(R.id.etPassword);
		bSignIn = (Button)findViewById(R.id.bSignIn);
		bClear = (Button)findViewById(R.id.bClear);
		bClear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				etUsername.setText("");
				etPassword.setText("");
			}
		});
		bSignIn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String username = etUsername.getText().toString();
				String password = etPassword.getText().toString();
				
				if(username.equals("rohini") && password.equals("patil"))
				{
					Toast.makeText(getApplicationContext(), "Welcome to My App",Toast.LENGTH_LONG).show();
					etUsername.setEnabled(false);
					etPassword.setEnabled(false);
					bSignIn.setEnabled(false);
				}
				else
				{
					if(count<=3)
					{
						count++;
						ToneGenerator t = new ToneGenerator(AudioManager.STREAM_NOTIFICATION,100);
						t.startTone(ToneGenerator.TONE_PROP_BEEP);
						Toast.makeText(getApplicationContext(), "Chor......!!!",Toast.LENGTH_LONG).show();
					}
					else 
					{
						Toast.makeText(getApplicationContext(), "App locked",Toast.LENGTH_LONG).show();
						etUsername.setEnabled(false);
						etPassword.setEnabled(false);
						bSignIn.setEnabled(false);
					}
				}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);                         
		return true;
	}

}
