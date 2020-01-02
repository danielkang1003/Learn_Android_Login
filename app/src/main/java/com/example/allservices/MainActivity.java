package com.example.allservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    RelativeLayout RelativeLayout_login;
    String emailOk = "123@gmail.com", passwordOk ="1234";
    String inputEmail = "", inputPassword ="";

//    private FragmentManager fragmentManager = getSupportFragmentManager();
//    private Menu1Fragment menu1Fragment = new Menu1Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextInputEditText_email = findViewById(R.id.EditText_email);
        TextInputEditText_password = findViewById(R.id.EditText_password);
        RelativeLayout_login = findViewById(R.id.RelativeLayout_login);


//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                switch(menuItem.getItemId()){
//                    case R.id.navigation_menu1: {
//                        transaction.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();
//                        break;
//                    }
//                }
//                return true;
//            }
//        });

        //로직:
        //1. 값 가져오기 (이메일: 123@gmail.com / 비밀번호 : 1234 만 로그인 가능)
        //2. 클릭 감지 (우리가 정해놓은 값과 다르면 로그인 버튼 동작 x)
        //3. 값을 다른 액티비티(다음 화면)로 넘긴다.
        RelativeLayout_login.setClickable(false);
        RelativeLayout_login.setEnabled(false);

        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s != null){
                    Log.d("Daniel", s.toString());
                    inputEmail = s.toString();
                    RelativeLayout_login.setClickable(validation());
                    RelativeLayout_login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s != null){
                    Log.d("Daniel", s.toString());
                    inputPassword = s.toString();
                    RelativeLayout_login.setClickable(validation());
                    RelativeLayout_login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//        RelativeLayout_login.setClickable(true);    //클릭이 가능하다는 뜻
        RelativeLayout_login.setOnClickListener(new View.OnClickListener() {    //클릭 리스너를 달것.
            @Override
            public void onClick(View v) {
                Log.d("Daniel", "onClick");
                //클릭을 감지해서 값을 가지고 옴
                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();

                //인텐트는 현재 액티비티.this에서 이동할 액티비티.class로 설정
                //그냥 this로 하면 onclickListener의 this로 설정이 되버림. 우리는 mainActivity의 this를 사용할 것이므로
                //mainActivity.this로 해주기
                //이 네줄로 값이 LoginResultActivity로 넘어감.
                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });

    }

    public boolean validation(){
        Log.d("Daniel", inputEmail + " / " + inputPassword + " / " + (inputEmail.equals(emailOk)) + " / " + (inputPassword.equals(passwordOk)));
        return inputEmail.equals(emailOk) && inputPassword.equals(passwordOk);
    }

}
