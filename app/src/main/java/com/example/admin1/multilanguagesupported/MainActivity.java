package com.example.admin1.multilanguagesupported;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Locale myLocale;
    private TextView welcome, email, password, login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button hindi = (Button) findViewById(R.id.hindi);
        Button english = (Button) findViewById(R.id.english);
        welcome = (TextView) findViewById(R.id.welcome);
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);
        login = (TextView) findViewById(R.id.login);
        signup = (TextView) findViewById(R.id.signup);
        hindi.setOnClickListener(this);
        english.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String lang = "en";//Default Language
        switch (view.getId()) {
            case R.id.english:
                lang = "en";
                break;
            case R.id.hindi:
                lang = "hi";
                break;
        }

        changeLocale(lang);
    }

    private void changeLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        Locale.setDefault(myLocale);
        Configuration config = new Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        onConfigurationChanged(config);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        welcome.setText(R.string.welcome);
        email.setText(R.string.email);
        login.setText(R.string.login);
        password.setText(R.string.password);
        signup.setText(R.string.signup);
    }
}
