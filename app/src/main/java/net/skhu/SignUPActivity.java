package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button button =findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText editText_loginId = findViewById(R.id.editText_loginId);
                String loginId = editText_loginId.getText().toString();
                if (isEmptyOrWhiteSpace(loginId))
                    editText_loginId.setError("로그인 아이디를 입력하세요");

                EditText editText_password = findViewById(R.id.editText_password);
                String password = editText_password.getText().toString();
                if (isEmptyOrWhiteSpace(password))
                    editText_password.setError("비밀번호를 입력하세요.");

                EditText editText_password2 = findViewById(R.id.editText_password2);
                String password2 = editText_password2.getText().toString();
                if (password.equals(password2)==false)
                    editText_password2.setError("비밀번호가 일치하지 않습니다.");

                EditText editText_email = findViewById(R.id.editText_email);
                String email = editText_email.getText().toString();

                String msg = "회원가입 성공:" + loginId + ""+ email;
                Toast.makeText(SignUPActivity.this,msg, Toast.LENGTH_LONG).show();

            }
        };
        button.setOnClickListener(listener);
    }
    static boolean isEmptyOrWhiteSpace(String s){
        if(s==null) return true;
        return s.trim().length()==0;
    }
}