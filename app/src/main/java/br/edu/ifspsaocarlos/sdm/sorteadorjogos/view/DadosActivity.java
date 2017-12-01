package br.edu.ifspsaocarlos.sdm.sorteadorjogos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifspsaocarlos.sdm.sorteadorjogos.R;
import br.edu.ifspsaocarlos.sdm.sorteadorjogos.model.Dado;

public class DadosActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJogar;
    private int qtdeDados;
    private int getQtdeFaces;
    private TextView tvResultado;
    private TextView tvDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        qtdeDados = getIntent().getIntExtra(DadosConfiguracaoActivity.QTDE_DADOS, 0);
        getQtdeFaces = getIntent().getIntExtra(DadosConfiguracaoActivity.QTDE_FACES, 0);

        tvResultado = (TextView) findViewById(R.id.tv_resultado);
        tvDados = (TextView) findViewById(R.id.tv_dados);
        btnJogar = (Button) findViewById(R.id.btn_jogar);
        btnJogar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btnJogar) {
            int resultadoGeral = 0;
            int resultado = 0;
            Dado dado = new Dado(getQtdeFaces);
            StringBuilder sbTexto = new StringBuilder("Sorteio(s): ");
            for (int i = 1; i <= qtdeDados; i++) {
                resultado = dado.jogar();
                resultadoGeral += resultado;

                if (i < qtdeDados)
                    sbTexto.append(resultado + " - ");
                else
                    sbTexto.append(resultado);
            }

            tvResultado.setText("Total: " + resultadoGeral);
            tvDados.setText(sbTexto.toString());
        }
    }
}
