package com.zybooks.projecttwohainguyenui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ClickedItemActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    EditText editText;
    Spinner textSizeSpinner;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.tvName);
        editText = findViewById(R.id.inputText);
        textSizeSpinner = findViewById(R.id.textSizeSpinner);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            String selectedName = intent.getStringExtra("name");
            int selectedImage = intent.getIntExtra("image", 0);

            textView.setText(selectedName);
            imageView.setImageResource(selectedImage);

            // Enhancement 1: User comments
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                    if (!hasFocus) {
                        String userComment = editText.getText().toString();
                        // Save comment (placeholder)
                    }
                }
            });

            // Enhancement 2: Fade-in animation
            imageView.setAlpha(0f);
            imageView.animate().alpha(1f).setDuration(1000);

            // Enhancement 3: Text size customization
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.text_size_options,
                android.R.layout.simple_spinner_item
            );

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            textSizeSpinner.setAdapter(adapter);

            textSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                    public void onItemSelected(AdapterView< ? > adapterView, View view, int position, long id) {
                    String selectedTextSize = adapterView.getItemAtPosition(position).toString();

                    switch (selectedTextSize) {
                    case "Small":
                        textView.setTextSize(14);
                        break;
                    case "Medium":
                        textView.setTextSize(18);
                        break;
                    case "Large":
                        textView.setTextSize(24);
                        break;
                    }
                }

                @Override
                    public void onNothingSelected(AdapterView< ? > adapterView) {}
            });
        }
    }
}
