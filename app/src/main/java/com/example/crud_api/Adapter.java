package com.example.crud_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class Adapter extends ArrayAdapter <Productos>{

    Context context;
    List<Productos> productosList;

    /*public Adapter(@NonNull Context context, List<Productos>ProductosList) {
        super(context,R.layout.list_productos,ProductosList);
        this.context=context;
        this.productosList=ProductosList;
    }*/



    public Adapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public Adapter(@NonNull Context context, int resource, @NonNull Productos[] objects) {
        super(context, resource, objects);
    }

    public Adapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Productos[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public Adapter(@NonNull Context context, int resource, @NonNull List<Productos> objects) {
        super(context, resource, objects);
    }

    public Adapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Productos> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}

