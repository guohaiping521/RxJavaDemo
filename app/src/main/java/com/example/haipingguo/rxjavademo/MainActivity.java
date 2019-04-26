package com.example.haipingguo.rxjavademo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haipingguo.rxjavademo.rxdemo.TestRxDemo;
import com.example.haipingguo.rxjavademo.thread.TestCallable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ghppp";
    private static final int REQUEST_CODE_WRITE_SETTINGS = 1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 2;
    private static final int REQUEST_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
       // TestCallable.test();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Observable.create(new ObservableOnSubscribeI<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) {
                        emitter.onNext("1");
                        emitter.onNext("2");
                        emitter.onNext("3");
                        emitter.onComplete();
                    }
                }).subscribeOn(Schedulers.newThread())
                        .subscribe(new ObserverI<String>() {
                            private DisposableI disposable;

                            @Override
                            public void onSubscribe(DisposableI d) {
                                disposable=d;
                            }

                            @Override
                            public void onNext(String s) {
                                if("2".equals(s)){
                                    Log.i("ghppppp","disposable=="+disposable);
                                    disposable.dispose();
                                }
                                Log.i("ghppppp","s=="+s);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("ghppppp","onError");
                            }

                            @Override
                            public void onComplete() {
                                Log.i("ghppppp","onComplete");
                            }
                        });*/
              //  TestRxDemo.requestNetData();
             
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            
            }
        });

       /* TestRxDemo.requestNetData();
        CatsHelper catsHelper=new CatsHelper();
        catsHelper.saveCutestCat("123").subscribe(new Callback<Uri>() {
            @Override
            public void onResult(Uri result) {
                Log.i("ghppppp","result==="+result);
            }

            @Override
            public void onError(Exception e) {

            }
        });*/
    }

    private void basicRxjava2() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                e.onNext("1");
                e.onNext("2");
                e.onNext("3");
                e.onNext("4");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void requestAlertWindowPermission() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, REQUEST_CODE);
    }


    private void requestWriteSettings() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, REQUEST_CODE_WRITE_SETTINGS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_WRITE_SETTINGS) {
            if (Settings.System.canWrite(this)) {
                Log.i(TAG, "onActivityResult write settings granted");
            }
        } else if (requestCode == REQUEST_CODE) {
            if (Settings.canDrawOverlays(this)) {
                Log.i(TAG, "onActivityResult granted");
            }
        }
    }

    /**
     * 打开系统相机
     */
    private void openSysCamera() {
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //系统常量， 启动相机的关键
        startActivityForResult(openCameraIntent, REQUEST_CODE_TAKE_PICTURE);
    }
}
