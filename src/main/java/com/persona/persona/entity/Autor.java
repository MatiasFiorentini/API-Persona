package com.persona.persona.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTORES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE autor SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(length = 1500, name = "BIOGRAFIA")
    private String biografia;

    @ManyToMany(mappedBy = "autores", cascade = CascadeType.ALL)
    private List<Libro> libros = new ArrayList<>();

    private boolean deleted = Boolean.FALSE;
}
