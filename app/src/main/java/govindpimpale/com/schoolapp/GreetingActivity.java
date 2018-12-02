package govindpimpale.com.schoolapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import govindpimpale.com.schoolapp.Utils;

public class GreetingActivity extends Activity {


    private void toMainActivity()
    {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(myIntent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        if(getSchool() != null)
        {
            toMainActivity();
        }

        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = ((EditText) findViewById(R.id.editText)).getText().toString();
                if(str != null) {
                    //TODO download from website, updoot zip
                    setSchool(str);
                    toMainActivity();
                }
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, HIGH_SCHOOLS);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.editText);
        textView.setAdapter(adapter);


    }


    //TODO fetch from server at runtime

    static String[] HIGH_SCHOOLS = {
            "Milpitas High School",


            // San Jose high schools
            "Abraham Lincoln High School (San Jose, California)",
            "Apollo High School (San Jose, California)",
            "Archbishop Mitty High School",
            "Bellarmine College Preparatory",
            "Boynton High School",
            "Branham High School",
            "Broadway High School",
            "Cambrian Academy",
            "Camden High School (San Jose, California)",
            "Communitas Charter High School",
            "DCP El Primero High School",
            "Del Mar High School",
            "East Side Cadet Academy",
            "Evergreen Valley High School",
            "Gunderson High School",
            "Harker School",
            "Andrew Hill High School",
            "Independence High School (San Jose, California)",
            "KIPP San Jose Collegiate",
            "Latino College Preparatory Academy",
            "Leigh High School",
            "Leland High School (San Jose, California)",
            "Liberty Baptist School",
            "James Lick High School",
            "Lynbrook High School",
            "Mt. Pleasant High School (San Jose, California)",
            "Notre Dame High School (San Jose, California)",
            "Oak Grove High School (San Jose, California)",
            "William C. Overfelt High School",
            "Piedmont Hills High School",
            "Pioneer High School (San Jose, California)",
            "Presentation High School",
            "San Jose High School",
            "Santa Teresa High School",
            "Silver Creek High School (San Jose, California)",
            "Thomas More School (San Jose, California)",
            "University Preparatory Academy",
            "Valley Christian High School (San Jose, California)",
            "Willow Glen High School",
            "Yerba Buena High School"
    };


    void putSettings(String key, String value)
    {
        SharedPreferences settings = getSharedPreferences("SchoolApp", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    String getSettingsValue(String key)
    {
        return getSharedPreferences("SchoolApp", 0).getString("key", "").toString();
    }

    void setSchool(String str) {
        putSettings("school", str);
    }

    String getSchool()
    {
        return getSettingsValue("school");
    }
}
