package br.edu.ifspsaocarlos.sdm.sorteadorjogos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DadosConfiguracaoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOk;
    private EditText etQuantidadeDados;
    private EditText etQuantidadeFaces;

    public static String QTDE_DADOS = "QTDE_DADOS";
    public static String QTDE_FACES = "QTDE_FACES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_configuracao);

        etQuantidadeDados = (EditText) findViewById(R.id.et_qtdeDados);
        etQuantidadeFaces = (EditText) findViewById(R.id.et_qtdeFaces);
        btnOk = (Button) findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnOk) {
            Intent dadosIntent = new Intent(this, DadosActivity.class);
            int qtdeDados = Integer.parseInt(etQuantidadeDados.getText().toString());
            int qtdeFaces = Integer.parseInt(etQuantidadeFaces.getText().toString());
            dadosIntent.putExtra(QTDE_DADOS, qtdeDados);
            dadosIntent.putExtra(QTDE_FACES, qtdeFaces);
            startActivity(dadosIntent);
        }
    }
}
