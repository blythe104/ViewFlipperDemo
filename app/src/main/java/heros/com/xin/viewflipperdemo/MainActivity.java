package heros.com.xin.viewflipperdemo;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * 实现动画的两种方式，一种是触摸滑动，另一种是按钮触发事件
 */
public class MainActivity extends BaseActivity implements View.OnTouchListener, GestureDetector.OnGestureListener {

    private Button btnpre;
    private Button btnnext;
    private ViewFlipper flipper;
    private GestureDetector gestureDetector = null;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        //ViewFlipper的对象
        flipper = (ViewFlipper) findViewById(R.id.flipper);

        //定义按钮
        btnnext = (Button) findViewById(R.id.btn_next);
        btnpre = (Button) findViewById(R.id.btn_pre);

        //为其自定义内容
        flipper.addView(addImageById(R.mipmap.img1));
        flipper.addView(addImageById(R.mipmap.img2));
        flipper.addView(addImageById(R.mipmap.img3));
        flipper.addView(addImageById(R.mipmap.img4));
        flipper.addView(addImageById(R.mipmap.img5));
        flipper.addView(addImageById(R.mipmap.img6));
        gestureDetector = new GestureDetector(this);
        //自动播放ViewFlipper里的内容
        //   flipper.startFlipping();
    }

    @Override
    public void initListener() {
        /**
         * 设置监听事件
         */
        btnpre.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        flipper.setOnTouchListener(this);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    /**
     * 判断手势滑动的时候，手指所处的位置
     *
     * @param e1
     * @param e2
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e2.getX() - e1.getX() > 120) {            // 从左向右滑动（左进右出）
            Animation rInAnim = AnimationUtils.loadAnimation(this, R.anim.activity_previous_in); // 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）
            Animation rOutAnim = AnimationUtils.loadAnimation(this, R.anim.activity_previous_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

            flipper.setInAnimation(rInAnim);
            flipper.setOutAnimation(rOutAnim);
            flipper.showPrevious();
            return true;
        } else if (e2.getX() - e1.getX() < -120) {        // 从右向左滑动（右进左出）
            Animation lInAnim = AnimationUtils.loadAnimation(this, R.anim.activity_next_in); // 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）
            Animation lOutAnim = AnimationUtils.loadAnimation(this, R.anim.activity_next_out); //   // 向左滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

            flipper.setInAnimation(lInAnim);
            flipper.setOutAnimation(lOutAnim);
            flipper.showNext();
            return true;
        }
        return true;
    }

    @Override
    public void initData() {

    }

    /**
     * 按钮事件响应动画的移动
     */
    @Override
    public void processClick(View v) {

        switch (v.getId()) {
            case R.id.btn_pre:
                Animation rInAnim = AnimationUtils.loadAnimation(this, R.anim.activity_previous_in); // 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）
                Animation rOutAnim = AnimationUtils.loadAnimation(this, R.anim.activity_previous_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）
                flipper.setInAnimation(rInAnim);
                flipper.setOutAnimation(rOutAnim);
                flipper.showPrevious();
                break;
            case R.id.btn_next:
                Animation lInAnim = AnimationUtils.loadAnimation(this, R.anim.activity_next_in); // 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）
                Animation lOutAnim = AnimationUtils.loadAnimation(this, R.anim.activity_next_out); //   // 向左滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）
                flipper.setInAnimation(lInAnim);
                flipper.setOutAnimation(lOutAnim);
                flipper.showNext();
                break;
        }

    }

    public View addImageById(int id) {
        ImageView iv = new ImageView(this);
        iv.setImageResource(id);
        return iv;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }


}
