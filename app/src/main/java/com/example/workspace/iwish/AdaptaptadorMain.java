
package com.example.workspace.iwish;

import android.app.Activity;

import android.content.Context;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;

import com.example.workspace.iwish.model.Meta;

/**
 * Created by WorkSpace on 05/08/2016.
 */
public class AdaptaptadorMain extends RecyclerView.Adapter<AdaptaptadorMain.ViewHolder> {

    Context c;

    public AdaptaptadorMain(Context c) {
       this.c = c;

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        //campos respectivo item

        public TextView fecha, categoria, prioridad, titulo;
        public CardView cardView;

        public ViewHolder(View view) {
            super(view);
            fecha = (TextView) view.findViewById(R.id.txtfecha);
            categoria = (TextView) view.findViewById(R.id.txtCategoria);
            prioridad = (TextView) view.findViewById(R.id.txtPrioridad);
            titulo = (TextView) view.findViewById(R.id.txtTitulo);
            cardView = (CardView) view.findViewById(R.id.cardview);

        }

    }


    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        c=viewGroup.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Meta item = Meta.metas.get(position); // pilas con este
        holder.fecha.setText(item.getFecha());
        holder.titulo.setText(item.getTitulo());
        holder.categoria.setText(item.getCategoria());
        holder.prioridad.setText(item.getPrioridad());

        ManejadorCardView(holder, item);

    }

    private void ManejadorCardView(ViewHolder holder, final Meta item) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            String prioridad = item.getPrioridad();

            @Override
            public void onClick(View view) {

                Fragment_detail fragment_detail = new Fragment_detail();
                Bundle bundle = new Bundle();
                Meta meta = item;
                bundle.putSerializable("meta", meta);

                fragment_detail.setArguments(bundle);
                Log.v("mensaje","lo pase");
                FragmentManager manager = ((AppCompatActivity) c).getSupportFragmentManager();

                manager.beginTransaction().replace(R.id.contenedor_main, fragment_detail, "detail").addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return Meta.metas.size();
    }


}


