package com.example.lab6_navigation.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lab6_navigation.R;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.Navigation;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
//        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);



        Button button = getView().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.mainToSecond);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userText = getView().findViewById(R.id.userText);
                String data = userText.getText().toString();

                MainFragmentDirections.MainToSecond action =
                        MainFragmentDirections.mainToSecond();

                action.setMessage(data);
                Navigation.findNavController(view).navigate(action);
            }
        });
        // TODO: Use the ViewModel
    }

}