package com.master.killercode.libninjahide;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.master.killercode.ninjahide.NinjaHide;

public class MainActivity extends AppCompatActivity {

    LinearLayout llTest;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = MainActivity.this;

        llTest = findViewById(R.id.llTest);
        NinjaHide.makeSetVersion(activity, llTest);

        TextView tc = NinjaHide.getTextView(activity);
        tc.setTextColor(0xFF000000);

        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                LinearLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

//        lp. = Gravity.CENTER | Gravity.BOTTOM;

        // Apply the layout parameters to TextView widget
        llTest.setLayoutParams(lp);
        llTest.setOrientation(LinearLayout.VERTICAL);
        llTest.setGravity(1);

    }
}
