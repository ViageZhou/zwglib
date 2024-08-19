package com.zwg.xfj;

import androidx.lifecycle.ViewModelProvider;

import com.zwg.xfj.databinding.ActivityMainBinding;

public class CopyActivity extends BaseMVVMActivity<ActivityMainBinding, MainViewModel> {
    public static final String TAG = CopyActivity.class.getSimpleName();


    @Override
    public int getContentResId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel initViewModel() {
        return new ViewModelProvider(this).get(MainViewModel.class);
    }


    @Override
    public void initView() {

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