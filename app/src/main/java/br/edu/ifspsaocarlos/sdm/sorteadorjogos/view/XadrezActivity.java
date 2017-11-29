package br.edu.ifspsaocarlos.sdm.sorteadorjogos.view;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import br.edu.ifspsaocarlos.sdm.sorteadorjogos.R;

public class XadrezActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJogador1;
    private Button btnJogador2;
    private Chronometer chJogador1;
    private Chronometer chJogador2;

    private long tempoJogador1;
    private long tempoJogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xadrez);

        btnJogador1 = (Button) findViewById(R.id.btn_jogador_1);
        btnJogador1.setOnClickListener(this);
        btnJogador2 = (Button) findViewById(R.id.btn_jogador_2);
        btnJogador2.setOnClickListener(this);

        chJogador1 = (Chronometer) findViewById(R.id.ch_jogador_1);
        chJogador2 = (Chronometer) findViewById(R.id.ch_jogador_2);

        tempoJogador1 = 0;
        tempoJogador2 = 0;
    }

    @Override
    public void onClick(View view) {
        if (view == btnJogador1) {
            tempoJogador2 = chJogador2.getBase() - SystemClock.elapsedRealtime();
            chJogador2.stop();
            chJogador1.setBase(SystemClock.elapsedRealtime() + tempoJogador1);
            chJogador1.start();
        } else if (view == btnJogador2) {
            tempoJogador1 = chJogador1.getBase() - SystemClock.elapsedRealtime();
            chJogador1.stop();
            chJogador2.setBase(SystemClock.elapsedRealtime() + tempoJogador2);
            chJogador2.start();
        }
    }
}