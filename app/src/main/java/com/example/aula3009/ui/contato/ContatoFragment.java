package com.example.aula3009.ui.contato;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.aula3009.databinding.FragmentContatoBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ContatoFragment extends Fragment {

    private FragmentContatoBinding binding;
    private TextInputEditText etNome;
    private TextInputEditText etEmail;
    private TextInputEditText etAssunto;
    private TextInputEditText etMensagem;
    private MaterialButton btnEnviar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContatoViewModel contatoViewModel =
                new ViewModelProvider(this).get(ContatoViewModel.class);

        binding = FragmentContatoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Inicializar views
        etNome = binding.etNome;
        etEmail = binding.etEmail;
        etAssunto = binding.etAssunto;
        etMensagem = binding.etMensagem;
        btnEnviar = binding.btnEnviar;

        // Configurar botão
        btnEnviar.setOnClickListener(v -> validarEEnviar());

        return root;
    }

    private void validarEEnviar() {
        String nome = etNome.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String assunto = etAssunto.getText().toString().trim();
        String mensagem = etMensagem.getText().toString().trim();

        // Validações
        if (nome.isEmpty()) {
            etNome.setError("Por favor, insira seu nome");
            etNome.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Por favor, insira seu e-mail");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Por favor, insira um e-mail válido");
            etEmail.requestFocus();
            return;
        }

        if (assunto.isEmpty()) {
            etAssunto.setError("Por favor, insira o assunto");
            etAssunto.requestFocus();
            return;
        }

        if (mensagem.isEmpty()) {
            etMensagem.setError("Por favor, insira sua mensagem");
            etMensagem.requestFocus();
            return;
        }

        // Enviar dados
        enviarFormulario(nome, email, assunto, mensagem);
    }

    private void enviarFormulario(String nome, String email, String assunto, String mensagem) {
        // Desabilitar botão durante envio
        btnEnviar.setEnabled(false);
        btnEnviar.setText("Enviando...");

        // Aqui você pode implementar o envio real dos dados
        // Por exemplo: chamada a uma API, envio por e-mail, etc.

        // Simulação de envio
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (getContext() != null) {
                Toast.makeText(
                        getContext(),
                        "Mensagem enviada com sucesso!",
                        Toast.LENGTH_LONG
                ).show();

                // Limpar campos
                limparCampos();

                // Reabilitar botão
                btnEnviar.setEnabled(true);
                btnEnviar.setText("Enviar Mensagem");
            }
        }, 1500);
    }

    private void limparCampos() {
        if (etNome.getText() != null) etNome.getText().clear();
        if (etEmail.getText() != null) etEmail.getText().clear();
        if (etAssunto.getText() != null) etAssunto.getText().clear();
        if (etMensagem.getText() != null) etMensagem.getText().clear();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}