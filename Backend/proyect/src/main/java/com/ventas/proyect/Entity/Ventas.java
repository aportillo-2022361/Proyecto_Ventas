package com.ventas.proyect.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_venta")
    private Integer codigoVenta;

    @Column(name = "fecha_venta")
    private Date fechaVenta;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "Clientes_dpi_cliente")
    private Integer ClientesDpiCliente;

    @Column(name = "Usuarios_codigo_usuario")
    private Integer UsuariosCodigoUsuario;

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getClientesDpiCliente() {
        return ClientesDpiCliente;
    }

    public void setClientesDpiCliente(Integer clientesDpiCliente) {
        ClientesDpiCliente = clientesDpiCliente;
    }

    public Integer getUsuariosCodigoUsuario() {
        return UsuariosCodigoUsuario;
    }

    public void setUsuariosCodigoUsuario(Integer usuariosCodigoUsuario) {
        UsuariosCodigoUsuario = usuariosCodigoUsuario;
    }
}
