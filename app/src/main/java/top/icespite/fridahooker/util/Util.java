package top.icespite.fridahooker.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static String getPath(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
            return displayName;
        }
        return "error";
    }

    public static String getVersionFromFile(String filePath) {
        String extension = "";
        try {
            String pattern = "frida-server-(.*?)-";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(filePath);
            if (!m.find()) {
                return "error";
            }
            extension = m.group(1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return extension;
    }

    public static boolean checkFridaServerFile(String filePath,String abi){
        //TODO:check frida as same as the device struct
        try {
            String demo = " frida-server-15.1.11-android-arm.xz";
            String pattern = "frida-server-(.*?)-android-(.*?).xz";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(filePath);
            if (!m.find()) {
                return false;
            }
            String extension = m.group(1);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }
}
