package com.example.t5_a4_banuelosdelatorresantiagodominik;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioButton decimal, binario, octal, hexadecimal;
    TextView cajaNum, cajaBinario, cajaOctal, cajaHexadecimal;
    CheckBox checkBinario, checkOctal, checkHexadecimal;
    RadioGroup grupo;
    public Conversor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        decimal = findViewById(R.id.radioDecimal);
        binario = findViewById(R.id.radioBinario);
        octal = findViewById(R.id.radioOctal);
        hexadecimal = findViewById(R.id.radioHexadecimal);

        cajaNum = findViewById(R.id.cajaNum);
        cajaBinario = findViewById(R.id.cajaBinario);
        cajaOctal = findViewById(R.id.cajaOctal);
        cajaHexadecimal = findViewById(R.id.cajaHexadecimal);

        checkBinario = findViewById(R.id.checkBinario);
        checkOctal = findViewById(R.id.checkOctal);
        checkHexadecimal = findViewById(R.id.checkHexadecimal);
        grupo = findViewById(R.id.groupOpciones);
        //Log.i("CONVERSOR", "dale");
        c = new Conversor();
        //c.aDecimal("3A");
        //c.convertirDecimal(8);
    }
    public void dale(View v){
        //Log.i("CONVERSOR", "dale");
        c.base = 16;
        c.num = c.aDecimal("3A");
        c.convertirDecimal(8);
    }
    public void establecerBase(View v){
        if(decimal.isChecked()) c.base = 10;
        if(octal.isChecked()) c.base = 8;
        if(hexadecimal.isChecked()) c.base = 16;
        if(binario.isChecked()) c.base = 2;
    }
    void establecerTexto(TextView t, String s){
        t.setText(s);
    }
    public void Convertir(View v){
        String num = cajaNum.getText().toString();
        byte baseAnterior = c.base;
        c.num = c.aDecimal(num);

        if(checkHexadecimal.isChecked()) {
            c.base = 16;
            establecerTexto(cajaHexadecimal, c.convertirDecimal(c.base));
        }
        if(checkOctal.isChecked()){
            c.base = 8;
            establecerTexto(cajaOctal, c.convertirDecimal(c.base));
        }
        if(checkBinario.isChecked()){
            c.base = 2;
            establecerTexto(cajaBinario, c.convertirDecimal(c.base));
        }//else Toast.makeText(this, "Opcion desconocida", Toast.LENGTH_SHORT).show();

        c.base = baseAnterior;
    }
}