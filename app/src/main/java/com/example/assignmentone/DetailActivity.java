package com.example.assignmentone;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 使用首页传来的编号，选择各数组中相同位置的数据。
        int topicIndex = getIntent().getIntExtra(
                MainActivity.EXTRA_TOPIC_INDEX, 0);

        Resources resources = getResources();

        String[] imageNames = resources.getStringArray(
                R.array.string_array_images);
        String[] titles = resources.getStringArray(
                R.array.string_array_titles);
        String[] contents = resources.getStringArray(
                R.array.string_array_content);

        // 横幅分类名称复用已有文字资源，顺序与内容数组一致。
        int[] categoryLabelIds = {
                R.string.label_facilities,
                R.string.label_events,
                R.string.label_clubs,
                R.string.label_support
        };

        String categoryLabel = getString(categoryLabelIds[topicIndex]);

        ImageView imageView = findViewById(R.id.detail_image);
        TextView categoryView = findViewById(R.id.detail_category);
        TextView titleView = findViewById(R.id.detail_title);
        TextView contentView = findViewById(R.id.detail_content);

        // 数组存储的是图片名称，清理空格后取得对应 drawable。
        int imageId = resources.getIdentifier(
                imageNames[topicIndex].trim(),
                "drawable",
                getPackageName()
        );

        imageView.setImageResource(imageId);
        imageView.setContentDescription(categoryLabel);
        categoryView.setText(categoryLabel);
        titleView.setText(titles[topicIndex].trim());
        contentView.setText(contents[topicIndex]);
    }
}