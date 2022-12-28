package com.example.encryptionlibrary;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class EncryptionDecryption {
    public static String Encryption(String mesg, String key) throws GeneralSecurityException {
        String encrpyted = AESCrypt.encrypt(key, mesg);
        return encrpyted;
    }
    public static String Decryption( String mesg, String key) throws GeneralSecurityException {
        String decrypted = AESCrypt.decrypt(key,mesg);
        return decrypted;
    }
}
