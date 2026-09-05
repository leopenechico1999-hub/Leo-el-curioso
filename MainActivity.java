package com.leo.adrian.nuevo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    ImageView image; TextView story; Button next, restart; int step=0;
    int[] imgs = {R.drawable.scene1,R.drawable.scene2,R.drawable.scene3,R.drawable.scene4,R.drawable.scene5,R.drawable.scene6,R.drawable.scene7};
    String[] texts = {
      "Leo llega a casa cansado. Al entrar, lo primero que ve es a Adrián.",
      "Leo se queda mirando su celular y piensa en Adrián. Después le manda un mensaje.",
      "Leo: ¿Jugamos Free Fire?\nAdrián: Sí, vamos.",
      "Empieza la partida. Leo juega bastante mal... y Adrián está INSANO.",
      "Leo cae en combate. Adrián corre para revivirlo.\nLeo: Gracias, amor.\nAdrián se sonroja.",
      "Al día siguiente vuelven a encontrarse. La historia da un salto de tiempo y la escena queda en tono romántico, sin mostrar contenido íntimo.",
      "Leo: ¡¡¡AHHHHH!!!\n\nFIN 😂\n\nATENTAMENTE: ATÚN"
    };
    @Override public void onCreate(Bundle b){super.onCreate(b); setContentView(R.layout.activity_main);
      image=findViewById(R.id.sceneImage); story=findViewById(R.id.story); next=findViewById(R.id.next); restart=findViewById(R.id.restart);
      show();
      next.setOnClickListener(v->{ if(step<texts.length-1){step++;show();} else {next.setVisibility(View.GONE);restart.setVisibility(View.VISIBLE);} });
      restart.setOnClickListener(v->{step=0;restart.setVisibility(View.GONE);next.setVisibility(View.VISIBLE);show();});
    }
    void show(){ image.setImageResource(imgs[step]); story.setText(texts[step]); }
}
