package com.example.a0417;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
                StringBuilder selectedItems = new StringBuilder("您點的餐點有：");
                for (int i = 0; i < items.length; i++) {
                    if (checkedItems[i]) {
                        selectedItems.append(items[i]).append(", ");
                    }
                }
                if (selectedItems.length() > 9) {
                    selectedItems.delete(selectedItems.length() - 2, selectedItems.length()); // 刪除最後多餘的逗號和空格
                } else {
                    selectedItems.append("無");
                }
                TextView selectedItemsTextView = findViewById(R.id.textView2); // 找到用於顯示所選餐點的 TextView
                selectedItemsTextView.setText(selectedItems.toString()); // 更新 TextView 的文本內容
            }
        });

        alertDialog.setNegativeButton("取消", null);

        alertDialog.setCancelable(false);
        alertDialog.show();
    }
}
