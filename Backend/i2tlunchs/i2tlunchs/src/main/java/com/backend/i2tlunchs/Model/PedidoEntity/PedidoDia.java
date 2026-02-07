package com.backend.i2tlunchs.Model.PedidoEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.backend.i2tlunchs.Model.MenuEntity.MenuDia;
import com.backend.i2tlunchs.Model.PlatoEntity.Plato;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(name = "id_pedido_dia")
    private long idPedidoDia;
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)
    private Pedido pedidoDia;
    @OneToMany(mappedBy = "platoDia", fetch = FetchType.LAZY)
    private List<Plato> platos = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu_dia", referencedColumnName = "id_menu_dia", nullable = false)
    private MenuDia menuDia;
}
