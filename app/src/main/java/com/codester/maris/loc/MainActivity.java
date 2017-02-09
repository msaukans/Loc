package com.codester.maris.loc;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Type;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnCheckedChangeListener {
    TextView tv1,tv2;
    EditText lat_dest,lon_dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lat_dest = (EditText) findViewById(R.id.dest_latitude);
        lon_dest = (EditText) findViewById(R.id.dest_lon);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        Button but1 = (Button) findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Location mylocation = new Location("");
                Location dest_location = new Location("");
                String lat = lat_dest.getText().toString();
                String lon = lon_dest.getText().toString();
                dest_location.setLatitude(Double.parseDouble(lat));
                dest_location.setLongitude(Double.parseDouble(lon));
                Double my_lat = 52.676765;
                Double my_lon = -6.292764;
                mylocation.setLatitude(my_lat);
                mylocation.setLongitude(my_lon);
                Double distance = Double.valueOf(mylocation.distanceTo(dest_location));//in meters
                Toast.makeText(MainActivity.this, "Distance "+Double.toString(distance),Toast.LENGTH_LONG).show();

                //Toast.makeText(MainActivity.this, "The distance is " + distance, Toast.LENGTH_SHORT).show();

                Double dist = 100000.00;
                if (distance < dist) {
                    Double d = distance / 1000;
                    Toast.makeText(MainActivity.this, "Im close to the first location", Toast.LENGTH_SHORT).show();
                    tv1.setText("Distance to first location is " + distance + " metres, and " + d + " in kilometers \n \n");
                }

                //result is 73665.875 = 73km.something (73.58) //TODO divide by 1000 to get in kilometers


               //
                //TODO
                //PROBLEM SETTING TEXTVIEW>>>>>>>>>>>>>>>>>>>>>
               Location dest_location2 = new Location("");
                String lat2 = "52.336916";
                String lon2 = "-6.463338099999987";
                dest_location2.setLatitude(Double.parseDouble(lat2));
                dest_location2.setLongitude(Double.parseDouble(lon2));
                Double distance2 = Double.valueOf(mylocation.distanceTo(dest_location2));
                Toast.makeText(MainActivity.this, "Distance "+Double.toString(distance2),
                        Toast.LENGTH_LONG).show();
                tv2.setText("distance to wexford from home " + Double.toString(distance2));

                if (distance2 < dist) {
                    Toast.makeText(MainActivity.this, "Im close to the second location", Toast.LENGTH_SHORT).show();
                }


            }//end onClick
        });

    }//end onCreate

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}