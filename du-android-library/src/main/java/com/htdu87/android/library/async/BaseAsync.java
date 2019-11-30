package com.htdu87.android.library.async;

import android.app.Activity;
import android.os.AsyncTask;

import com.htdu87.android.library.R;
import com.htdu87.android.library.ui.Loading;

import java.lang.ref.WeakReference;

public abstract class BaseAsync<Params,Progress,Result> extends AsyncTask<Params,Progress,Result> {
    protected String msg;
    private WeakReference<Activity> weak;
    private Loading loading;

    public BaseAsync(Activity context) {
        weak=new WeakReference<>(context);
        loading=new Loading(context);
    }

    public BaseAsync(Activity context, String waitingText) {
        this(context);
        loading.setMessage(waitingText);
    }

    @Override
    protected void onPreExecute() {
        loading.show();
    }

    @Override
    protected void onPostExecute(Result result) {
        if (weak.get().isDestroyed())return;
        loading.dismiss();
    }

    @Override
    protected void onCancelled(Result result) {
        loading.dismiss();
    }

    @Override
    protected void onCancelled() {
        loading.dismiss();
    }

    protected Activity getContext(){
        return weak.get();
    }

    protected String httpCode2Msg(int code){
        switch (code){
            case 400:
                return getContext().getString(R.string.msg_http_400_err);
            case 401:
                return getContext().getString(R.string.msg_http_401_err);
            case 403:
                return getContext().getString(R.string.msg_http_403_err);
            case 404:
                return getContext().getString(R.string.msg_http_404_err);
            case 500:
                return getContext().getString(R.string.msg_http_500_err);
            case 502:
                return getContext().getString(R.string.msg_http_502_err);
            default:
                return getContext().getString(R.string.msg_unk_err);
        }
    }

    public void dismiss(){
        loading.dismiss();
    }
}
