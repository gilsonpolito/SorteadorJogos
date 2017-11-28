package br.edu.ifspsaocarlos.sdm.sorteadorjogos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DadosActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJogar;
    private int qtdeDados;
    private int getQtdeFaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        qtdeDados = getIntent().getIntExtra(DadosConfiguracaoActivity.QTDE_DADOS, 0);
        getQtdeFaces = getIntent().getIntExtra(DadosConfiguracaoActivity.QTDE_FACES, 0);

        btnJogar = (Button) findViewById(R.id.btn_jogar);
        btnJogar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnJogar) {
            Toast.makeText(this, "dados: " + qtdeDados + " faces: " + getQtdeFaces, Toast.LENGTH_SHORT).show();
        }
    }
}
