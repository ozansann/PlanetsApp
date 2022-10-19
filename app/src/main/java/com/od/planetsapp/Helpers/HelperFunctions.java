package com.od.planetsapp.Helpers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.navigation.NavOptions;

import com.bumptech.glide.Glide;
import com.od.planetsapp.R;
import com.od.planetsapp.databinding.DialogLoadingBinding;

public class HelperFunctions {
    private static Dialog loadingDialog;
    private static DialogLoadingBinding dialogBinding;
    NavOptions.Builder navBuilder;
    LayoutInflater inflater;

    public static void showLoadingDialog(Context context) {
        loadingDialog = showProgress(context);
    }

    public static void hideLoadingDialog(){
        if(loadingDialog != null){
            loadingDialog.dismiss();
        }
    }

    public static Dialog showProgress(Context context) {
        getActivity(context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        Dialog mDialog;
        mDialog = new Dialog(context);
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                getActivity(context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        });
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dialogBinding = DialogLoadingBinding.inflate(inflater);
        mDialog.setContentView(dialogBinding.getRoot());
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Glide.with(context).asGif().load(R.raw.loading).into(dialogBinding.ivLoading);
        mDialog.findViewById(R.id.iv_loading).setVisibility(View.VISIBLE);
        mDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        return mDialog;
    }
    public static Activity getActivity(Context context) {
        if (context == null) return null;
        if (context instanceof Activity) return (Activity) context;
        if (context instanceof ContextWrapper) return getActivity(((ContextWrapper)context).getBaseContext());
        if(context instanceof ContextThemeWrapper) return getActivity(((ContextThemeWrapper)context).getBaseContext());
        return null;
    }
}
