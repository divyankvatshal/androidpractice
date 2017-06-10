package barcode.com.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ename,password;
    Button lgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ename=(EditText)findViewById(R.id.ename);
        password=(EditText)findViewById(R.id.epswd);
        lgbtn=(Button)findViewById(R.id.lgbtn);
        lgbtn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = ename.getText().toString();
                String pswd = password.getText().toString();
                if ((name.trim().length() > 0) && (pswd.trim().length() > 0)) {
                    Intent intent = new Intent(MainActivity.this, Second.class);
                    startActivity(intent);
                } /*else {
                    Toast.makeText(MainActivity.this, "Fields empty", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }
}

