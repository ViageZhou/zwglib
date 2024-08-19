package com.zwg.xfj;


import androidx.lifecycle.ViewModelProvider;

import com.zwg.xfj.databinding.ActivityMainBinding;


public class MainActivity extends BaseMVVMActivity<ActivityMainBinding, MainViewModel> {
    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    public void initView() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public int getContentResId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel initViewModel() {
        return new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public void initListener() {


    }


    @Override
    public void initRequest() {

    }

    @Override
    public void initLiveData() {

    }


}