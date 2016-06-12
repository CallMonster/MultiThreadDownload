package com.restaurant.chaersi.multithreaddownload;

import java.text.DecimalFormat;

/**
 * Created by Chaersi on 16/6/2.
 */
public class DownloadUtils {

    public static final int STATUS_NOT_DOWNLOAD = 0;//没有下载状态
    public static final int STATUS_CONNECTING = 1;//连接中状态
    public static final int STATUS_CONNECT_ERROR = 2;//连接错误状态
    public static final int STATUS_DOWNLOADING = 3;//下载中状态
    public static final int STATUS_PAUSED = 4;//暂停状态
    public static final int STATUS_DOWNLOAD_ERROR = 5;//下载错误状态
    public static final int STATUS_COMPLETE = 6;//下载完成
    public static final int STATUS_INSTALLED = 7;//已经安装


    /**
     * 进行格式化
     */
    private static final DecimalFormat DF = new DecimalFormat("0.00");
    public static String getDownloadPerSize(long finished, long total) {
        return DF.format((float) finished / (1024 * 1024)) + "M/" + DF.format((float) total / (1024 * 1024)) + "M";
    }

}
