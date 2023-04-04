package net.skhu;

import static net.skhu.SignUPActivity.isEmptyOrWhiteSpace;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        Button button = (Button) findViewById(R.id.btnsave);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText editText_title = findViewById(R.id.editText_title);
                String title = editText_title.getText().toString();
                if(isEmptyOrWhiteSpace(title))
                    editText_title.setError("제목을 입력하세요");

                String msg = "저장 성공"+title;
                Toast.makeText(MemoActivity.this,msg,Toast.LENGTH_LONG).show();

            }
        };
        button.setOnClickListener(listener);
    }

    static boolean isEmptyOrWhiteSpace(String s){
        if(s==null) return true;
        return s.toString().trim().trim().length()==0;
    }
}