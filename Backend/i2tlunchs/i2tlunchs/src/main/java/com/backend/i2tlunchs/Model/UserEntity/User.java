package com.backend.i2tlunchs.Model.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.backend.i2tlunchs.Model.MenuEntity.MenuDia;
import com.backend.i2tlunchs.Model.NotificationEntity.Notification;
import com.backend.i2tlunchs.Model.PedidoEntity.Pedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "usuario")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre", length = 150)
    private String nombre;

    @Column(name = "apellido", length = 150, nullable = false)
    private String apellido;

    @Column(name = "dni", nullable = false, unique = true)
    private int dni;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private Role rol;

    @Column(name = "activo")
    private boolean activo;

    //pedido
    @OneToMany(mappedBy = "usuarioPedido", fetch = FetchType.LAZY)
    private List<Pedido> pedidos = new ArrayList<>();
    //notificacion
    @OneToMany(mappedBy = "usuarioNotificacion", fetch = FetchType.LAZY)
    private List<Notification> notifications = new ArrayList<>();
    //menudia
    @OneToMany(mappedBy = "usuarioMenu", fetch = FetchType.LAZY)
    private List<MenuDia> menuDia = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public String getUsername(){
        return correo;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
