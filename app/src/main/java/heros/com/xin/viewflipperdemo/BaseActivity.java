package heros.com.xin.viewflipperdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;


public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initListener();
        initData();
        // 将Activity添加到Application中 方便在退出App的时候统一销毁Activities
        BaseApplication.getInstance().addActivity(this);
    }

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();

    public abstract void processClick(View v);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.getInstance().removeActivity(this);
    }

    @Override
    public void onClick(View v) {
        processClick(v);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //监听回退键
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                ActivityUtils.finishActivityLeftInRightOutWithFinish(BaseActivity.this);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
