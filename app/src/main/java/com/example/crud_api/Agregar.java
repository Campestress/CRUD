package com.example.crud_api;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Agregar extends AppCompatActivity {
    EditText edDescripcion, edPrecio, edCategoria, edProducto;
    Button btnInsertar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        edDescripcion=findViewById(R.id.edDescripcion);
        edPrecio=findViewById(R.id.edPrecio);
        edCategoria=findViewById(R.id.edCategoria);
        edProducto=findViewById(R.id.edProducto);
        btnInsertar=findViewById(R.id.btnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertarDatos();
            }
        });
    }
    private void InsertarDatos(){
        String Precio=edPrecio.getText().toString().trim();
        String Categoria=edCategoria.getText().toString().trim();
        String Producto=edProducto.getText().toString().trim();
        String Descripcion=edDescripcion.getText().toString().trim();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargandooo");

        if (Producto.isEmpty()){
            Toast.makeText(this, "Ingrese nombre del Producto", Toast.LENGTH_SHORT).show();
        }else if (Categoria.isEmpty()){
            Toast.makeText(this, "Ingrese Categoria", Toast.LENGTH_SHORT).show();
        } else if (Precio.isEmpty()) {
            Toast.makeText(this, "Ingrese Precio", Toast.LENGTH_SHORT).show();
        } else if (Descripcion.isEmpty()) {
            Toast.makeText(this, "Ingrese Descripcion", Toast.LENGTH_SHORT).show();
        }else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.6:8888/web-service/insertar_.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("datos ingresados")){
                                Toast.makeText(Agregar.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), Agregar.class));
                                finish();
                            }else {
                                Toast.makeText(Agregar.this, "ERROR de insersion", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Agregar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params=new HashMap<>();
                            params.put("producto",Producto);
                            params.put("categoria",Categoria);
                            params.put("precio",Precio);
                            params.put("descripcion",Descripcion);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Agregar.this);
            requestQueue.add(request);
        }
    }
}