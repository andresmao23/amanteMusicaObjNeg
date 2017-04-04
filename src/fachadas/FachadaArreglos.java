package fachadas;

import excepciones.FachadaException;
import excepciones.PersistenciaException;
import interfaces.IFachada;
import java.util.Vector;
import objetosNegocio.Cancion;
import objetosNegocio.Genero;
import objetosNegocio.Pelicula;
import persistencia.Canciones;
import persistencia.Generos;
import persistencia.Peliculas;

/**
 *
 * @author asus
 */
public class FachadaArreglos implements IFachada {
    
    private Generos catalogoGeneros;
    private Canciones catalogoCanciones;
    private Peliculas catalogoPeliculas;

    public FachadaArreglos() {
        catalogoGeneros = new Generos(50);
        catalogoCanciones = new Canciones(100);
        catalogoPeliculas = new Peliculas(100);
    }

    @Override
    public Cancion obten(Cancion cancion) throws FachadaException {
        return catalogoCanciones.obten(cancion);
    }

    @Override
    public void agrega(Cancion cancion) throws FachadaException {
        Cancion cancionBuscada;
        
        cancionBuscada = catalogoCanciones.obten(cancion);
        if(cancionBuscada != null) throw new FachadaException("Canción repetida");
        
        try {
            catalogoCanciones.agrega(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede agregar la canción", pe);
        }
    }

    @Override
    public void actualiza(Cancion cancion) throws FachadaException {
        try {
            catalogoCanciones.actualiza(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede actualizar la canción", pe);
        }
    }

    @Override
    public void elimina(Cancion cancion) throws FachadaException {
        try {
            catalogoCanciones.elimina(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar la canción", pe);
        }
    }

    @Override
    public Pelicula obten(Pelicula pelicula) throws FachadaException {
        return catalogoPeliculas.obten(pelicula);
    }

    @Override
    public void agrega(Pelicula pelicula) throws FachadaException {
        Pelicula peliculaBuscada;
        
        peliculaBuscada = catalogoPeliculas.obten(pelicula);
        
        if(peliculaBuscada != null) throw new FachadaException("Película repetida");
        
        try {
            catalogoPeliculas.agrega(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede agregar la película", pe);
        }
    }

    @Override
    public void actualiza(Pelicula pelicula) throws FachadaException {
        try {
            catalogoPeliculas.actualiza(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede actualizar la película", pe);
        }
    }

    @Override
    public void elimina(Pelicula pelicula) throws FachadaException {
        try {
            catalogoPeliculas.elimina(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar la película", pe);
        }
    }

    @Override
    public Genero obten(Genero genero) throws FachadaException {
        return catalogoGeneros.obten(genero);
    }

    @Override
    public void agrega(Genero genero) throws FachadaException {
        Genero generoBuscado;
        
        generoBuscado = catalogoGeneros.obten(genero);
        
        if(generoBuscado != null) throw new FachadaException("Genero repetido");
        
        try {
            catalogoGeneros.agrega(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede agregar el genero", pe);
        }
    }

    @Override
    public void actualiza(Genero genero) throws FachadaException {
        try {
            catalogoGeneros.actualiza(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede actualizar el genero", pe);
        }
    }

    @Override
    public void elimina(Genero genero) throws FachadaException {
        try {
            catalogoGeneros.elimina(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar el genero", pe);
        }
    }

    @Override
    public Vector consultaCanciones() throws FachadaException {
        return catalogoCanciones.lista();
    }

    @Override
    public Vector consultaCancionesTitulo(String titulo) throws FachadaException {
        return catalogoCanciones.listaTitulo(titulo);
    }

    @Override
    public Vector consultaCancionesInterprete(String interprete) throws FachadaException {
        return catalogoCanciones.listaInterprete(interprete);
    }

    @Override
    public Vector consultaCancionesAutor(String autor) throws FachadaException {
        return catalogoCanciones.listaAutor(autor);
    }

    @Override
    public Vector consultaCancionesGenero(String cveGenero) throws FachadaException {
        return catalogoCanciones.listaGenero(cveGenero);
    }

    @Override
    public Vector consultaCancionesAlbum(String album) throws FachadaException {
        return catalogoCanciones.listaAlbum(album);
    }

    @Override
    public Vector consultaPeliculas() throws FachadaException {
        return catalogoPeliculas.lista();
    }

    @Override
    public Vector consultaPeliculasTitulo(String titulo) throws FachadaException {
        return catalogoPeliculas.listaTitulo(titulo);
    }

    @Override
    public Vector consultaPeliculasActor(String actor) throws FachadaException {
        return catalogoPeliculas.listaActor(actor);
    }

    @Override
    public Vector consultaPeliculasDirector(String director) throws FachadaException {
        return catalogoPeliculas.listaDirector(director);
    }

    @Override
    public Vector consultaPeliculasGenero(String cveGenero) throws FachadaException {
        return catalogoPeliculas.listaGenero(cveGenero);
    }

    @Override
    public Vector consultaGeneros() throws FachadaException {
        return catalogoGeneros.lista();
    }

    @Override
    public Vector consultaGenerosCanciones() throws FachadaException {
        return catalogoGeneros.listaMedio('C');
    }

    @Override
    public Vector consultaGenerosPeliculas() throws FachadaException {
        return catalogoGeneros.listaMedio('P');
    }    
    
}
