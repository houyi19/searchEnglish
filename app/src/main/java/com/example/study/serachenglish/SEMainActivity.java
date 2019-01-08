package com.example.study.serachenglish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SEMainActivity extends AppCompatActivity {

    private ArrayList<String> mModels;
    private EditText mEdit;
    private Button mSubmitBtn;
    private TextView mResult,mResult1,mResult2,mResult3,mResult4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semain);
        mModels = new ArrayList<>();
        duquTxt(mModels);
        mEdit = findViewById(R.id.act_txt);
        mSubmitBtn = findViewById(R.id.act_submit);
        mResult = findViewById(R.id.act_result);
        mResult2 = findViewById(R.id.act_result2);
        mResult3 = findViewById(R.id.act_result3);
        mResult4 = findViewById(R.id.act_result4);
        mResult1 = findViewById(R.id.act_result1);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mEdit.getText().toString();
                if (s.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "查询的单词请勿为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                getResultWord(s);
            }
        });
    }

    private void getResultWord(String s) {
        String resstr = "";
        TextView[] mRes = {mResult,mResult1,mResult2,mResult3,mResult4};
        int count = 0;
        for (int i = 0; i < mModels.size(); i++) {
            String s1 = mModels.get(i);
            if (s1.isEmpty()) {
                Log.i("test2",s1);
            }
            double res = getStringDistance(s,s1);
            if (res < 3.0) {
                mRes[count].setVisibility(View.VISIBLE);
                mRes[count].setText(s1);
                if (count == 4) {
                    break;
                }
                count++;
            }
        }
    }

    private void duquTxt(ArrayList<String> models) {
        try {
            InputStreamReader fileReader = new InputStreamReader(getResources().openRawResource(R.raw.words));
            BufferedReader br = new BufferedReader(fileReader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                models.add(line);
                line = br.readLine(); // 一次读入一行数据
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getStringDistance(String s1, String s2) {

        double distance[][];// 定义距离表
        int s1_len = s1.length();
        int s2_len = s2.length();

        if (s1_len == 0) {
            return s2_len;
        }
        if (s2_len == 0) {
            return s1_len;
        }
        distance = new double[s1_len + 1][s2_len + 1];

        // 二维数组第一行和第一列放置自然数
        for (int i = 0; i <= s1_len; i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= s2_len; j++) {
            distance[0][j] = j;
        }
        // 比较，若行列相同，则代价为0，否则代价为1；
        for (int i = 1; i <= s1_len; i++) {
            char s1_i = s1.charAt(i - 1);
            // 逐一比较
            for (int j = 1; j <= s2_len; j++) {
                char s2_j = s2.charAt(j - 1);
                // 若相等，则代价取0；直接取左上方值
                if (s1_i == s2_j) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    // 否则代价取1，取左上角、左、上 最小值 + 代价（代价之和便是最终距离）
                    distance[i][j] = getMin(distance[i - 1][j], distance[i][j - 1], distance[i - 1][j - 1]) + 1;
                }
            }
        }
        // 取二位数组最后一位便是两个字符串之间的距离
        return distance[s1_len][s2_len];
    }

    // 求最小值
    private double getMin(double a, double b, double c) {
        double min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }
}
