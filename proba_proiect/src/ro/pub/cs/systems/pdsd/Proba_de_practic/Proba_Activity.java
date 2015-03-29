package ro.pub.cs.systems.pdsd.Proba_de_practic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Proba_Activity extends Activity {

	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	  
	
	class ButtonListeners implements Button.OnClickListener
	{

		@Override
		public void onClick(View v) 
		{
			Button b = (Button)v;
			
			if(v.getId() == R.id.button1)
			{
				EditText txt1 = (EditText)findViewById(R.id.editText2);		
								
				int val = Integer.parseInt(txt1.getText().toString());
				val++;
				txt1.setText(String.valueOf(val));
				
			}
			if(v.getId() == R.id.button2)
			{
				EditText txt1 = (EditText)findViewById(R.id.editText1);
				int val = Integer.parseInt(txt1.getText().toString());
				val++;
				txt1.setText(String.valueOf(val));
				
			}
			if(v.getId() == R.id.button3)
			{
				EditText txt1 = (EditText)findViewById(R.id.editText2);	
				EditText txt2 = (EditText)findViewById(R.id.editText1);
				
				
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.Activitate2");
				intent.putExtra("number_of_clicks",
				            String.valueOf(
				              Integer.parseInt(txt2.getText().toString())
				              + Integer.parseInt(txt1.getText().toString())
				            ));
				startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
				 
			
			}
			
			
		}
		
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proba_main);
		
		
		EditText txt2 = (EditText)findViewById(R.id.editText2);		
		EditText txt1 = (EditText)findViewById(R.id.editText1);	
		txt1.setText("0");
		txt2.setText("0");
		
		Button b1 = (Button)findViewById(R.id.button2);
		b1.setOnClickListener(new ButtonListeners());
		Button b2 = (Button)findViewById(R.id.button1);
		b2.setOnClickListener(new ButtonListeners());
		
		if(savedInstanceState != null)
		{
			String leftCount = savedInstanceState.getString("leftCount");
			if(leftCount != null)
			{
				txt2.setText(leftCount);
			}
			else txt2.setText(String.valueOf(0));
			
			String rightCount = savedInstanceState.getString("rightCount");
			if(rightCount != null)
			{
				txt1.setText(rightCount);				
			}
			else txt1.setText(String.valueOf(0));
			
		}
		else
		{
			txt2.setText(String.valueOf(0));
			txt1.setText(String.valueOf(0));
		}
		
		Button navigateToSecondaryActivityButton = (Button)findViewById(R.id.button3);
	    navigateToSecondaryActivityButton.setOnClickListener(new ButtonListeners());    
		
	}
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) 
	{
		EditText txt1 = (EditText)findViewById(R.id.editText2);
		EditText txt2 = (EditText)findViewById(R.id.editText1);
		
		savedInstanceState.putString("leftCount", txt1.getText().toString());
		savedInstanceState.putString("rightCount", txt2.getText().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.proba_, menu);
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
	
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
	  }
}
