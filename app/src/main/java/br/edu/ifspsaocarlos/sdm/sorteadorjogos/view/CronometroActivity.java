package br.edu.ifspsaocarlos.sdm.sorteadorjogos.view;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import br.edu.ifspsaocarlos.sdm.sorteadorjogos.R;

public class CronometroActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btIniciarContagem;
    private Button btPararContagem;
    private RadioGroup rgTipo;
    private NumberPicker npHora;
    private NumberPicker npMinuto;
    private NumberPicker npSegundo;
    private TextView tvTempo;
    private CountDownTimer timer;
    private long tempoInicial = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        btIniciarContagem = (Button) findViewById(R.id.bt_iniciar_contagem);
        btIniciarContagem.setOnClickListener(this);
        btPararContagem = (Button) findViewById(R.id.bt_parar_contagem);
        btPararContagem.setOnClickListener(this);
        btPararContagem.setEnabled(false);
        rgTipo = (RadioGroup) findViewById(R.id.rg_tipo);
        npHora = (NumberPicker) findViewById(R.id.np_hora);
        npMinuto = (NumberPicker) findViewById(R.id.np_minuto);
        npSegundo = (NumberPicker) findViewById(R.id.np_segundo);
        tvTempo = (TextView) findViewById(R.id.tv_tempo);

        npHora.setMinValue(0);
        npHora.setMaxValue(23);
        npMinuto.setMinValue(0);
        npMinuto.setMaxValue(59);
        npSegundo.setMinValue(0);
        npSegundo.setMaxValue(59);
    }

    private void atualizarTempo(long tempo) {
        tvTempo.setText(String.format("%02d:%02d:%02d:%03d", TimeUnit.MILLISECONDS.toHours(tempo),
                TimeUnit.MILLISECONDS.toMinutes(tempo) % 60,
                TimeUnit.MILLISECONDS.toSeconds(tempo) % 60,
                TimeUnit.MILLISECONDS.toMillis(tempo) % 1000));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_iniciar_contagem:

                int hora = npHora.getValue();
                int minuto = npMinuto.getValue();
                int segundo = npSegundo.getValue();

                long tempoEmMilis = segundo * 1000;
                tempoEmMilis += minuto * 60 * 1000;
                tempoEmMilis += hora * 60 * 60 * 1000;

                int selecaoContagem = rgTipo.getCheckedRadioButtonId();

                if (tempoEmMilis == 0 || selecaoContagem == -1) {
                    Toast.makeText(this, "Por favor, selecione o tempo e a forma de contagem", Toast.LENGTH_SHORT).show();
                } else {
                    btPararContagem.setEnabled(true);
                    btIniciarContagem.setEnabled(false);
                    switch (selecaoContagem) {
                        case R.id.rb_cronometro:
                            tempoInicial = new Date().getTime();
                            timer = new CountDownTimer(tempoEmMilis, 1) {
                                public void onTick(long millisUntilFinished) {
                                    atualizarTempo(new Date().getTime() - tempoInicial);
                                }

                                public void onFinish() {
                                    tvTempo.setText("Fim!!!");
                                    btPararContagem.setEnabled(false);
                                    btIniciarContagem.setEnabled(true);
                                }
                            };
                            timer.start();

                            break;
                        case R.id.rb_contagem_regressiva:
                            timer = new CountDownTimer(tempoEmMilis, 1) {
                                public void onTick(long millisUntilFinished) {
                                    atualizarTempo(millisUntilFinished);
                                }

                                public void onFinish() {
                                    tvTempo.setText("Fim!!!");
                                    btPararContagem.setEnabled(false);
                                    btIniciarContagem.setEnabled(true);
                                }
                            };
                            timer.start();
                            break;
                    }
                }
                break;
            case R.id.bt_parar_contagem:
                if (timer != null) {
                    timer.cancel();
                    btPararContagem.setEnabled(false);
                    btIniciarContagem.setEnabled(true);
                }
                break;
        }
    }
}