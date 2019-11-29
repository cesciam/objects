package com.BibliotecaMusical.bl.Factory;

<<<<<<< Updated upstream
import com.BibliotecaMusical.bl.IUsuarioDAO;

public abstract class DAOFactory {


    public static DAOFactory getDaoFactory(int tipo){
        switch (tipo){
            // es MySql
            case 1: return new MySqlDaoFactory();
        // es SqlServer
            //case 2: return new SqlServerDaoFactory();
            //es Txt
            //case 3: return new TxtDaoFactory();
=======
import com.BibliotecaMusical.bl.Usuario.IUsuarioDAO;

public abstract class DAOFactory {
    public static DAOFactory getDaoFactory(int tipo){
        switch (tipo){
            case 1: return new MySqlDaoFactory();
>>>>>>> Stashed changes

            default: return null;
        }
    }

<<<<<<< Updated upstream
    public abstract IUsuarioDAO getpersonaDao();
=======
    public abstract IUsuarioDAO getUsuarioDao();
>>>>>>> Stashed changes

}
