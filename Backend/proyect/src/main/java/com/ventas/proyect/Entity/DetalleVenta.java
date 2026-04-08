package com.ventas.proyect.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_detalle_venta")
    private Integer codigoDetalleVenta;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "Productos_codigo_producto")
    private Integer ProductosCodigoProducto;

    @Column(name = "Ventas_codigo_venta")
    private Integer VentasCodigoVenta;

    public Integer getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(Integer codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductosCodigoProducto() {
        return ProductosCodigoProducto;
    }

    public void setProductosCodigoProducto(Integer productosCodigoProducto) {
        ProductosCodigoProducto = productosCodigoProducto;
    }

    public Integer getVentasCodigoVenta() {
        return VentasCodigoVenta;
    }

    public void setVentasCodigoVenta(Integer ventasCodigoVenta) {
        VentasCodigoVenta = ventasCodigoVenta;
    }
}
