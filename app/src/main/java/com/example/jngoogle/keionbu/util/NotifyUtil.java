package com.example.jngoogle.keionbu.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.example.jngoogle.keionbu.R;

/**
 * Created by jngoogle on 2017/3/17.
 * Email: jammicnicoole@gmail.com
 */

public class NotifyUtil {

    public static Notification createNotification(Context context, String title, String content) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(title);
        builder.setContentText(content);
        return builder.build();
    }

    /**
     *
     * @param context
     * @param title
     * @param content
     * @param identify application unique identifier for this notification
     */
    public static void sendNotification(Context context, String title, String content, int identify) {
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(identify, createNotification(context, title, content));
    }
}
