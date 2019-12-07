package com.BibliotecaMusical.bl.Factory;


import com.BibliotecaMusical.bl.Artista.IArtistaDao;
import com.BibliotecaMusical.bl.Cancion.ICancionDao;
import com.BibliotecaMusical.bl.Compositor.ICompositorDao;
import com.BibliotecaMusical.bl.Genero.IGeneroDAO;
import com.BibliotecaMusical.bl.ListaReproduccion.IListaReproduccionDAO;
import com.BibliotecaMusical.bl.Usuario.IUsuarioDAO;

public abstract class DAOFactory {


    public static DAOFactory getDaoFactory(int tipo) {
        switch (tipo) {
            // es MySql
            case 1:
                return new MySqlDaoFactory();
            // es SqlServer
            //case 2: return new SqlServerDaoFactory();
            //es Txt
            //case 3: return new TxtDaoFactory();
        }

        return null;
    }

    public abstract IUsuarioDAO getpersonaDao();

    public abstract IListaReproduccionDAO getListaReproduccionDao();

    public abstract IGeneroDAO getGeneroDao();

    public abstract IArtistaDao getArtistaDao();

    public abstract ICancionDao getCancionDao();

    public abstract ICompositorDao getCompositorDao();
}
