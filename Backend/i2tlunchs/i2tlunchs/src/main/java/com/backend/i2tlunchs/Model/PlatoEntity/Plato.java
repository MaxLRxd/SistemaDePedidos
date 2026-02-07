package com.backend.i2tlunchs.Model.PlatoEntity;

import java.util.ArrayList;
import java.util.List;

import com.backend.i2tlunchs.Model.MenuEntity.MenuPlato;
import com.backend.i2tlunchs.Model.PedidoEntity.PedidoDia;

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
@Table(name = "plato")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plato")
    private long idPlato;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "categoria")
    private String categoria;

    //FALTAN RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido_dia", referencedColumnName = "id_pedido_dia", nullable = false)
    private PedidoDia pedidoDia;

    @OneToMany(mappedBy = "plato", fetch = FetchType.LAZY)
    private List<MenuPlato> platosEnMenu = new ArrayList<>();
}
