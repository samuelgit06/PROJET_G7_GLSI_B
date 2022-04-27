package com.example.Projet1.Models;

import ch.qos.logback.core.net.server.Client;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.LocalDate;

public class Vente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;
    private LocalDate dateVente;
     @ManyToOne
    @JoinColumn(name = "Id", insertable = false ,updatable = false )
    private Client  client;
     private  int Id ;
}
