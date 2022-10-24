package cn.orixent.aglie.lib_toast.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import cn.orixent.aglie.lib_toast.QuickToast;
import com.hjq.toast.demo.R;
import cn.orixent.aglie.lib_toast.style.BlackToastStyle;
import cn.orixent.aglie.lib_toast.style.WhiteToastStyle;
import com.hjq.xtoast.XToast;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/QuickToast
 *    time   : 2018/09/01
 *    desc   : QuickToast 使用案例
 */
public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TitleBar titleBar = findViewById(R.id.tb_main_bar);
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onTitleClick(TitleBar titleBar) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(titleBar.getTitle().toString()));
                startActivity(intent);
            }
        });
    }

    public void show1(View v) {
        QuickToast.show("我是普通的 Toast");
    }

    public void show2(View v) {
        QuickToast.delayedShow("我是延迟 2 秒显示的 Toast", 2000);
    }

    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public void show3(View v) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                QuickToast.show("我是子线程中弹出的吐司");
            }
        }).start();
    }

    public void show4(View v) {
        QuickToast.setStyle(new WhiteToastStyle());
        QuickToast.show("动态切换白色吐司样式成功");
    }

    public void show5(View v) {
        QuickToast.setStyle(new BlackToastStyle());
        QuickToast.show("动态切换黑色吐司样式成功");
    }

    public void show6(View v) {
        QuickToast.setView(R.layout.toast_custom_view);
        QuickToast.setGravity(Gravity.CENTER);
        QuickToast.show("自定义 Toast 布局");
    }

    public void show7(View v) {
        Snackbar.make(getWindow().getDecorView(), "温馨提示：安卓 10 在后台显示 Toast 需要有通知栏权限或者悬浮窗权限的情况下才可以显示", Snackbar.LENGTH_SHORT).show();

        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        }, 2000);

        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (XXPermissions.isGranted(MainActivity.this, Permission.SYSTEM_ALERT_WINDOW)) {
                        QuickToast.show("我是在后台显示的 Toast（有悬浮窗权限真的可以为所欲为）");
                    } else {
                        QuickToast.show("我是在后台显示的 Toast（安卓 11 及以上在后台显示只能使用系统样式）");
                    }
                } else {
                    QuickToast.show("我是在后台显示的 Toast");
                }
            }
        }, 3000);
    }

    public void show8(View v) {
        new XToast<>(this)
                .setDuration(1000)
                // 将 QuickToast 中的 View 转移给 XToast 来显示
                .setContentView(QuickToast.getStyle().createView(getApplication()))
                .setAnimStyle(android.R.style.Animation_Translucent)
                .setText(android.R.id.message, "就问你溜不溜")
                .setGravity(Gravity.BOTTOM)
                .setYOffset((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics()))
                .show();
    }
}