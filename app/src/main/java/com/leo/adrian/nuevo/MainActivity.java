package com.leo.adrian.nuevo;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    ImageView imagen;
    TextView historia;
    Button siguiente;
    Button reiniciar;

    int escena = 0;

    int[] imagenes = {
            R.drawable.scene1,
            R.drawable.scene2,
            R.drawable.scene3,
            R.drawable.scene4,
            R.drawable.scene5,
            R.drawable.scene6,
            R.drawable.scene7
    };

    String[] textos = {
            "LEO Y ADRIÁN\n\nLeo llega a casa y se encuentra con Adrián.",
            "Leo se queda pensando en lo que acaba de pasar.",
            "Adrián: ¿Jugamos un rato?",
            "Leo: ¡Sí! Vamos a jugar.",
            "Después de jugar, los dos se quedan hablando.",
            "Leo: Me alegra estar contigo, Adrián.",
            "FIN\n\nGracias por jugar ❤️"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        crearPantalla();
        mostrarEscena();
    }

    void crearPantalla() {

        LinearLayout pantalla = new LinearLayout(this);
        pantalla.setOrientation(LinearLayout.VERTICAL);
        pantalla.setGravity(Gravity.CENTER);
        pantalla.setPadding(20, 20, 20, 20);
        pantalla.setBackgroundColor(Color.BLACK);

        imagen = new ImageView(this);
        imagen.setAdjustViewBounds(true);
        imagen.setScaleType(ImageView.ScaleType.FIT_CENTER);

        pantalla.addView(imagen,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        5
                ));

        historia = new TextView(this);
        historia.setTextColor(Color.WHITE);
        historia.setTextSize(20);
        historia.setGravity(Gravity.CENTER);
        historia.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        historia.setPadding(10, 10, 10, 10);

        pantalla.addView(historia,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        2
                ));

        siguiente = new Button(this);
        siguiente.setText("SIGUIENTE");
        siguiente.setTextSize(18);

        pantalla.addView(siguiente,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));

        reiniciar = new Button(this);
        reiniciar.setText("JUGAR DE NUEVO");
        reiniciar.setTextSize(18);
        reiniciar.setVisibility(Button.GONE);

        pantalla.addView(reiniciar,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));

        siguiente.setOnClickListener(v -> {

            if (escena < textos.length - 1) {
                escena++;
                mostrarEscena();
            }
        });

        reiniciar.setOnClickListener(v -> {

            escena = 0;
            siguiente.setVisibility(Button.VISIBLE);
            reiniciar.setVisibility(Button.GONE);
            mostrarEscena();
        });

        setContentView(pantalla);
    }

    void mostrarEscena() {

        imagen.setImageResource(imagenes[escena]);
        historia.setText(textos[escena]);

        if (escena == textos.length - 1) {
            siguiente.setVisibility(Button.GONE);
            reiniciar.setVisibility(Button.VISIBLE);
        } else {
            siguiente.setVisibility(Button.VISIBLE);
            reiniciar.setVisibility(Button.GONE);
        }
    }
                    }        pantalla.setOrientation(LinearLayout.VERTICAL);
        pantalla.setGravity(Gravity.CENTER);
        pantalla.setPadding(30, 30, 30, 30);
        pantalla.setBackgroundColor(Color.BLACK);

        historia = new TextView(this);
        historia.setText(textos[escena]);
        historia.setTextColor(Color.WHITE);
        historia.setTextSize(24);
        historia.setGravity(Gravity.CENTER);
        historia.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        pantalla.addView(historia,
                new LinearLayout.LayoutParams(
                        -1, 0, 1));

        siguiente = new Button(this);

        if (escena == textos.length - 1) {
            siguiente.setText("🔄 JUGAR DE NUEVO");
        } else {
            siguiente.setText("➡️ SIGUIENTE");
        }

        siguiente.setTextSize(18);

        siguiente.setOnClickListener(v -> {

            if (escena == textos.length - 1) {
                escena = 0;
                mostrarEscena();
            } else {
                escena++;
                mostrarEscena();
            }
        });

        pantalla.addView(siguiente,
                new LinearLayout.LayoutParams(
                        -1, 80));

        setContentView(pantalla);
    }
}
