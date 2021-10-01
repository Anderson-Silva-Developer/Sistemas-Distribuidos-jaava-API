package br.com.andersonsilva.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String numberFone;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String nameUse;
    @Column(unique = true)
    private String passWord;

}
