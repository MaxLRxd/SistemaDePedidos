package com.backend.i2tlunchs.Model.PedidoEntity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPedido;
    @Column(name = "id_usuario", nullable = false, unique = true)
    private long idUsuario;
    @Column(name = "fecha_pedido")
    private Date fechaPedido;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Column(name = "cantidad_personas")
    private int cantidadPersonas;


    //FALTAN RELACIONES
}
