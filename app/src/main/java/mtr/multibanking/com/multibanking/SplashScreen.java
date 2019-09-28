package mtr.multibanking.com.multibanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {
    private int st = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        LogoLauncher lg = new LogoLauncher();
        lg.start();

    }

    private class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(1000*st);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent i = new Intent(SplashScreen.this,MainActivity.class);
            startActivity(i);
            SplashScreen.this.finish();

        }
    }
}
