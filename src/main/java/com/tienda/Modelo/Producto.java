package com.tienda.Modelo;

public class Producto {
    
    private int id;
    private String modelo;
    private String marca;
    private int precio;

    public Producto() {
    }

    public Producto (int id){
        this.id = id;
    }
    
    public Producto(String modelo, String marca, int precio){
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }
    
    public Producto(int id, String modelo, String marca, int precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + 
                "id=" + id + 
                ", modelo=" + modelo + 
                ", marca=" + marca + 
                ", precio=" + precio + 
                '}';
    }
}
