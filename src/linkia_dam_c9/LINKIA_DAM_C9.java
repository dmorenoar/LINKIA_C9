/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkia_dam_c9;

import bbdd.LigaDB4o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import models.Entrenador;
import models.Pokemon;

/**
 *
 * @author dmorenoar
 */
public class LINKIA_DAM_C9 {

    /**
     * @param args the command line arguments
     */
    private static LigaDB4o gestor = new LigaDB4o();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        
        int opcion = 0;
        
        do{
            
            mostrarMenu();
            System.out.println("Escoge una opcion");
            opcion = Integer.parseInt(br.readLine());
            
            switch (opcion) {
                case 1:
                    insertarEntrenador();
                break;
                case 2:
                    selectAllEntrenadores();
                break;
                case 3:
                    borrarEntrenador();
                break;
                case 4:
                    selectAllEntrenadoresByEdad();
                break;
                case 5:
                    selectAllEntrenadoresByEdadRange();
                break;
                case 6:
                    altaPokemon();
                break;
                case 7:
                    selectAllPokemon();
                break;
                case 0:
                    System.out.println("Hasta pronto");
                break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }while(opcion != 0);
        
        
    }
    
    private static void mostrarMenu(){
        System.out.println("1 - Alta entrenador");
        System.out.println("2 - Listar entrenadores");
        System.out.println("3 - Borrar entrenadores");
        System.out.println("4 - Listar entrenadores por edad");
        System.out.println("5 - Listar entrenadores por rango");
        System.out.println("6 - Alta Pokemon");
        System.out.println("7 - Listar Pokemon");
        System.out.println("0 - Salir");
    }
    
    private static void insertarEntrenador() throws IOException{
        System.out.println("Introduce el nombre");
        String nombre = br.readLine();
        System.out.println("Introduce la edad");
        int edad = Integer.parseInt(br.readLine());
        System.out.println("Introduce la especialidad");
        String especialidad = br.readLine();
        
        Entrenador e = new Entrenador(nombre, edad, especialidad);
        gestor.insertarEntrenador(e);
        System.out.println("Entrenador dado de alta");
    }

    private static void selectAllEntrenadores() {
       List<Entrenador> entrenadores = gestor.selectAllEntrenadores();
       
        System.out.println("Listado de los entrenadores");
        for(Entrenador e: entrenadores){
            System.out.println(e);
        }
       
    }
    
    private static void borrarEntrenador() throws IOException{
        System.out.println("Introduce el nombre del entrenador a borrar");
        String nombre = br.readLine();
        
        gestor.borrarEntrenador(nombre);
        System.out.println("Entrenador borrado del sistema");
        
    }
    
    
    public static void selectAllEntrenadoresByEdad() throws IOException{
        System.out.println("Introduce la edad para buscar"); 
        int edad = Integer.parseInt(br.readLine());
        List<Entrenador> entrenadores = gestor.selectAllEntrenadoresByEdad(edad);
        
        for(Entrenador e: entrenadores){
            System.out.println(e);
        }
        
    }

    private static void selectAllEntrenadoresByEdadRange() throws IOException {
        System.out.println("Introduce la edad minima"); 
        int edadMinima = Integer.parseInt(br.readLine());
        
        System.out.println("Introduce la edad maxima"); 
        int edadMaxima = Integer.parseInt(br.readLine());
        
        List<Entrenador> entrenadores = gestor.selectAllEntrenadoresByEdadRange(edadMinima,edadMaxima);
        
        for(Entrenador e: entrenadores){
            System.out.println(e);
        }
        
    }
    
    private static void altaPokemon() throws IOException{
        System.out.println("Introduce el nombre");
        String nombre = br.readLine();
        System.out.println("Introduce su fuerza");
        int fuerza = Integer.parseInt(br.readLine());
        
        Entrenador e = new Entrenador("Gary",25,"A fastidiarte");
        
        Pokemon p = new Pokemon(nombre, fuerza, e);
     
        gestor.altaPokemon(p);
    }

    private static void selectAllPokemon() {
        List<Pokemon> pokemons = gestor.selectAllPokemons();
       
        System.out.println("Listado de los Pokemons");
        for(Pokemon p: pokemons){
            System.out.println(p);
        }
    }
}
