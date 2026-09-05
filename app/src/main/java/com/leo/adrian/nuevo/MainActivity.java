package com.leo.adrian.nuevo;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout pantalla;
    TextView historia;
    Button siguiente;
    int escena = 0;

    String[] textos = {
        "🎮 LEO Y ADRIÁN\n\nLeo llega a casa cansado y se encuentra con Adrián.",
        "📱 Leo se queda pensando en Adrián mientras mira su celular.",
        "🔥 Leo: ¿Jugamos Free Fire?",
        "😎 Adrián: ¡Sí!\n\nAdrián resulta ser insano en Free Fire, mientras Leo es bastante manco 😂.",
        "💥 ¡LEO FUE DERRIBADO!\n\nAdrián corre para revivirlo.",
        "❤️ Leo: Gracias, amor.\n\nAdrián se sonroja. 😳",
        "🏠 Al día siguiente, Leo visita a Adrián.\n\nPasan el día juntos y su amistad se vuelve todavía más especial.",
        "😂 FIN\n\nLEO ES GEY\n\nAtentamente: ATÚN",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mostrarEscena();
    }

    void mostrarEscena() {

        pantalla = new LinearLayout(this);
        pantalla.setOrientation(LinearLayout.VERTICAL);
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
