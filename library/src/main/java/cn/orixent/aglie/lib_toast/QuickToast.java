package cn.orixent.aglie.lib_toast;

import android.app.Application;
import android.view.View;

import cn.orixent.aglie.lib_toast.config.IToastInterceptor;
import cn.orixent.aglie.lib_toast.config.IToastStrategy;
import cn.orixent.aglie.lib_toast.config.IToastStyle;
import cn.orixent.aglie.lib_toast.style.BlackToastStyle;
import cn.orixent.aglie.lib_toast.style.WhiteToastStyle;

/**
 * 封装的Toast工具库
 */
public class QuickToast {

    /**
     * 初始化 Toast，需要在 Application.create 中初始化
     *
     * @param application 应用的上下文
     */
    public static void init(Application application) {
        ToastUtils.init(application);
    }


    /**
     * 初始化 Toast，需要在 Application.create 中初始化
     *
     * @param application 应用的上下文
     */
    public static void init(Application application, IToastStrategy strategy) {
        ToastUtils.init(application, strategy, null);
    }


    /**
     * 初始化 Toast，需要在 Application.create 中初始化
     *
     * @param application 应用的上下文
     */
    public static void init(Application application, IToastStyle<?> style) {
        ToastUtils.init(application, null, style);
    }

    /**
     * 初始化 Toast
     *
     * @param application 应用的上下文
     * @param strategy    Toast 策略
     * @param style       Toast 样式
     */
    public static void init(Application application, IToastStrategy strategy, IToastStyle<?> style) {
        ToastUtils.init(application,
                strategy, style);
    }


    /**
     * 判断当前框架是否已经初始化
     */
    public static boolean isInit() {
        return ToastUtils.isInit();
    }


    /**
     * 显示Toast
     *
     * @param id
     */
    public static void show(int id) {
        ToastUtils.show(id);
    }


    /**
     * @param object
     */
    public static void show(Object object) {
        ToastUtils.show(object);
    }

    /**
     * 显示
     *
     * @param text 字符串
     */
    public static void show(CharSequence text) {
        ToastUtils.show(text);
    }

    /**
     * 延迟显示 Toast
     */
    public static void delayedShow(int id, long delayMillis) {

        ToastUtils.delayedShow(id, delayMillis);
    }

    /**
     * 延迟显示 Toast
     */
    public static void delayedShow(CharSequence text, long delayMillis) {
        ToastUtils.delayedShow(text, delayMillis);
    }

    /**
     * 延迟显示 Toast
     */
    public static void delayedShow(Object object, long delayMillis) {
        ToastUtils.delayedShow(object, delayMillis);
    }

    /**
     * debug Toast
     */
    public static void debugShow(int id) {
        ToastUtils.debugShow(id);
    }

    /**
     * debug Toast
     */
    public static void debugShow(CharSequence text) {
        ToastUtils.debugShow(text);
    }

    /**
     * debug Toast
     */
    public static void debugShow(Object object) {
        ToastUtils.debugShow(object);
    }


    /**
     * 取消吐司的显示
     */
    public static void cancel() {
        ToastUtils.cancel();
    }

    /**
     * 设置吐司的位置
     *
     * @param gravity 重心
     */
    public static void setGravity(int gravity) {
        setGravity(gravity, 0, 0);
    }

    public static void setGravity(int gravity, int xOffset, int yOffset) {
        setGravity(gravity, xOffset, yOffset, 0, 0);
    }

    public static void setGravity(int gravity, int xOffset, int yOffset, float horizontalMargin, float verticalMargin) {
        ToastUtils.setGravity(gravity, xOffset, yOffset, horizontalMargin, verticalMargin);
    }

    /**
     * 给当前 Toast 设置新的布局
     */
    public static void setView(int id) {
        ToastUtils.setView(id);
    }

    /**
     * 初始化全局的 Toast 样式
     *
     * @param style 样式实现类，框架已经实现两种不同的样式
     *              黑色样式：{@link BlackToastStyle}
     *              白色样式：{@link WhiteToastStyle}
     */
    public static void setStyle(IToastStyle<?> style) {
        ToastUtils.setStyle(style);
    }

    public static IToastStyle<?> getStyle() {
        return ToastUtils.getStyle();
    }

    /**
     * 设置 Toast 显示策略
     */
    public static void setStrategy(IToastStrategy strategy) {
        ToastUtils.setStrategy(strategy);
    }

    public static IToastStrategy getStrategy() {
        return ToastUtils.getStrategy();
    }

    /**
     * 设置 Toast 拦截器（可以根据显示的内容决定是否拦截这个Toast）
     * 场景：打印 Toast 内容日志、根据 Toast 内容是否包含敏感字来动态切换其他方式显示（这里可以使用我的另外一套框架 XToast）
     */
    public static void setInterceptor(IToastInterceptor interceptor) {
        ToastUtils.setInterceptor(interceptor);
    }

    public static IToastInterceptor getInterceptor() {
        return ToastUtils.getInterceptor();
    }

    /**
     * 是否为调试模式
     *
     * @param debug true=是
     */
    public static void setDebugMode(boolean debug) {
        ToastUtils.setDebugMode(debug);
    }

    public static boolean isDebugMode() {
        return ToastUtils.isDebugMode();
    }


    public static void show8(View v) {
        // TODO 扩展悬浮 toast
    }


}
