package edu.tecii.android.final_proyect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Opcion1:
                Toast.makeText(MainActivity.this, "Acceso a Principal.", Toast.LENGTH_LONG).show();
                setContentView(R.layout.activity_main);
                return true;
            case R.id.Opcion2:
                Toast.makeText(MainActivity.this, "Acceso a Catalogo.", Toast.LENGTH_LONG).show();
                setContentView(R.layout.catalogo);
                GridView gridview = (GridView) findViewById(R.id.grid);
                gridview.setAdapter(new Adaptador_de_uniformes(this));

                return true;
            case R.id.Opcion3:
                Toast.makeText(MainActivity.this, "Acceso a Google Maps", Toast.LENGTH_LONG).show();
                setContentView(R.layout.mapa);
                WebView mapa = (WebView) this.findViewById(R.id.webView);
                mapa.loadUrl("https://www.google.com.mx/maps/place/Av+20+de+Noviembre+3908,+Barrio+" +
                        "de+Londres,+31060+Chihuahua,+Chih./@28.6429627,-106.061098,17z/data=!3m1!4" +
                        "b1!4m5!3m4!1s0x86ea44a8d9f9a731:0xa68c1c6266ec6b32!8m2!3d28.642958!4d-106.0589093?hl=es");
                return true;
            case R.id.Opcion4:
                Toast.makeText(MainActivity.this, "Acceso a Inventario.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),Inventario.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}