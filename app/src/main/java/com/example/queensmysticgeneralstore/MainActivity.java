package com.example.queensmysticgeneralstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Editable copyText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setText("Hello Queens");

        final EditText editTextHello = (EditText) findViewById(R.id.editTextHello);
        editTextHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if(i == EditorInfo.IME_ACTION_DONE) {
                    //copy text in Editor text
                    copyText = editTextHello.getText();
                    tvHello.setText(copyText);

                    return true;
                }
                return false;
            }
        });

        Button btnCopy = (Button) findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //copy number to Hello Queen
                copyText = editTextHello.getText();
                tvHello.setText(copyText);

                Toast.makeText(MainActivity.this,
                        "" + copyText, Toast.LENGTH_LONG).show();
                //Call new 2nd activity with COPY button
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                intent.putExtra("result", String.valueOf(copyText));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate menu .xml
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_settings){
            //Do anything
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
