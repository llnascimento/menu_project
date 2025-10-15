package com.example.aula3009.ui.qms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.aula3009.R;
import com.example.aula3009.databinding.FragmentQmsBinding;

public class QmsFragment extends Fragment {

    private FragmentQmsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        QmsViewModel qmsViewModel =
                new ViewModelProvider(this).get(QmsViewModel.class);

        binding = FragmentQmsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Configurar dados dos integrantes
        configurarIntegrantes();

        return root;
    }

    private void configurarIntegrantes() {
        // Integrante 1
        binding.txtNome1.setText("Lucas Nascimento");
        binding.txtCargo1.setText("Desenvolvedor / Analista");
        binding.txtDescricao1.setText("Estudante de ADS");
        binding.imgIntegrante1.setImageResource(R.drawable.ic_person); // Descomente para usar foto rea
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}