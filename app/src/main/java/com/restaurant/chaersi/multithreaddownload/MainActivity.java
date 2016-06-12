package com.restaurant.chaersi.multithreaddownload;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aspsine.multithreaddownload.CallBack;
import com.aspsine.multithreaddownload.DownloadException;
import com.aspsine.multithreaddownload.DownloadInfo;
import com.aspsine.multithreaddownload.DownloadManager;
import com.aspsine.multithreaddownload.DownloadRequest;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.downloadRecycler) RecyclerView downloadView;

    private DownloadAdapter adapter;
    private ArrayList<HashMap<String,String>> downloadUrlArr;
    private static final DecimalFormat DF = new DecimalFormat("0.00");
    /**
     * Dir: /Download
     */
    private final File mDownloadDir = new File(Environment.getExternalStorageDirectory(), "Download");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

        downloadView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        downloadView.setLayoutManager(layoutManager);
        adapter = new DownloadAdapter(this,downloadUrlArr);
        downloadView.setAdapter(adapter);

        adapter.addItemListener(new RecyclerAdapterListener() {
            @Override
            public void onItemClickListener(int position) {

            }

            @Override
            public void onButtonListener(int position) {
                download(position);
            }
        });

    }

    private void initView(){
        downloadUrlArr=new ArrayList<HashMap<String,String>>();

        HashMap<String,String> item=new HashMap<String,String>();
        item.put("name","年轻的樵夫哟");
        item.put("type","m");
        item.put("url","http://211.151.183.204:9000/AppDownload/downloadTest.mp3");
        DownloadInfo downloadInfo = DownloadManager.getInstance().getDownloadProgress("http://211.151.183.204:9000/AppDownload/downloadTest.mp3");
        if (downloadInfo != null) {
            item.put("pro",downloadInfo.getProgress()+"");
            item.put("finished",DownloadUtils.getDownloadPerSize(downloadInfo.getFinished(),downloadInfo.getLength()));
            item.put("statue",DownloadUtils.STATUS_PAUSED+"");
            item.put("length",DF.format((float) downloadInfo.getLength() / (1024 * 1024)));

        }
        downloadUrlArr.add(item);

        HashMap<String,String> item2=new HashMap<String,String>();
        item2.put("name","网易新闻");
        item2.put("type","a");
        item2.put("url","http://ku.kuaiapk.com/kuwanhui-91/soft_kuplay/soft/com.netease.newsreader.activity_v7.0.apk");
        DownloadInfo downloadInfo2 = DownloadManager.getInstance().getDownloadProgress("http://ku.kuaiapk.com/kuwanhui-91/soft_kuplay/soft/com.netease.newsreader.activity_v7.0.apk");
        if (downloadInfo2 != null) {
            item2.put("pro",downloadInfo2.getProgress()+"");
            item2.put("finished",DownloadUtils.getDownloadPerSize(downloadInfo2.getFinished(),downloadInfo2.getLength()));
            item2.put("statue",DownloadUtils.STATUS_PAUSED+"");
            item2.put("length",DF.format((float) downloadInfo2.getLength() / (1024 * 1024)));
        }
        downloadUrlArr.add(item2);

        HashMap<String,String> item3=new HashMap<String,String>();
        item3.put("name","墨迹天气");
        item3.put("type","a");
        item3.put("url","http://221.235.187.72/ku.kuaiapk.com/kuwanhui-91/soft_kuplay/soft/com.moji.mjweather_v5.0902.02.apk?wsiphost=local");
        DownloadInfo downloadInfo3 = DownloadManager.getInstance().getDownloadProgress("http://221.235.187.72/ku.kuaiapk.com/kuwanhui-91/soft_kuplay/soft/com.moji.mjweather_v5.0902.02.apk?wsiphost=local");
        if (downloadInfo3 != null) {
            item3.put("pro",downloadInfo3.getProgress()+"");
            item3.put("finished",DownloadUtils.getDownloadPerSize(downloadInfo3.getFinished(),downloadInfo3.getLength()));
            item3.put("statue",DownloadUtils.STATUS_PAUSED+"");
            item3.put("length",DF.format((float) downloadInfo3.getLength() / (1024 * 1024)));

        }
        downloadUrlArr.add(item3);

        HashMap<String,String> item4=new HashMap<String,String>();
        item4.put("name","搜房");
        item4.put("type","a");
        item4.put("url","http://221.235.187.166/ku.kuaiapk.com/soft_kuplay/uploads/files/soft/2016/03/17/18/com.soufun.app_8.2.0.apk?wsiphost=local");
        DownloadInfo downloadInfo4 = DownloadManager.getInstance().getDownloadProgress("http://221.235.187.166/ku.kuaiapk.com/soft_kuplay/uploads/files/soft/2016/03/17/18/com.soufun.app_8.2.0.apk?wsiphost=local");
        if (downloadInfo4 != null) {
            item4.put("pro",downloadInfo4.getProgress()+"");
            item4.put("finished",DownloadUtils.getDownloadPerSize(downloadInfo4.getFinished(),downloadInfo4.getLength()));
            item4.put("statue",DownloadUtils.STATUS_PAUSED+"");
            item4.put("length",DF.format((float) downloadInfo4.getLength() / (1024 * 1024)));

        }
        downloadUrlArr.add(item4);

        HashMap<String,String> item5=new HashMap<String,String>();
        item5.put("name","秘密");
        item5.put("type","a");
        item5.put("url","http://6.tjwt1.crsky.com/sj/201512/mimi-v3.8.4.apk");
        DownloadInfo downloadInfo5 = DownloadManager.getInstance().getDownloadProgress("http://6.tjwt1.crsky.com/sj/201512/mimi-v3.8.4.apk");
        if (downloadInfo5 != null) {
            item5.put("pro",downloadInfo5.getProgress()+"");
            item5.put("finished",DownloadUtils.getDownloadPerSize(downloadInfo5.getFinished(),downloadInfo5.getLength()));
            item5.put("statue",DownloadUtils.STATUS_PAUSED+"");
            item5.put("length",DF.format((float) downloadInfo5.getLength() / (1024 * 1024)));

        }
        downloadUrlArr.add(item5);

    }

    @Override
    protected void onPause() {
        super.onPause();
        DownloadManager.getInstance().pauseAll();
    }

    /**
     * 通过tag进行某一个线程的暂停
     * @param tag
     */
    private void pause(String tag) {
        DownloadManager.getInstance().pause(tag);
    }

    private void download(final int position) {
        final DownloadRequest request = new DownloadRequest.Builder()
                .setTitle(downloadUrlArr.get(position).get("name") + ".apk")
                .setUri(downloadUrlArr.get(position).get("url"))
                .setFolder(mDownloadDir)
                .build();
        final String length=downloadUrlArr.get(position).get("length");
        DownloadManager.getInstance().download(request, downloadUrlArr.get(position).get("url"), new CallBack() {
            @Override
            public void onStarted() {
                //下载开始
            }

            @Override
            public void onConnecting() {
                //
            }

            @Override
            public void onConnected(long total, boolean isRangeSupport) {
                //
            }

            @Override
            public void onProgress(long finished, long total, int progress) {
                downloadUrlArr.get(position).put("pro",progress+"");
                downloadUrlArr.get(position).put("finished",DownloadUtils.getDownloadPerSize(finished,total));
                downloadUrlArr.get(position).put("statue",DownloadUtils.STATUS_DOWNLOADING+"");
                if (isCurrentListViewItemVisible(position)) {
                    DownloadAdapter.DownItemViewHolder holder = getViewHolder(position);
                    if(progress!=0){
                        holder.percentBar.setProgress(progress);
                    }else{
                        holder.percentBar.setProgress(0);
                    }
                    holder.percentView.setText(DownloadUtils.getDownloadPerSize(finished,total)!=null?DownloadUtils.getDownloadPerSize(finished,total):"0M/0M");
                }

                //进度条的进度
            }

            @Override
            public void onCompleted() {
                downloadUrlArr.get(position).put("pro","100");

                downloadUrlArr.get(position).put("finished",length+"M/"+length+"M");
                downloadUrlArr.get(position).put("statue",DownloadUtils.STATUS_COMPLETE+"");
                if (isCurrentListViewItemVisible(position)) {
                    DownloadAdapter.DownItemViewHolder holder = getViewHolder(position);
                    holder.percentBar.setProgress(100);
                    holder.percentView.setText(length+"M/"+length+"M");
                }
            }

            @Override
            public void onDownloadPaused() {
                //
            }

            @Override
            public void onDownloadCanceled() {
                //
            }

            @Override
            public void onFailed(DownloadException e) {
                //
            }
        });
    }

    private DownloadAdapter.DownItemViewHolder getViewHolder(int position) {
        return (DownloadAdapter.DownItemViewHolder) downloadView.findViewHolderForLayoutPosition(position);
    }

    private boolean isCurrentListViewItemVisible(int position) {
        LinearLayoutManager layoutManager = (LinearLayoutManager)downloadView.getLayoutManager();
        int first = layoutManager.findFirstVisibleItemPosition();
        int last = layoutManager.findLastVisibleItemPosition();
        return first <= position && position <= last;
    }

}
