package com.codester.maris.loc;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity implements OnCheckedChangeListener, View.OnClickListener {
    TextView tv1,tv2,text3;
    EditText lat_dest,lon_dest;
    ListView listv1,list2;
    ArrayList<Location> arr1;
    ArrayList<String> arr2;
    Button but1, btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lat_dest = (EditText) findViewById(R.id.dest_latitude);
        lon_dest = (EditText) findViewById(R.id.dest_lon);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        text3 = (TextView) findViewById(R.id.text3);

        arr1 = new ArrayList<>();
        arr2 = new ArrayList();

       /* arr1.add("item1");
        arr1.add("item2");
        arr1.add("item3");

        arr2.add("thing 1");
        arr2.add("thing 2");
        arr2.add("thing 3");*/

        /*ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, arr1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr2);
        listv1 = (ListView) findViewById(R.id.list1);
        list2 = (ListView) findViewById(R.id.list2);
        listv1.setAdapter(adapter1);*/
        //adapter1.notifyDataSetChanged();

        //list2.setAdapter(adapter2);

        but1 = (Button) findViewById(R.id.button1);
        but1.setOnClickListener(this);

        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(this);

    }//end onCreate

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onClick(View v) {
        if(v == but1){
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
            String lon2 = "-9.463338099999987";//meant to be -6
            dest_location2.setLatitude(Double.parseDouble(lat2));
            dest_location2.setLongitude(Double.parseDouble(lon2));
            Double distance2 = Double.valueOf(mylocation.distanceTo(dest_location2));

            Toast.makeText(MainActivity.this, "Distance "+Double.toString(distance2),
                    Toast.LENGTH_LONG).show();
            tv2.setText("distance to wexford from home " + Double.toString(distance2));

            if (distance2 < dist) {
                Toast.makeText(MainActivity.this, "Im close to the second location", Toast.LENGTH_SHORT).show();
            }
        }//end if
        else if (btnCheck == v) {
            Location mylocation = new Location("");
            Double my_lat = 52.676765;
            Double my_lon = -6.292764;
            mylocation.setLatitude(my_lat);
            mylocation.setLongitude(my_lon);

            Location dest_location2 = new Location("");
            String lat2 = "52.336916";
            String lon2 = "-6.463338099999987";
            dest_location2.setLatitude(Double.parseDouble(lat2));
            dest_location2.setLongitude(Double.parseDouble(lon2));
            //Double distance2 = Double.valueOf(mylocation.distanceTo(dest_location2));


            Double dist = 100000.00;
            arr1.add(dest_location2);//TODO arrayList 1

            Double distance2 = (double) mylocation.distanceTo(arr1.get(0));
            tv1.setText(Double.toString(distance2));
            if (distance2 < dist) {
                Double d = distance2 / 1000;
                tv2.setText("close to location/Within 100km..." + d);
            }

            Location mylocation2 = new Location("");
            Double my_lat2 = 53.3385306;
            Double my_lon2 = -6.2676777;//college
            mylocation2.setLatitude(my_lat2);
            mylocation2.setLongitude(my_lon2);

            Double distance3 = Double.valueOf(mylocation2.distanceTo(dest_location2));
            float distance = mylocation2.distanceTo(dest_location2)/1000;

            if (distance3 < dist || distance3 == dist || distance3 > dist) {
                Double d = distance3/1000;
                Toast.makeText(MainActivity.this,"Your close to the last location", Toast.LENGTH_SHORT).show();
                text3.setText("Your " + d + " from the location" + " the initial distance is " + distance3 + " my location is  " + mylocation2
                + " my destination location is " + dest_location2);
            }
        }
    }
}