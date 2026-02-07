package com.backend.i2tlunchs.Model.MenuEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.backend.i2tlunchs.Model.PedidoEntity.PedidoDia;
import com.backend.i2tlunchs.Model.UserEntity.User;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menudia")
public class MenuDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_dia")
    private Long idMenuDia;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "publicado")
    private Boolean publicado;
    @Column(name = "stock_total")
    private Long stockTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private User usuarioMenu;

    @OneToMany(mappedBy = "menuDia", fetch = FetchType.LAZY)
    private List<PedidoDia> pedidosDia;

    @OneToMany(mappedBy = "menuPlato",  fetch = FetchType.LAZY)
    private List<MenuPlato> platos = new ArrayList<>();
}
