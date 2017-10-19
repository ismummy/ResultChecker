package com.ismummy.resultchecker;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {

	EditText matric;
	Spinner level;
	ImageButton result;
	ArrayList<String> data;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComp();
    }

    private void initComp()
    {
    	result = (ImageButton) findViewById(R.id.result);
    	result.setOnClickListener(this);
    	
    	matric = (EditText) findViewById(R.id.matric);
    	
    	level = (Spinner)findViewById(R.id.level);
    	
    	data = new ArrayList<String>();
    	
    	data.add("123735");
    	data.add("113050");
    	data.add("110190");
    	data.add("110075");
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

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	
		int id = arg0.getId();
		if(id == R.id.result)
		{
			if(!matric.getText().toString().equals(""))
			{
				if(data.contains(matric.getText().toString()))
				{
					if(level.getSelectedItemPosition() < 7)
					{
						if(!(level.getSelectedItemPosition() > 3 && matric.getText().toString().equals("123735")))
						{
						Bundle bundle = new Bundle();
						bundle.putString("matric", matric.getText().toString());
						bundle.putInt("level", level.getSelectedItemPosition());
						
						Intent a = new Intent(MainActivity.this, ResultScreen.class);
						a.putExtras(bundle);
						startActivity(a);
						}
						else
						{
							Toast t = Toast.makeText(MainActivity.this, "Result not available for the selected semester", Toast.LENGTH_LONG);
							t.setGravity(Gravity.CENTER, 0, 0);
							t.show();
						}
					}
					else
					{
						Toast t = Toast.makeText(MainActivity.this, "Result not available for the selected semester", Toast.LENGTH_LONG);
						t.setGravity(Gravity.CENTER, 0, 0);
						t.show();
					}
				}
				else
				{
					Toast t = Toast.makeText(MainActivity.this, "Matric number not found.", Toast.LENGTH_LONG);
					t.setGravity(Gravity.CENTER, 0, 0);
					t.show();
				}
			}
			else
			{
				Toast t = Toast.makeText(MainActivity.this, "Enter a Valid Matric", Toast.LENGTH_LONG);
				t.setGravity(Gravity.CENTER, 0, 0);
				t.show();
			}
		}
	}
}
