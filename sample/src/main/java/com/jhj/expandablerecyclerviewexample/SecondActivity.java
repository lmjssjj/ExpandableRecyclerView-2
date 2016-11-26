package com.jhj.expandablerecyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jhj.expandablerecyclerview.util.Logger;
import com.jhj.expandablerecyclerviewexample.model.MyChild;
import com.jhj.expandablerecyclerviewexample.model.MyParent;
import com.jhj.expandablerecyclerviewexample.model.Test;

import java.util.List;

/**
 * Created by jhj_Plus on 2016/9/15.
 */
public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Test test=getIntent().getParcelableExtra("test");
        MyParent myParent = test.getMyParent();
        List<MyChild> myChildren = myParent.getChildren();
        boolean hasOneChild = myChildren != null && !myChildren.isEmpty();
        Logger.e(TAG, "string=" + test.getString() + ",myParent=" + myParent.isInitiallyExpanded() +
                ",child-dot=" + (hasOneChild ? myChildren.get(0).getDot() : "none"));
    }
}
