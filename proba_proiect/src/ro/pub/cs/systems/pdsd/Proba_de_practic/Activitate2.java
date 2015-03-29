package ro.pub.cs.systems.pdsd.Proba_de_practic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class Activitate2 extends Activity {

	 private ButtonClickListener buttonClickListener = new ButtonClickListener();
	 
	 private class ButtonClickListener implements Button.OnClickListener 
	 {	 	 	 

		@Override
		public void onClick(View v) 
		{
			// TODO Auto-generated method stub
			 switch(v.getId()) 
			 {
		        case R.id.button_ok:
		          setResult(RESULT_OK, new Intent());
		          finish();
		          break;
		        case R.id.button_cancel:
		          setResult(RESULT_CANCELED, new Intent());
		          finish();
		          break;
		      }
		}
		
	  }  
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activitate2);
		
		TextView numberOfClicksTextView = (TextView)findViewById(R.id.textView_number_of_clicks);
		
		Intent intent = getIntent();
	    if (intent != null) 
	    {
	    	String numberOfClicks = intent.getStringExtra("number_of_clicks");
	    	if (numberOfClicks != null) 
	    	{
	    		//numberOfClicksTextView.setText(getResources().getString(R.string.title_activity_activitate2).replace("???", numberOfClicks));
	    		//numberOfClicksTextView.setText(getResources().getString(R.string.title_activity_second_activty).replace("???", numberOfClicks) );
	    		numberOfClicksTextView.setText(numberOfClicks);
	    	}
	    }
	    
	    Button buttonOk = (Button)findViewById(R.id.button_ok);
	    buttonOk.setOnClickListener(buttonClickListener);
	    Button buttonCancel = (Button)findViewById(R.id.button_cancel);
	    buttonCancel.setOnClickListener(buttonClickListener);      
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activitate2, menu);
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
