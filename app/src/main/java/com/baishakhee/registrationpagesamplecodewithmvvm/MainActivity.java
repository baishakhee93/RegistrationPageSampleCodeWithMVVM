package com.baishakhee.registrationpagesamplecodewithmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baishakhee.registrationpagesamplecodewithmvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setViewModel(new MainViewModel());
        binding.executePendingBindings();
    }

    @BindingAdapter({ "toastMessage" })
    public static void runMe(View view, String message)
    {
        if (message != null)
            Toast.makeText(view.getContext(), message,
                            Toast.LENGTH_SHORT).show();


    }
    @Override
    protected void onPause() {
        super.onPause();
        finish(); //only call if you want to clear this activity after go to other activity
    }
}