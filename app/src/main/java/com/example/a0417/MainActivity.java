package com.example.a0417;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        final String[] items = {"美味蟹堡", "義式香腿堡", "蔬菜水果堡", "香蕉潛艇堡", "香烤雞肉堡"};
        final boolean[] checkedItems = {false, false, false, false, false}; // 初始狀態，所有項目都未選擇

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("歡迎光臨蟹堡王");
        alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedItems[which] = isChecked;
            }
        });

        alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder message = new StringBuilder("您選擇的餐點有：");
                for (int i = 0; i < items.length; i++) {
                    if (checkedItems[i]) {
                        message.append(items[i]).append(", ");
                    }
                }
                if (message.length() > 9) {
                    message.delete(message.length() - 2, message.length()); // 刪除最後多餘的逗號和空格
                } else {
                    message.append("無");
                }
                Toast.makeText(getApplicationContext(), message.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setNegativeButton("取消", null);

        alertDialog.setCancelable(false);
        alertDialog.show();
    }
}
