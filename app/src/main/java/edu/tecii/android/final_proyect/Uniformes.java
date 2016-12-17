package edu.tecii.android.final_proyect;

public class Uniformes {
    private String nombre;
    private int idDrawable;

    public Uniformes(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static Uniformes[] ITEMS = {
            new Uniformes("America", R.drawable.america),
            new Uniformes("Atlas", R.drawable.atlas),
            new Uniformes("Barcelona", R.drawable.barcelona),
            new Uniformes("Chivas", R.drawable.chivas),
            new Uniformes("Fly_Emirates", R.drawable.emirates),
            new Uniformes("Jeep", R.drawable.jeep),
            new Uniformes("Pumas", R.drawable.pumas),
            new Uniformes("Real_Madrid", R.drawable.madrid),
    };

    public static Uniformes getItem(int id) {
        for (Uniformes item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}