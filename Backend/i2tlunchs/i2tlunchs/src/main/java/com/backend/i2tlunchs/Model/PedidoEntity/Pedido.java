package com.backend.i2tlunchs.Model.PedidoEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.backend.i2tlunchs.Model.UserEntity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;
    @Column(name = "fecha_pedido")
    private Date fechaPedido;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Column(name = "cantidad_personas")
    private int cantidadPersonas;


    //FALTAN RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private User usuarioPedido;

    @OneToMany(mappedBy = "pedidoDia", fetch = FetchType.LAZY)
    private List<PedidoDia> pedidos = new ArrayList<>();
    
}
