package br.edu.ifspsaocarlos.sdm.sorteadorjogos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifspsaocarlos.sdm.sorteadorjogos.R;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDados;
    private Button btnXadrez;
    private Button btnCronometro;
    private Button btnRoleta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnDados = (Button) findViewById(R.id.btn_jogar_dados);
        btnXadrez = (Button) findViewById(R.id.btn_cronometro_xadrez);
        btnCronometro = (Button) findViewById(R.id.btn_marcador_tempo);
        btnRoleta = (Button) findViewById(R.id.btn_roleta);

        btnDados.setOnClickListener(this);
        btnXadrez.setOnClickListener(this);
        btnCronometro.setOnClickListener(this);
        btnRoleta.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent proximaTela;
        if(view == btnDados) {
            proximaTela = new Intent(this, DadosConfiguracaoActivity.class);
            startActivity(proximaTela);
        } else if (view == btnXadrez) {
            proximaTela = new Intent(this, XadrezActivity.class);
            startActivity(proximaTela);
        } else if (view == btnCronometro) {
            proximaTela = new Intent(this, DadosConfiguracaoActivity.class);
            startActivity(proximaTela);
        } else if (view == btnRoleta) {
            proximaTela = new Intent(this, DadosConfiguracaoActivity.class);
            startActivity(proximaTela);
        }
    }
}
