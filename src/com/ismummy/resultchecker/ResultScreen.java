package com.ismummy.resultchecker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ResultScreen extends Activity implements OnClickListener {

	LinearLayout result;
	TextView name,semester;
	ImageButton back,email;
	String getMatric;
	int getLevel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_screen);
		initComp();
		
		Bundle data = getIntent().getExtras();
		getMatric = data.getString("matric");
		getLevel = data.getInt("level");
		process();
	}
	private void initComp()
	{
		result = (LinearLayout) findViewById(R.id.result);
		
		name = (TextView) findViewById(R.id.name);
		semester = (TextView) findViewById(R.id.semester);
		
		back = (ImageButton) findViewById(R.id.back);
		back.setOnClickListener(this);
		email = (ImageButton) findViewById(R.id.email);
		email.setOnClickListener(this);
	}
	private void process()
	{
		LinearLayout.LayoutParams par = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		LinearLayout layout;
		TextView label[] = new TextView[4];
		
		//result for semesters
		String[][] ham100 = {{"MTH101","5","76"},{"PHY101","4","69"},{"PHY103","1","76"},{"CHM101","4","88"},{"CHM191","1","56"},{"BIO101","3","77"},{"BIO103","1","66"},{"FAA","2","77"},{"GNS101","2","81"},{"LIB101","0","89"}};
		String[][] rain100 = {{"MTH102","5","76"},{"PHY102","4","69"},{"PHY104","1","76"},{"CHM102","4","88"},{"CHM192","1","56"},{"BIO102","3","77"},{"BIO104","1","66"},{"GNS102","2","81"},{"GNS104","2","77"},{"CSE100","1","89"}};
		String[][] ham200 = {{"CSE201","3","88"},{"CSE203","1","78"},{"MEE201","2","66"},{"MEE203","2","77"},{"MEE207","2","69"},{"MEE211","3","88"},{"EEE231","4","66"},{"MGS201","1","67"},{"GNS207","2","80"}};
		String[][] rain200 = {{"CSE202","2","89"},{"CSE204","2","78"},{"CSE206","3","86"},{"EEE200","3","67"},{"EEE202","1","66"},{"EEE204","3","56"},{"EEE206","1","66"},{"EEE232","3","56"},{"GNS202","2","67"},{"GNS208","2","65"}};
		String[][] ham300 = {{"CSE301","3","99"},{"CSE303","3","89"},{"CSE305","3","98"},{"CSE307","3","99"},{"CSE311","3","89"},{"CSE331","3","99"},{"MTH203","2","80"},{"MTH307","3","90"}};
		String[][] rain300 = {{"CSE302","3","99"},{"CSE304","3","89"},{"CSE308","3","88"},{"CSE310","3","88"},{"CSE312","3","79"},{"CSE314","3","90"},{"MEE300","2","89"}};
		String[][] ham400 = {{"CSE401","3","88"},{"CSE403","3","89"},{"CSE405","2","90"},{"CSE407","2","79"},{"CSE409","2","90"},{"CSE411","3","79"},{"CSE413","3","70"},{"CSE419","3","88"},{"CVE401","1","90"}};
		
		//parameters to use for the layout
		String[][] value = {};
		
		if(getLevel == 0)
		{
			value = ham100;
			semester.setText("100L/Harmattan Semester");
		}
		else if(getLevel == 1)
		{
			value = rain100;
			semester.setText("100L/Rain Semester");
		}
		else if(getLevel == 2)
		{
			value = ham200;
			semester.setText("200L/Harmattan Semester");
		}
		else if(getLevel == 3)
		{
			value = rain200;
			semester.setText("200L/Rain Semester");
		}
		else if(getLevel == 4)
		{
			value = ham300;
			semester.setText("300L/Harmattan Semester");
		}
		else if(getLevel == 5)
		{
			value = rain300;
			semester.setText("300L/Rain Semester");
		}
		else
		{
			value = ham400;
			semester.setText("400L/Harmattan Semester");
		}
		
		
		for(int i=0; i<value.length; i++)
		{
			layout = new LinearLayout(this);
			layout.setLayoutParams(par);
			layout.setOrientation(LinearLayout.HORIZONTAL);
			layout.setWeightSum(100);
			
			label[0] = new TextView(this);
			label[0].setGravity(Gravity.CENTER);
			LinearLayout.LayoutParams lay1 =new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 29);
			lay1.setMargins(0, 3, 0, 0);
			label[0].setLayoutParams(lay1);
			label[0].setText((i+1)+"");
			label[0].setTextColor(getResources().getColor(R.color.black));
			label[0].setTextSize(20);
			label[0].setBackgroundColor(getResources().getColor(R.color.blue));
			
			label[1] = new TextView(this);
			label[1].setGravity(Gravity.CENTER);
			LinearLayout.LayoutParams lay2 =new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 19);
			lay2.setMargins(3, 3, 3, 0);
			label[1].setLayoutParams(lay2);
			label[1].setText(value[i][0]);
			label[1].setTextColor(getResources().getColor(R.color.black));
			label[1].setTextSize(20);
			label[1].setBackgroundColor(getResources().getColor(R.color.blue));
			
			label[2] = new TextView(this);
			label[2].setGravity(Gravity.CENTER);
			LinearLayout.LayoutParams lay3 =new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 27);
			lay3.setMargins(0, 3, 0, 0);
			label[2].setLayoutParams(lay3);
			label[2].setText(value[i][1]);
			label[2].setTextColor(getResources().getColor(R.color.black));
			label[2].setTextSize(25);
			label[2].setBackgroundColor(getResources().getColor(R.color.blue));
			
			label[3] = new TextView(this);
			label[3].setGravity(Gravity.CENTER);
			LinearLayout.LayoutParams lay4 =new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 25);
			lay4.setMargins(3, 3, 0, 0);
			label[3].setLayoutParams(lay4);
			label[3].setText(value[i][2]);
			label[3].setTextColor(getResources().getColor(R.color.black));
			label[3].setTextSize(25);
			label[3].setBackgroundColor(getResources().getColor(R.color.blue));
			
			layout.addView(label[0]);
			layout.addView(label[1]);
			layout.addView(label[2]);
			layout.addView(label[3]);
			
			result.addView(layout);
		}
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
		
		if(id == R.id.back)
		{
			startActivity(new Intent(ResultScreen.this, MainActivity.class));
		}
	}

}
