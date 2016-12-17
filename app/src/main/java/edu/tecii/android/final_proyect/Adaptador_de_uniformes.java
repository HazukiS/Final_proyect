package edu.tecii.android.final_proyect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hazuk on 08/12/2016.
 */
public class Adaptador_de_uniformes extends BaseAdapter {
    private Context context;

    public Adaptador_de_uniformes(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Uniformes.ITEMS.length;
    }

    @Override
    public Uniformes getItem(int position) {
        return Uniformes.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        ImageView imagenUniforme = (ImageView) view.findViewById(R.id.imagen_un);
        TextView nombreUniforme = (TextView) view.findViewById(R.id.nombre_un);

        final Uniformes item = getItem(position);
        imagenUniforme.setImageResource(item.getIdDrawable());
        nombreUniforme.setText(item.getNombre());

        return view;
    }

}
