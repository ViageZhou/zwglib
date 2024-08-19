package com.zwg.xfj;

import android.app.Application;

import com.zwg.xfj.db.DBHelper;
import com.zyhp.zwglib.utils.MMKVHelper;

/**
 * Created by ZhouWengong on 2024/7/11.
 */
public class App extends Application {
    public static final String TAG = App.class.getSimpleName();
//    private YF_RK356x_API_Manager yfapi;

    private static App app;

    public static App getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        MMKVHelper.init(getApplicationContext());
        DBHelper.init(getApplicationContext());





//        String str = "周文塨";
//        String hexStr = stringToHex(str);
////        System.out.println(hexStr); // 输出结果依赖于字符的编码方式，这里使用的是char的数值转换
//        Log.e(TAG, "zwg----[onCreate]: hexStr = " + hexStr);
//        // 注意：上述方法仅适用于单个字符能映射到单个字节的编码（如ISO-8859-1），
//        // 对于UTF-8编码的中文，我们需要按字节转换
//        try {
//            byte[] bytes = str.getBytes("UTF-8"); // 使用UTF-8编码获取字节数组
//            StringBuilder hex = new StringBuilder();
//            for (byte b : bytes) {
//                String hex1 = Integer.toHexString(0xff & b);
//                if (hex1.length() == 1) hex.append('0');
//                hex.append(hex1);
//            }
////            System.out.println(hex.toString()); // 输出UTF-8编码下的16进制字符串
//            Log.e(TAG, "zwg----[onCreate]: hexStr1 = " + hex);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }


//        DisplayHelper.init(getApplicationContext());
//        DisplayHelper.printInfo();

//        String s = "19.45555555";
//        BigDecimal decimal = new BigDecimal(s);
//        BigDecimal multiply = decimal.multiply(new BigDecimal(100));
//
//        Log.e(TAG, "zwg----[onCreate]: multiply =  " + multiply.toString());
//
//        long parseLong = Long.parseLong(multiply.toString());
//
//        Log.e(TAG, "zwg----[onCreate]: parseLong =  " + multiply.longValue());

//        double v = Double.parseDouble(s);
//        Log.e(TAG, "zwg----[onCreate]:  " + v);


//        float v = Float.parseFloat(s);
//        Log.e(TAG, "zwg----[onCreate]:  v = " + v);
//        double v1 = v * 100.0;
//        Log.e(TAG, "zwg----[onCreate]:  v1 = " + v1);
//        long l = (long) v1;
//        Log.e(TAG, "zwg----[onCreate]:  l = " + l);

    }

}
