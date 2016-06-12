package com.restaurant.chaersi.multithreaddownload;

import android.content.Context;
import android.os.Environment;

/**
 * Created by Chaersi on 16/5/31.
 */
public class FilePathUtils {

    /**
     * 返回 File ，获取 Android 数据目录
     * @return /data
     */
    public static String getDataPath(){
        return Environment.getDataDirectory().getAbsolutePath();
    }

    /**
     * 返回 File ，获取 Android 下载/缓存内容目录。
     * @return /cache
     */
    public static String getCachePath(){
        return Environment.getDownloadCacheDirectory().getAbsolutePath();
    }

    /**
     * 返回 File ，获取外部存储目录即 SDCard
     * @return /storage/emulated/0
     */
    public static String getExternalStoragePath(){
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * 返回 File ，获取外部存储设备的当前状态
     * @return
     */
    public static String getExternalStorageState(){
        return Environment.getExternalStorageState();
    }

    /**
     * 解释：返回 File ，获取 Android 的根目录
     * @return /system
     */
    public static String getRootPath() {
        return Environment.getRootDirectory().getAbsolutePath();
    }

    /**
     * 获取应用目录
     * @param context
     * @return
     */
    public static String getApplicationPath(Context context) {

//        /data/data/com.restaurant.chaersi.multithreaddownload/files
//        return context.getApplicationContext().getFilesDir().getAbsolutePath();

        ///data/data/com.restaurant.chaersi.multithreaddownload
        return context.getApplicationContext().getFilesDir().getParent();
    }

}
