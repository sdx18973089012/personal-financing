package com.ssdut.roysun.personalfinancialrecommendationsystem.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.ssdut.roysun.personalfinancialrecommendationsystem.R;
import com.ssdut.roysun.personalfinancialrecommendationsystem.utils.MyApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by roysun on 16/3/12.
 * Activity的基类，定义公共方法、常量...
 */

public class BaseActivity extends AppCompatActivity {

    MyApplication mApplication;  //管理Activity

    //Activity ID，命名规则：四位数从高到低依次为：
    //千位 -> 随意定义的首数字，此处为8
    //百位 -> 0代表一般页面（基础Activity和MainActivity等），1~4代表对应Fragment中包含的页面
    //十位 -> 0代表一般功能（一般页面该位置0），1及大于1代表该Fragment中包含的大功能
    //个位 -> 0代表一般功能（一般页面该位置0），1及大于1代表该Fragment中包含的子功能，特别地基础Activity此位取1表示与MainActivity（0）区分

    //主页面ID
    public static final int ACTIVITY_MAIN_MD = 8000;
    //基础Activity ID
    public static final int ACTIVITY_BASE = 8001;
    //第一个Fragment中包含的Activity ID
    public static final int ACTIVITY_JOURNAL_MAIN = 8111;
    public static final int ACTIVITY_JOURNAL_ADD = 8112;
    public static final int ACTIVITY_JOURNAL_DETAIL = 8113;
    public static final int ACTIVITY_JOURNAL_SHEET = 8114;
    public static final int ACTIVITY_JOURANL_SETTINGS = 8115;
    public static final int ACTIVITY_BUDGET = 8121;
    //第二个Fragment中包含的Activity ID
    public static final int ACTIVITY_STOCK = 8211;
    //第三个Fragment中包含的Activitiy ID
    public static final int ACTIVITY_LOGIN = 8311;
    public static final int ACTIVITY_REGISTER = 8321;
    public static final int ACTIVITY_USER_MAIN = 8331;
    //第四个Fragment中包含的Activity ID
    public static final int ACTIVITY_MEMO_MAIN = 8411;
    public static final int ACTIVITY_MEMO_ADD = 8412;
    public static final int ACTIVITY_WEATHER = 8421;
    public static final int ACTIVITY_CAlCULATION = 8431;
    public static final int ACTIVITY_TRANSLATION = 8441;

    protected Toolbar mToolbar;  // 通用toolbar，部分Activity为特殊toolbar（登录界面）

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = MyApplication.getInstance();
        mApplication.addActivity(this);
//        setContentView(R.layout.activity_base);
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mApplication.finishActivity(this);
    }

    protected void initData() {

    }

    protected void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    /*
     * 通过后缀和时间拼凑文件名
     */
    public String getFileName(String postFix) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(date) + "." + postFix;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //不知道为什么Log打不出来
        System.out.println("当前Activity：" + mApplication.currentActivity());
        return super.onKeyDown(keyCode, event);
    }

    public void exitApplication() {
        mApplication.AppExit();
    }

}
