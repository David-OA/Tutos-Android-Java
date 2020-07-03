package com.example.espresso;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login) Button login;
    @BindView(R.id.editText) EditText editText;
    @BindView(R.id.loginContainer) View loginContainer;
    @BindView(R.id.textContainer) View textContainer;
    @BindView(R.id.text) TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @SuppressLint("SetTextI18n")
    @OnClick(R.id.login)
    public void onLoginClicked(){
        String name = editText.getText().toString();
        if(!name.isEmpty()) {
            closeKeyboard(editText);

            //hide views
            loginContainer.setVisibility(View.GONE);
            textContainer.setVisibility(View.VISIBLE);

            //display
            text.setText("Hello " + name);
        }
    }

    private void closeKeyboard(View view){
        //close keyboard
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
