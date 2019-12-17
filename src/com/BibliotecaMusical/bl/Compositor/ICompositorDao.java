package com.BibliotecaMusical.bl.Compositor;

import java.util.ArrayList;

public interface ICompositorDao {

    ArrayList<Compositor> listar();

    void registrarCompositor(Compositor compositor);

    void eliminar(int idCompositor);
}
