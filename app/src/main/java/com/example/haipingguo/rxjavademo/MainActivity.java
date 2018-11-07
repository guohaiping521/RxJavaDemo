package com.example.haipingguo.rxjavademo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.haipingguo.rxjavademo.test6.AsyncJob;
import com.example.haipingguo.rxjavademo.test6.Callback;
import com.example.haipingguo.rxjavademo.test6.CatsHelper;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        CatsHelper catsHelper = new CatsHelper();
        //test1
        /* Uri uri = catsHelper.saveTheCutestCat("1");*/
        //test2
        /*catsHelper.saveTheCutestCat("1", new CatsHelper.CutestCatCallback() {
            @Override
            public void onCutestCatSaved(Uri uri) {

            }

            @Override
            public void onQueryFailed(Exception e) {

            }
        });*/
        //test3
        /*catsHelper.saveTheCutestCat("12", new CatsHelper.CutestCatCallback() {
            @Override
            public void onCutestCatSaved(Uri uri) {
                Log.i("ghpppp","uri=="+uri);
            }

            @Override
            public void onQueryFailed(Exception e) {

            }
        });*/
        //test4
       /* catsHelper.saveTheCutestCat("1", new ApiI.Callback<Uri>() {
            @Override
            public void onResult(Uri result) {
                Log.i("ghpppp","result=="+result);
            }

            @Override
            public void onError(Exception e) {

            }
        });*/
        //test5
        //catsHelper.saveTheCutestCat("12");

        //test6
        catsHelper.saveCutestCat("12").start(new Callback<Uri>() {
            @Override
            public void onResult(Uri result) {
                Log.i("ghpppp", "result==" + result);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
