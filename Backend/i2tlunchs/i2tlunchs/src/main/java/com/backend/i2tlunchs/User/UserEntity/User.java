package com.backend.i2tlunchs.User.UserEntity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
@Table(name = "usuario")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    //FALTAN RELACIONES

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
