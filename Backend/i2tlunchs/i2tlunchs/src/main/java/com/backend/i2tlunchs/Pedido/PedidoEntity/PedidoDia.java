package com.backend.i2tlunchs.Pedido.PedidoEntity;

import java.util.Date;

import jakarta.persistence.Entity;
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
@Table(name = "pedidodia")
public class PedidoDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPedidoDia;
    private long idPedido;
    private long idPlato;
    private long idMenuDia;
    private Date fechaEntrega;
}
