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
    private LinearLayout llResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        qtdeDados = getIntent().getIntExtra(DadosConfiguracaoActivity.QTDE_DADOS, 0);
        getQtdeFaces = getIntent().getIntExtra(DadosConfiguracaoActivity.QTDE_FACES, 0);

        tvResultado = (TextView) findViewById(R.id.tv_resultado);
        llResultado = (LinearLayout) findViewById(R.id.ll_resultado);
        btnJogar = (Button) findViewById(R.id.btn_jogar);
        btnJogar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btnJogar) {
            llResultado.removeAllViews();
            int resultadoGeral = 0;
            int resultado = 0;
            Dado dado = new Dado(getQtdeFaces);
            TextView tvDado;
            for (int i = 1; i <= qtdeDados; i++) {
                resultado = dado.jogar();
                resultadoGeral += resultado;

                tvDado = new TextView(this);
                tvDado.setTextSize(30);
                tvDado.layout(20,20,20,20);
                if(i<qtdeDados)
                    tvDado.setText(resultado + " + ");
                else
                    tvDado.setText(String.valueOf(resultado));
                llResultado.addView(tvDado);
            }

            tvResultado.setText("Valor total do sorteio: " + resultadoGeral);
        }
    }
}
