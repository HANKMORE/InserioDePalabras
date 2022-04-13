package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.PasswordAuthentication;
public class MainActivity extends AppCompatActivity{
    // atributos - varibles
    private  TextView txtResultado,txtResultadodos;
    private EditText etpalabra;
    private Button btnProcesar,btnEjercutar;
    private String Palabra,Palabra2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        /*
            al configurar un boton para decirle que este pendiente al evento click
            de ese boton en pantalla con el uso del metodo
            .setOnCliclListener()
            lo que este metodo esta esperando como parametro es una funcion
            que sera la funcion click que activara las acciones al realizar cuando se
            presione el boton.
            cuando se pasa una funcion como parametro estas generamente
            son cocnocidad como funciones anonimas
            la idea es que esta funcion ejecute su procedimiento a partir
            del metodo que la recibe como parametro.
        */
        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // este metodo onclicl solo existe en el embito del
                // boton btn processar, lo que se realize aca solo servira para este boton
                recibirInformacion();
                invertirPalabra();
            }
        });
        btnEjercutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recibirinfo();
                invertir();
            }
        });
    }
    private void invertir() {
        //la idea es que traten la cadena como un array
        //donde cada letra esta en una pocision del array partiendo desde 0
        //para tal efecto los string tienen un metodo que les pemrite
        //devolver un caracter de una pocisiom como si fuera un array
        //metodo se llama charAt(indice)
        String invertido="";
        for(int i =Palabra2.length()-1;i>=0;i--)
        {
            invertido = invertido + Palabra2.charAt(i);
        }
        txtResultadodos.setText(invertido);
    }
    private void recibirinfo() {
        Palabra2 = etpalabra.getText().toString();
    }
    private void invertirPalabra() {
        //manera directa de invertir una cadena
        //netamente codigo java
        Palabra=new StringBuilder(Palabra).reverse().toString();
        txtResultado.setText(Palabra);

    }

    private void recibirInformacion() {
        Palabra = etpalabra.getText().toString();

    }
    private void inicializarVistas() {
        txtResultado=findViewById(R.id.TXTresultado);
        etpalabra=findViewById(R.id.ETpalabra);
        btnProcesar=findViewById(R.id.BTNprocesar);
        btnEjercutar=findViewById(R.id.BTNinvertirdos);
        txtResultadodos=findViewById(R.id.TXTtextodos);
    }
}