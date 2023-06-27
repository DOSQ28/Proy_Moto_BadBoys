
package com.badBoys.modelo;

public class Motocicletas {
    private int cod_moto ;    
    private String descripcion,placa,marca,tipo,color ;
    private int precio ;
    private String img ;

    public Motocicletas() {
        this.cod_moto = 0;
        this.descripcion = "";
        this.placa = "";
        this.marca = "";
        this.tipo = "";
        this.color = "";
        this.precio = 0;
        this.img = "";
    }

    public int getCod_moto() {
        return cod_moto;
    }

    public void setCod_moto(int cod_moto) {
        this.cod_moto = cod_moto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
        
}
