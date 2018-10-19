package jgs.com.jogilsang.begginer;

/**
 * Created by user on 2018-10-19.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker tPicker;

    Button next;
    int nextClicked;
    ImageButton select;
    ImageButton close;

    String tvYear;
    String tvMonth;
    String tvDay;

    String tvHour;
    String tvMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();
        setData();
        setListener();

    }

    public void initView(){


        // FrameLayout의 2개 위젯
        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        next =(Button)findViewById(R.id.button_next);
        close =(ImageButton)findViewById(R.id.button_close);
        select =(ImageButton)findViewById(R.id.button_select);


    }

    public void setData(){

        nextClicked = 0;

    }

    @Override
    public void onBackPressed() {

        switch(nextClicked) {

            /// next 안누른경우
            case 0 :
                super.onBackPressed();

            case 1 :
            // next 누른경우

                nextClicked = 0;

                datePicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.GONE);
                select.setVisibility(View.GONE);

                next.setVisibility(View.VISIBLE);

        }
    }

    public void setListener(){
        
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClicked = 1;

                datePicker.setVisibility(View.GONE);
                tPicker.setVisibility(View.VISIBLE);
                select.setVisibility(View.VISIBLE);

                next.setVisibility(View.GONE);

            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                tvYear = Integer.toString(datePicker.getYear());
                tvMonth = Integer.toString(1+datePicker.getMonth());
                tvDay = Integer.toString(datePicker.getDayOfMonth());

                tvHour = Integer.toString(tPicker.getCurrentHour());
                tvMinute = Integer.toString(tPicker.getCurrentMinute());

                //basicToast(tvYear+"년 "+ tvMonth+"월 " + tvDay+ "일 " + tvHour+ "시" + tvMinute + "분"+ "\n예약가능한 시간으로 조회합니다");

                finish();

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });


    }
}
