package com.zyhp.zwglib.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;


/**
 * Created by ZhouWengong on 2024/7/8.
 */
public abstract class BaseMVVMActivity<VDB extends ViewDataBinding, VM extends ViewModel> extends BaseActivity {

    public static final String TAG = BaseMVVMActivity.class.getSimpleName();
    protected VDB mBindView;
    protected VM mViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBindView = DataBindingUtil.inflate(getLayoutInflater(),
                getContentResId(), null, false);

        setContentView(mBindView.getRoot());

        mBindView.setLifecycleOwner(this);

        mViewModel = initViewModel();

        initView();
        initListener();
        initRequest();
        initLiveData();
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//
////        mBaseBindingView = DataBindingUtil.inflate(LayoutInflater.from(this),
////                R.layout.activity_base, null, false);
//
//        mBindingView = DataBindingUtil.inflate(getLayoutInflater(),
//                setLayout(), null, false);
//
////        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(
////                ViewGroup.LayoutParams.MATCH_PARENT,
////                ViewGroup.LayoutParams.MATCH_PARENT
////        );
////        mBindingView.getRoot().setLayoutParams(layoutParams);
//
////        mBaseBindingView.rootView.addView(mBindingView.getRoot());
//
////        setContentView(getContentResId());
//
//
//        Log.e(TAG, "zwg----[onCreate]:  getContentResId = " + getContentResId());
//
//        mBindingView.setLifecycleOwner(this);
//
//        mViewModel = initViewModel();
//
//        initView();
//        initRequest();
//        initLiveData();
//    }

    public abstract VM initViewModel();

    public abstract void initView();

    public abstract void initListener();

    public abstract void initRequest();

    public abstract void initLiveData();
}
