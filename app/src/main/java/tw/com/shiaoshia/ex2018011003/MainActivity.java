package tw.com.shiaoshia.ex2018011003;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //new Handler() Override handleMessage取得Message
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("MSG","取得一個Message");
            Bundle bundle = msg.getData();
            String str = bundle.getString("data");
            Log.d("MSG","data" + str);
        }
    };

    public void click01(View v) {
        Message msg = new Message();
        //handler.sendMessage(msg);   //送出Message資料
        Bundle bundle = new Bundle();
        bundle.putString("data","MyData");
        msg.setData(bundle);
        handler.sendMessageDelayed(msg,3000);   //3秒後再送出Message
    }
}
