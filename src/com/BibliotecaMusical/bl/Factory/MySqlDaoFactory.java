package com.BibliotecaMusical.bl.Factory;

<<<<<<< Updated upstream
import com.BibliotecaMusical.bl.IUsuarioDAO;
import com.BibliotecaMusical.bl.Usuario.UsuarioDAO;

public class MySqlDaoFactory extends DAOFactory {
    public IUsuarioDAO getpersonaDao() {

        return new UsuarioDAO();
    }

=======
import com.BibliotecaMusical.bl.Usuario.IUsuarioDAO;
import com.BibliotecaMusical.bl.Usuario.UsuarioDAO;

public class MySqlDaoFactory extends DAOFactory{

    @Override
    public IUsuarioDAO getUsuarioDao() {
        return new UsuarioDAO();
    }
>>>>>>> Stashed changes
}
