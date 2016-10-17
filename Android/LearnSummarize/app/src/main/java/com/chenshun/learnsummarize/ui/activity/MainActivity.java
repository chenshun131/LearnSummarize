package com.chenshun.learnsummarize.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.logic.LoginManager;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginManager.captcha(this, null);
    }
}
