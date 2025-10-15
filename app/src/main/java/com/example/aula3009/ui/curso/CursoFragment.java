package com.example.aula3009.ui.curso;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.aula3009.databinding.FragmentCursoBinding;

public class CursoFragment extends Fragment {

    private FragmentCursoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CursoViewModel cursoViewModel =
                new ViewModelProvider(this).get(CursoViewModel.class);

        binding = FragmentCursoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCurso;
        cursoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}