package br.edu.ifspsaocarlos.sdm.sorteadorjogos.view;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import br.edu.ifspsaocarlos.sdm.sorteadorjogos.R;

public class CronometroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etTempo;
    private Button btIniciarContagem;
    private Button btPararContagem;
    private Chronometer chTempo;
    private RadioGroup rgTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        etTempo = (EditText) findViewById(R.id.et_tempo);
        btIniciarContagem = (Button) findViewById(R.id.bt_iniciar_contagem);
        btIniciarContagem.setOnClickListener(this);
        btPararContagem = (Button) findViewById(R.id.bt_parar_contagem);
        btPararContagem.setOnClickListener(this);
        chTempo = (Chronometer) findViewById(R.id.ch_tempo);
        //somente a partir da API 24
        //chTempo.setCountDown(true);

        rgTipo = (RadioGroup) findViewById(R.id.rg_tipo);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_iniciar_contagem:
                int idRadioButtonSelecionado = rgTipo.getCheckedRadioButtonId();
                switch (idRadioButtonSelecionado) {
                    case R.id.rb_cronometro:
                        chTempo.setBase(SystemClock.elapsedRealtime());
                        chTempo.start();
                        break;
                    case R.id.rb_contagem_regressiva:
                        break;
                }

                break;
            case R.id.bt_parar_contagem:
                chTempo.stop();
                break;
        }
    }
}
