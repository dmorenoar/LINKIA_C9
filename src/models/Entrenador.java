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
public class Entrenador {
    private String nombre;
    private int edad;
    private String especialidad;

    public Entrenador() {
    }

    public Entrenador(String nombre, int edad, String especialidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Entrenador{" + "nombre=" + nombre + ", edad=" + edad + ", especialidad=" + especialidad + '}';
    }
    
    
}
