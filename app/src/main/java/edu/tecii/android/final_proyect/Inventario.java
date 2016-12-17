package edu.tecii.android.final_proyect;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class Inventario extends AppCompatActivity {
    EditText edt1,edt2,edt3,edt4;
    Button btnAlta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        edt1 = (EditText) findViewById(R.id.et1);
        edt2 = (EditText) findViewById(R.id.et2);
        edt3 = (EditText) findViewById(R.id.et3);
        edt4 = (EditText) findViewById(R.id.et4);


    }



    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = edt1.getText().toString();
        String nom = edt4.getText().toString();
        String descri = edt2.getText().toString();
        String pre = edt3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("nombre", nom);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        bd.insert("articulos", null, registro);
        bd.close();
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
        Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();
    }

    public void consultaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = edt1.getText().toString();
        Cursor fila = bd.rawQuery(
                "select nombre, descripcion, precio from articulos where codigo= " + cod, null);
        if (fila.moveToFirst()) {
            edt4.setText(fila.getString(0));
            edt2.setText(fila.getString(1));
            edt3.setText(fila.getString(2));
        } else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void consultapornombre(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nom = edt4.getText().toString();
        Cursor fila = bd.rawQuery(
                "select descripcion, codigo, precio from articulos where nombre= '" + nom+"'", null);
        if (fila.moveToFirst()) {
            edt2.setText(fila.getString(0));
            edt1.setText(fila.getString(1));
            edt3.setText(fila.getString(2));
        } else{
            Toast.makeText(this, "No existe un artículo con dicho nombre",
                    Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    public void bajaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= edt1.getText().toString();
        int cant = bd.delete("articulos", "codigo=" + cod, null);
        bd.close();
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró el artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = edt1.getText().toString();
        String nom = edt4.getText().toString();
        String descri = edt2.getText().toString();
        String pre = edt3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("nombre", nom);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        int cant = bd.update("articulos", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "no existe un artículo con el código ingresado",
                    Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Opcion1:
                Toast.makeText(Inventario.this, "Acceso a Principal.", Toast.LENGTH_LONG).show();
                setContentView(R.layout.activity_main);
                return true;
            case R.id.Opcion2:
                Toast.makeText(Inventario.this, "Acceso a Catalogo.", Toast.LENGTH_LONG).show();
                setContentView(R.layout.catalogo);
                GridView gridview = (GridView) findViewById(R.id.grid);
                gridview.setAdapter(new Adaptador_de_uniformes(this));

                return true;
            case R.id.Opcion3:
                Toast.makeText(Inventario.this, "Acceso a Google Maps", Toast.LENGTH_LONG).show();
                setContentView(R.layout.mapa);
                WebView mapa = (WebView) this.findViewById(R.id.webView);
                mapa.loadUrl("https://www.google.com.mx/maps/place/Av+20+de+Noviembre+3908,+Barrio+" +
                        "de+Londres,+31060+Chihuahua,+Chih./@28.6429627,-106.061098,17z/data=!3m1!4" +
                        "b1!4m5!3m4!1s0x86ea44a8d9f9a731:0xa68c1c6266ec6b32!8m2!3d28.642958!4d-106.0589093?hl=es");
                return true;
            case R.id.Opcion4:
                Toast.makeText(Inventario.this, "Acceso a Inventario.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),Inventario.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
