package com.persona.persona.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE domicilio SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private Integer numero;

    @ManyToOne(optional = false) //domicilio si o si tiene q tener una localidad
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    private boolean deleted = Boolean.FALSE;

}
