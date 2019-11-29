package com.BibliotecaMusical.bl.Factory;

import com.BibliotecaMusical.bl.Usuario.IUsuarioDAO;
import com.BibliotecaMusical.bl.Usuario.UsuarioDAO;

public class MySqlDaoFactory extends DAOFactory {
    public IUsuarioDAO getpersonaDao() {

        return new UsuarioDAO();
    }

}
