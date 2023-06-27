package com.badBoys.modelo;

import java.sql.Date;

public class Ventas {

    private int cod_ventas, id_empleado, id_cliente, id_moto;
    private Date fecha;
    private double total;
    private String empleado,cliente,motocicleta;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Ventas() {
        
    }

    public int getCod_ventas() {
        return cod_ventas;
    }

    public void setCod_ventas(int cod_ventas) {
        this.cod_ventas = cod_ventas;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_moto() {
        return id_moto;
    }

    public void setId_moto(int id_moto) {
        this.id_moto = id_moto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getMotocicleta() {
        return motocicleta;
    }

    public void setMotocicleta(String motocicleta) {
        this.motocicleta = motocicleta;
    }
    
}
