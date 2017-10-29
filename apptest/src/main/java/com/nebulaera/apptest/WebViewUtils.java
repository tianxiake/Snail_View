package com.nebulaera.apptest;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;



/**
 * @author niyongliang on 2016/5/9.
 */
public class WebViewUtils {

    private WebViewUtils() {
    }

    public static void initWebView(WebView webView, WebViewClient webViewClient, DownloadListener downloadListener) {
        if (webView == null) {
            return;
        }
        // 开启硬件加速
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        if(webViewClient != null) {
            webView.setWebViewClient(webViewClient);
        } else {
            webView.setWebViewClient(new WebViewClient());
        }
        webView.setWebChromeClient(new WebChromeClient());
        // 处理下载
        webView.setDownloadListener(downloadListener);
        // 设置 Cookie
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        CookieManager.setAcceptFileSchemeCookies(true);

        WebSettings settings = webView.getSettings();
        // 支持 Js
        settings.setJavaScriptEnabled(true);
        // 设置可访问文件
        settings.setAllowContentAccess(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        // 设置缓存模式
        settings.setAppCacheEnabled(true);
//        settings.setAppCachePath(OperationFactory.getContext().getCacheDir().getAbsolutePath());
        // 设置缓冲大小10M
        settings.setAppCacheMaxSize(1024 * 1024 * 10);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 支持定位
        settings.setGeolocationEnabled(true);
        // 当webview调用requestFocus时为webview设置节点
        settings.setNeedInitialFocus(true);
        // 支持缩放
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        // 隐藏滚动条
        webView.setVerticalScrollBarEnabled(false);
        settings.setDisplayZoomControls(false);
        // 设置适应屏幕，两者合用
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        // 支持适应屏幕，内容将自动缩放
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // 支持获取手势焦点，输入用户名、密码或其他
        webView.requestFocusFromTouch();
        // 设置编码格式
        settings.setDefaultTextEncodingName("UTF-8");
        // 支持自动加载图片
        settings.setLoadsImagesAutomatically(true);
        // 支持多窗口
        settings.setSupportMultipleWindows(true);
        // 支持Js自动打开新窗口
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 支持插件
        settings.setPluginState(WebSettings.PluginState.ON);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);
        webView.requestFocus(View.FOCUS_DOWN);
        webView.onResume();
    }

    public static void destroyWebView(WebView webView){
        webView.stopLoading();
        webView.onPause();
        CookieManager.getInstance().removeAllCookie();
        webView.clearCache(true);
        webView.clearFormData();
        webView.clearHistory();
        ViewGroup parent = (ViewGroup) webView.getParent();
        if (parent != null) {
            parent.removeView(webView);
        }
        webView.destroy();
    }

}
