/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author dmorenoar
 */
public class Pokemon {
    private String nombre;
    private int fuerza;
    private Entrenador entrenador;

    public Pokemon() {
    }

    public Pokemon(String nombre, int fuerza, Entrenador entrenador) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.entrenador = entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nombre=" + nombre + ", fuerza=" + fuerza + ", entrenador=" + entrenador + '}';
    }
    
    
}
