package com.BibliotecaMusical.bl.Factory;

import com.BibliotecaMusical.bl.Artista.ArtistaDao;
import com.BibliotecaMusical.bl.Artista.IArtistaDao;
import com.BibliotecaMusical.bl.Cancion.CancionDao;
import com.BibliotecaMusical.bl.Cancion.ICancionDao;
import com.BibliotecaMusical.bl.Genero.GeneroDao;
import com.BibliotecaMusical.bl.Genero.IGeneroDAO;
import com.BibliotecaMusical.bl.ListaReproduccion.IListaReproduccionDAO;
import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproduccionDAO;
import com.BibliotecaMusical.bl.Usuario.IUsuarioDAO;
import com.BibliotecaMusical.bl.Usuario.UsuarioDAO;

public class MySqlDaoFactory extends DAOFactory {
    public IUsuarioDAO getpersonaDao() {
        return new UsuarioDAO();
    }

    @Override
    public IListaReproduccionDAO getListaReproduccionDao() {
        return new ListaReproduccionDAO();
    }

    @Override
    public IGeneroDAO getGeneroDao() {
        return new GeneroDao();
    }

    @Override
    public IArtistaDao getArtistaDao() {
        return new ArtistaDao();
    }

    @Override
    public ICancionDao getCancionDao() {
        return new CancionDao();
    }
}
