package com.zwg.xfj;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.zyhp.zwglib.net.Net;

import java.text.SimpleDateFormat;

/**
 * Created by ZhouWengong on 2024/7/8.
 */
public class MainViewModel extends ViewModel {
    public static final String TAG = MainViewModel.class.getSimpleName();

    private final Net net;
    private final SimpleDateFormat format;

    public MainViewModel() {
        this.net = Net.getInstance();
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    private final MutableLiveData<String> _myMoneyBean = new MutableLiveData<>();
    public final LiveData<String> mMoneyBean = _myMoneyBean;

//    private final MutableLiveData<CardBalanceBean> _myCardBalanceBean = new MutableLiveData<>();
//    public final LiveData<CardBalanceBean> mCardBalanceBean = _myCardBalanceBean;

//    private final MutableLiveData<ConsumeResultBean> _myConsumeResultBean = new MutableLiveData<>();
//    public final LiveData<ConsumeResultBean> mConsumeResultBean = _myConsumeResultBean;

//    private final MutableLiveData<ConsumeBean> _myConsumeBean = new MutableLiveData<>();
//    public final LiveData<ConsumeBean> mConsumeBean = _myConsumeBean;





}
