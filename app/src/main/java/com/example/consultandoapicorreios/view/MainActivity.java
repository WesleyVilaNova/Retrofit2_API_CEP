package com.example.consultandoapicorreios.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.consultandoapicorreios.R;
import com.example.consultandoapicorreios.models.ModelConsult;
import com.example.consultandoapicorreios.repository.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnBuscarCep;
    private TextView resposta;
    private EditText cep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciandoComponentes();
        chamandoRetrofit();

    }
    private void iniciandoComponentes() {
        btnBuscarCep = findViewById(R.id.btnConsultar);
        cep = findViewById(R.id.editTextPesquisar);
        resposta = findViewById(R.id.textResultado);
    }

    private void chamandoRetrofit() {
            btnBuscarCep.setOnClickListener(v -> {
                Call<ModelConsult> call = new RetrofitConfig()
                        .getCEPService()
                        .buscarCEP(cep.getText().toString());

                call.enqueue(new Callback<ModelConsult>() {
                    @Override
                    public void onResponse(Call<ModelConsult> call, Response<ModelConsult> response) {
                        if (response.isSuccessful()) {
                            ModelConsult respostaBody = response.body();
                            resposta.setText(respostaBody.toString());
                        }
                    }
                    @Override
                    public void onFailure(Call<ModelConsult> call, Throwable t) {
                        Log.e("WebService   ", "ERRO AO BUSCAR CEP:" + t.getMessage());
                    }
                });
            });
        }
}