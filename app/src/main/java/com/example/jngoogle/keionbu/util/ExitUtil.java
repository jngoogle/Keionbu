package com.example.jngoogle.keionbu.util;

/**
 * Created by jngoogle on 2017/1/18 22:25.
 * email: guyuanhaofan@cnicg.cn
 */

public class ExitUtil {

    private static long latestTime = 0;
    private static final int timeHold = 1000;// 双击之间的时间阈值

    public static boolean exitApp() {
        long curTime = System.currentTimeMillis();
        boolean b = curTime - latestTime < timeHold;
        latestTime = curTime;
        return b;
    }
}
