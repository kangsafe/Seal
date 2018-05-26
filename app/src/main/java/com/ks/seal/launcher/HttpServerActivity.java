package com.ks.seal.launcher;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.ks.seal.launcher.view.DragFloatActionButton;
import com.ks.seal.launcher.view.TextViewVertical;
import com.tencent.assistant.link.sdk.AppLinkHelper;

public class HttpServerActivity extends AppCompatActivity implements View.OnClickListener {
    private HorizontalScrollView sv;
    private TextViewVertical tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_server);
        String t = getIntent().getStringExtra("key");
        Log.i("TAG", t == null ? "1" : t);
        Intent intent = getIntent();
        String scheme = intent.getScheme();
        Uri uri = intent.getData();
        System.out.println("scheme:" + scheme);
        if (uri != null) {
            String host = uri.getHost();
            String dataString = intent.getDataString();
            String id = uri.getQueryParameter("key");
            String path = uri.getPath();
            String path1 = uri.getEncodedPath();
            String queryString = uri.getQuery();
            System.out.println("host:" + host);
            System.out.println("dataString:" + dataString);
            System.out.println("id:" + id);
            System.out.println("path:" + path);
            System.out.println("path1:" + path1);
            System.out.println("queryString:" + queryString);
        }
        getAppLink();
        String link = AppLinkHelper.getSDCardActionTask(this);
        System.out.print(link);

        tv = (TextViewVertical) findViewById(R.id.tv);
        tv.setTextSize(100);
        sv = (HorizontalScrollView) findViewById(R.id.sv);

        //设置接口事件接收
        Handler handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case TextViewVertical.LAYOUT_CHANGED:
                        sv.scrollBy(tv.getTextWidth(), 0);//滚动到最右边
                        break;
                }
            }
        };
        tv.setHandler(handler);//将Handler绑定到TextViewVertical

        //创建并设置字体（这里只是为了效果好看一些，但为了让网友们更容易下载，字体库并没有一同打包
        //如果需要体验下效果的朋友可以自行在网络上搜索stxingkai.ttf并放入assets/fonts/中）
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/huawenlishu.ttf");
        tv.setTypeface(face);

        //设置文字内容
        tv.setText("测试\n这是一段测试文字，主要是为了测试竖直排版TextView的显示效果。" +
                "为了能更好的体验感受，我特意增加了比较接近书法的字体和颜色，如果有什么改进的建议请发邮件到我的邮箱吧。" +
                "\n竖直排版的TextView需要配合HorizontalScrollView使用才能有更佳的效果。当然，如果你有时间的话，也可以给这个类" +
                "加上滚动的功能。");
        findViewById(R.id.vdrag).setOnClickListener(this);
    }

    private void getAppLink() {
        String pmg = getPackageName();
        String value = "";
        ContentResolver resolver = getContentResolver();
        if (resolver != null) {
            Uri contentUri = Uri.parse("content://com.tencent.android.qqdownloader.applink.provider/applink_provider_task");
            Cursor cursor = null;
            try {
                cursor = resolver.query(contentUri, null, "packageName=?", new String[]{pmg}, null);
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        value = cursor.getString(cursor.getColumnIndexOrThrow("uri"));
                        System.out.println("url:" + value);
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vdrag:

//                PopupMenu popupMenu=new PopupMenu(this,view);
//                getMenuInflater().inflate(R.menu.pop_item,popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        switch (menuItem.getItemId()){
//                            case R.id.action_last:
//                                Toast.makeText(TestActivity.this,""+menuItem.getItemId(),Toast.LENGTH_SHORT).show();
//                                break;
//                            case R.id.action_next:
//                                Toast.makeText(TestActivity.this,""+menuItem.getItemId(),Toast.LENGTH_SHORT).show();
//                                break;
//                        }
//
//                        return false;
//                    }
//                });
//                popupMenu.show();
                Log.e("****--->","float");
                // Toast.makeText(this,"flaot---",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
