package com.example.encryptiondecryption_ownlibraray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.encryptionlibrary.EncryptionDecryption;
import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {
    String encrypted,decrypted;
    Button button1, button2;
    TextView textView;
    EditText ET_value, ET_key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.encrypt);
        button2 = findViewById(R.id.decrypt);
        textView = findViewById(R.id.DecryptedData);
        ET_value = findViewById(R.id.value);
        //String value = ET_value.getText().toString();
        ET_key = findViewById(R.id.key);
        //String key = ET_key.getText().toString();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    encrypted = EncryptionDecryption.Encryption(ET_value.getText().toString(), ET_key.getText().toString());
                    textView.setText(String.format("You Encrypted Message is : \n %s", encrypted));
                    ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("lable", encrypted);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(MainActivity.this, "Your Message is Copied to clipboard", Toast.LENGTH_SHORT).show();
                    ET_value.setText("");
                    ET_key.setText("");
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    decrypted = EncryptionDecryption.Decryption(ET_value.getText().toString(), ET_key.getText().toString());
                    textView.setText(String.format("You Decrypted Message is : \n %s", decrypted));
                    ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("lable", decrypted);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(MainActivity.this, "Your Message is Copied to clipboard", Toast.LENGTH_SHORT).show();
                    ET_value.setText("");
                    ET_key.setText("");
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}