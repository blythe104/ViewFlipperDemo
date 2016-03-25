package heros.com.xin.viewflipperdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wangpeng on 2016/3/11.
 */
public class ActivityUtils {

    private final static String PARAMS = "keyvalue";

    private static List<Activity> mActivityList = new ArrayList<Activity>();

    public static void startActivityLeftOutRightInWithFinish(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
        ((Activity) context).finish();
        ((Activity) context).overridePendingTransition(R.anim.activity_next_in, R.anim.activity_next_out);
    }

    public static void startActivityLeftOutRightIn(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.activity_next_in, R.anim.activity_next_out);
    }

    public static void startActivityLeftInRightOutWithFinish(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
        ((Activity) context).finish();
        ((Activity) context).overridePendingTransition(R.anim.activity_previous_in, R.anim
                .activity_previous_out);
    }

    public static void startActivityLeftInRightOut(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.activity_previous_in, R.anim
                .activity_previous_out);
    }

    public static void finishActivityLeftInRightOutWithFinish(Context context) {
        ((Activity) context).finish();
        ((Activity) context).overridePendingTransition(R.anim.activity_previous_in, R.anim
                .activity_previous_out);
    }

    public static void finishActivityLeftInRightOut(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.activity_previous_in, R.anim
                .activity_previous_out);
    }

    /**
     * 收集开启的Activity
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        if (!mActivityList.contains(activity)) {
            mActivityList.add(activity);
        }
    }

    /**
     * 回收开启的Activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        if (mActivityList.contains(activity)) {
            mActivityList.remove(activity);
        }
    }

    /**
     * 销毁所有的Activity
     */
    public static void finishAllActivity() {
        for (Activity activity : mActivityList) {
            if (!activity.isFinishing())
                activity.finish();
        }
    }
}
