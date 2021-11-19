package top.icespite.fridahooker.config;

import android.content.Context;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import top.icespite.fridahooker.agent.FridaAgent;

public class InitConfig {
    String params = "";
    String version = "";
    private static InitConfig initConfig = new InitConfig();

    private InitConfig() {
    }

    public static InitConfig getInitConfig() {
        return initConfig;
    }

    public void getFromFile(FileInputStream fin) {
        try {
            int lenght = fin.available();
            if (lenght == 0) {
                return;
            } else {
                byte[] buffer = new byte[lenght];
                fin.read(buffer);
                String config = new String(buffer, StandardCharsets.UTF_8);
                Gson gson = new Gson();
                initConfig = gson.fromJson(config, InitConfig.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(FileOutputStream fout) {
        try {
            Gson gson = new Gson();
            byte[] bytes = gson.toJson(initConfig).getBytes();
            fout.write(bytes);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
