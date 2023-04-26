package com.example.crud_api;

public class Productos {
    String producto, categoria, precio, descripcion;

    public Productos(String producto, String categoria, String precio, String descripcion) {
        this.producto = producto;
        this.categoria = categoria;
        this.precio = precio;
        this.descripcion = descripcion;
    }


    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
