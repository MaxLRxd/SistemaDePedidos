package com.backend.i2tlunchs.Model.NotificationEntity;

import java.util.Date;

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
@Table(name = "notificacion")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;
    //RELACION
    private Long idUsuario;
    @Column(name = "fecha_envio")
    private Date fecha_envio;
    @Column(name = "asunto")
    private String asunto;
    @Column(name = "mensaje")
    private String mensaje;
    

}
