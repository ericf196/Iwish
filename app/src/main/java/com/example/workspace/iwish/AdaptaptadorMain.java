
package com.example.workspace.iwish;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.workspace.iwish.R;
import com.example.workspace.iwish.model.Meta;

/**
 * Created by WorkSpace on 05/08/2016.
 */
public class AdaptaptadorMain extends RecyclerView.Adapter<AdaptaptadorMain.ViewHolder>{

    public AdaptaptadorMain() {
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder{
        //campos respectivo item

        public TextView fecha, categoria, prioridad, titulo;

        public ViewHolder(View view){
            super(view);
            fecha= (TextView) view.findViewById(R.id.txtfecha);
            categoria= (TextView) view.findViewById(R.id.txtCategoria);
            prioridad= (TextView) view.findViewById(R.id.txtPrioridad);
            titulo= (TextView) view.findViewById(R.id.txtTitulo);

        }

    }


    public  ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Meta item =Meta.metas.get(position);
        holder.fecha.setText(item.getFecha());
        holder.titulo.setText(item.getTitulo());
        holder.categoria.setText(item.getCategoria());
        holder.prioridad.setText(item.getPrioridad());

    }

    @Override
    public int getItemCount() {
        return Meta.metas.size();
    }



}


