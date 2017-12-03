package br.edu.ifspsaocarlos.sdm.sorteadorjogos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.sorteadorjogos.R;
import br.edu.ifspsaocarlos.sdm.sorteadorjogos.model.Dado;

public class RoletaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btJogar;
    private TextView tvResultado;
    private Dado dado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roleta);

        btJogar = (Button) findViewById(R.id.bt_jogar);
        btJogar.setOnClickListener(this);
        tvResultado = (TextView) findViewById(R.id.tv_resultado);

        //roleta vai até o número 36
        dado = new Dado(36);
    }

    @Override
    public void onClick(View view) {
        if (view == btJogar)
            tvResultado.setText("Resultado da roleta: " + dado.jogar());
    }
}