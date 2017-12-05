/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import java.util.ArrayList;
import java.util.List;
import models.Entrenador;
import models.Pokemon;

/**
 *
 * @author dmorenoar
 */
public class LigaDB4o {
    
    private ObjectContainer db;
    
    public LigaDB4o(){
        db = Db4oEmbedded.openFile("ligapokemon");
    }
    
    //Guardar un entrenador en la base de datos
    public void insertarEntrenador(Entrenador e){
        db.store(e);
    }
    
    //Lista todos los entrenadores en la base de datos
    public List<Entrenador> selectAllEntrenadores(){
        List<Entrenador> entrenadores = new ArrayList<>();
        
        //1.Preparar la query
        Query query = db.query();
        //2.Añadir las restricciones(Constrains)
        query.constrain(Entrenador.class); //Seleccionamos la tabla Entrenador
        //3.Ejecutamos la consulta y recuperamos los registros
        ObjectSet resultado = query.execute();
        
        //4.Recorremos los registros y los almacenamos en nuestro array
        /*Casteamos a Entrenador sin miedo porque ya hemos puesto la cosntraint 
        que queremos buscar en la tabla Entrenador*/
        
        while(resultado.hasNext()){
            Entrenador e = (Entrenador) resultado.next();
            entrenadores.add(e);   
        }

        return entrenadores;
    }
    
    //Borrar un entrenador en base a un nombre
    public void borrarEntrenador(String nombre){
        Query query = db.query();
        //Añadimos las constraints 
        query.constrain(Entrenador.class);
        query.descend("nombre").constrain(nombre); //Que nos busque el nombre
        ObjectSet resultado = query.execute();
        //Creamos un entrenador con el resultado que nos devuelve
        Entrenador e = (Entrenador) resultado.next();
        
        /*Hacemos esto porque db4o trabaja con objetos por lo tanto
        al eliminar debemos pasarle un objeto
        */
        db.delete(e);
        
    }
    
    //Listar entrenadores por edad
    public List<Entrenador> selectAllEntrenadoresByEdad(int edad){
        List<Entrenador> entrenadores = new ArrayList<>();
        
        Query query = db.query();
        query.constrain(Entrenador.class);
        query.descend("edad").constrain(edad).greater();
        
        
        //Buscar por especialidad
        //query.descend("especialidad").constrain(especialidad);
        ObjectSet resultado = query.execute();
        
        while(resultado.hasNext()){
            Entrenador e = (Entrenador) resultado.next();
            entrenadores.add(e);
        }
        
        return entrenadores;
    }
    
    //Buscar entrenadores por un rango de edad usando constraints anidadas
    public List<Entrenador> selectAllEntrenadoresByEdadRange(int edadMinima, int edadMaxima){
        List<Entrenador> entrenadores = new ArrayList<>();
        
        Query query = db.query();
        query.constrain(Entrenador.class);
        Constraint edadMin = query.descend("edad").constrain(edadMinima).greater();
        query.descend("edad").constrain(edadMaxima).smaller().and(edadMin);
        
        
        //Buscar por especialidad
        //query.descend("especialidad").constrain(especialidad);
        ObjectSet resultado = query.execute();
        
        while(resultado.hasNext()){
            Entrenador e = (Entrenador) resultado.next();
            entrenadores.add(e);
        }
        
        return entrenadores;
    }
    
    //Dar de alta un pokemon
    public void altaPokemon(Pokemon p){
        db.store(p);
    }

    public List<Pokemon> selectAllPokemons() {
         List<Pokemon> pokemons = new ArrayList<>();
        
        //1.Preparar la query
        Query query = db.query();
        //2.Añadir las restricciones(Constrains)
        query.constrain(Pokemon.class); //Seleccionamos la tabla Pokemon
        //3.Ejecutamos la consulta y recuperamos los registros
        ObjectSet resultado = query.execute();
        
        //4.Recorremos los registros y los almacenamos en nuestro array
        /*Casteamos a Pokemon sin miedo porque ya hemos puesto la cosntraint 
        que queremos buscar en la tabla Pokemon*/
        
        while(resultado.hasNext()){
            Pokemon p = (Pokemon) resultado.next();
            pokemons.add(p);   
        }

        return pokemons;
    }
    
}
