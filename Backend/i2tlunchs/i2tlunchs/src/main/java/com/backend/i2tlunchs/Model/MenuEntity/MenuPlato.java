package com.backend.i2tlunchs.Model.MenuEntity;

import com.backend.i2tlunchs.Model.PlatoEntity.Plato;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "menuplato")
public class MenuPlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_plato")
    private Long idMenuPlato;

    @Column(name = "stock_disponible")
    private Long stockDisponible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu_dia", referencedColumnName = "id_menu_dia")
    private MenuDia menuPlato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu_plato", referencedColumnName = "id_menu_plato")
    private Plato plato;
}
