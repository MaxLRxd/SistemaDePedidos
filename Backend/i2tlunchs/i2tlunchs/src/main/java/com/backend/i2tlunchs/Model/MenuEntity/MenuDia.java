package com.backend.i2tlunchs.Model.MenuEntity;

import java.sql.Date;

import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menudia")
public class MenuDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenuDia;
    //RELACION
    private Long idUsuario;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "publicado")
    private Boolean publicado;
    @Column(name = "stock_total")
    private Long stockTotal;
}
