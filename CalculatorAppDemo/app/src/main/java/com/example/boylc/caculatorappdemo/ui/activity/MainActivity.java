package com.example.boylc.caculatorappdemo.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.boylc.caculatorappdemo.R;
import com.example.boylc.caculatorappdemo.ui.fragment.CaculatorFragment;

public class MainActivity extends AppCompatActivity implements CaculatorFragment.OnDataPass {
    private static final String TAG = "main_activity";
    private static final String FRAGMENT_CALCULATOR = "calculator_fragment";
    private static final String SHARED_PREFERENCES_NAME = "last_result";
    public static final String RESULT = "result";
    private String mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();
        changeFragment(this, CaculatorFragment.newInstance(getDataFromPreferences()), R.id.fragment_content, FRAGMENT_CALCULATOR);

    }

    private void initVariables() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_caculator, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CaculatorFragment caculatorFragment = (CaculatorFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_CALCULATOR);
        switch (item.getItemId()) {
            case R.id.action_clear:
                caculatorFragment.clearData();
                break;
            case R.id.action_save_last_result:
                caculatorFragment.passData();
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(RESULT, mData);
                editor.commit();
                break;
            default:
                break;
        }
        return true;
    }

    public void changeFragment(Context context, Fragment fragment, int placeholder, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(placeholder, fragment, tag);
        ft.commit();
    }

    @Override
    public void onDataPass(String data) {
        this.mData = data;
    }

    public String getDataFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(RESULT, "");
    }

}
