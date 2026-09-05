package com.leo.adrian;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ImageView sceneImage;
    private TextView story;
    private Button actionButton;
    private Button noButton;
    private int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sceneImage = findViewById(R.id.sceneImage);
        story = findViewById(R.id.story);
        actionButton = findViewById(R.id.yes);
        noButton = findViewById(R.id.no);

        actionButton.setOnClickListener(v -> next());
        noButton.setOnClickListener(v -> finishGame());

        showStep();
    }

    private void next() {
        if (step == 6) {
            step = 0;
            actionButton.setVisibility(View.VISIBLE);
            noButton.setVisibility(View.VISIBLE);
            actionButton.setText("❤️ COMENZAR");
            noButton.setText("❌ SALIR");
        } else {
            step++;
        }
        showStep();
    }

    private void showStep() {
        switch (step) {
            case 0:
                sceneImage.setImageResource(R.drawable.scene_title);
                story.setText("Leo llega de la escuela cuando recibe un mensaje de Adrián.\n\n📱 Adrián: “¿Un FF? 🎮🔥”");
                actionButton.setText("❤️ SÍ");
                noButton.setText("❌ NO");
                break;

            case 1:
                sceneImage.setImageResource(R.drawable.scene_game);
                story.setText("Leo acepta y comienza la partida.\n\n🎮 ¡Los dos entran a la partida!");
                actionButton.setText("CONTINUAR");
                noButton.setVisibility(View.GONE);
                break;

            case 2:
                sceneImage.setImageResource(R.drawable.scene_adrian_down);
                story.setText("💥 ¡Adrián ha sido tumbado!\n\nAdrián: “¡Leo, ayúdame!”");
                break;

            case 3:
                sceneImage.setImageResource(R.drawable.scene_leo_down);
                story.setText("💥 ¡Leo también fue tumbado!\n\nLeo: “¡Adrián…!”");
                break;

            case 4:
                sceneImage.setImageResource(R.drawable.scene_meet);
                story.setText("🌆 Después de la partida, se encuentran en persona.\n\nSe miran a los ojos, nerviosos...");
                break;

            case 5:
                sceneImage.setImageResource(R.drawable.scene_meet);
                story.setText("❤️ Leo y Adrián, al mismo tiempo:\n\n“Me... gustas.”");
                break;

            case 6:
                sceneImage.setImageResource(R.drawable.scene_kiss);
                story.setText("❤️ Se acercan tímidamente y se dan un pequeño beso.\n\n✨ FIN DEL JUEGO ✨");
                actionButton.setVisibility(View.VISIBLE);
                noButton.setVisibility(View.VISIBLE);
                actionButton.setText("🔄 JUGAR DE NUEVO");
                noButton.setText("🚪 SALIR");
                break;
        }
    }

    private void finishGame() {
        sceneImage.setImageResource(R.drawable.scene_title);
        story.setText("👋 Gracias por jugar.\n\nPuedes cerrar la app o volver a comenzar.");
        actionButton.setVisibility(View.VISIBLE);
        noButton.setVisibility(View.VISIBLE);
        actionButton.setText("🔄 JUGAR DE NUEVO");
        noButton.setText("🚪 SALIR");
        step = 6;
    }
}
