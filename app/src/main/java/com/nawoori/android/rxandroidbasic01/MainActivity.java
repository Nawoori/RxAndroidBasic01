package com.nawoori.android.rxandroidbasic01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    Subject subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //서브젝트 생성
        subject = new Subject();
        //서브젝트 동작시작
        subject.start();
    }
    int count = 0;
    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        //버튼이 클릭 될 때마다 subject에 옵저버를 추가
        button.setOnClickListener(v ->{
            count++;
            subject.addObserver(new Subject.Observer() {
                String myName = "Observer"+ count;

                @Override
                public void notification(String msg) {

                }
            });
        });


    }
}
