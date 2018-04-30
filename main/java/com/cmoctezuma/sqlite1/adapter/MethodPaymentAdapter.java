package com.own.sqlite1.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.own.sqlite1.R;
import com.own.sqlite1.model.MethodPayment;

import java.util.List;

/**
 * Created by ASUS on 20/03/2018.
 */

public class MethodPaymentAdapter extends RecyclerView.Adapter <MethodPaymentAdapter.MethodViewHolder> implements View.OnClickListener {
    List<MethodPayment> methods;
    View.OnClickListener listener;
    //Constructor
    public MethodPaymentAdapter(List<MethodPayment> methods){
        this.methods = methods;
    }
    //getter and setter de listener
    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MethodPaymentAdapter.MethodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //se inflael cardview al reciclerview
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.method_cell_layout,parent,false);
        MethodPaymentAdapter.MethodViewHolder holder=new MethodPaymentAdapter.MethodViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MethodPaymentAdapter.MethodViewHolder holder, int position) {
        holder.txvMethodName.setText(methods.get(position).getName());
        holder.setListener(this);

    }

    @Override
    public int getItemCount() {
        return methods.size();
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public static class MethodViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        CardView crvMethod;
        TextView txvMethodName;
        ImageButton btnEdit;
        ImageButton btnDelete;
        View.OnClickListener listener;




        public MethodViewHolder(View itemView) {
            super(itemView);
            crvMethod =(CardView) itemView.findViewById(R.id.crv_method);
            txvMethodName =(TextView)itemView.findViewById(R.id.txv_methodname);
            btnEdit =(ImageButton) itemView.findViewById(R.id.btn_edit);
            btnDelete =(ImageButton) itemView.findViewById(R.id.btn_delete);
            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.onClick(v);
            }
        }

        public void setListener(View.OnClickListener listener){
            this.listener=listener;

        }
    }

}
