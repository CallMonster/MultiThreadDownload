# MultiThreadDownload

How to use：

Step 1: Add permission in 'AndroidManifest.xml'
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

Step 2: Add "compile project(':library')" in your 'build.gradle' file.(Maven or jCenter support will be coming soon)

Step 3: Config it in your Application class
private void initDownloader() {
    DownloadConfiguration configuration = new DownloadConfiguration();
    configuration.setMaxThreadNum(10);
    configuration.setThreadNum(3);
    DownloadManager.getInstance().init(getApplicationContext(), configuration);
}

Step 4: Just use it!
// first: build a DownloadRequest:
final DownloadRequest request = new DownloadRequest.Builder()
            .setTitle(appInfo.getName() + ".apk")
            .setUri(appInfo.getUrl())
            .setFolder(mDownloadDir)
            .build();

// download:
// the tag here, you can simply use download uri as your tag;
DownloadManager.getInstance().download(request, tag, new CallBack() {
    @Override
    public void onStarted() {

    }

    @Override
    public void onConnecting() {

    }

    @Override
    public void onConnected(long total, boolean isRangeSupport) {

    }

    @Override
    public void onProgress(long finished, long total, int progress) {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onDownloadPaused() {

    }

    @Override
    public void onDownloadCanceled() {

    }

    @Override
    public void onFailed(DownloadException e) {

    }
});

//pause
DownloadManager.getInstance().pause(tag);

//pause all
DownloadManager.getInstance().pauseAll();

//cancel
DownloadManager.getInstance().cancel(tag);

//cancel all
DownloadManager.getInstance().cancelAll();



