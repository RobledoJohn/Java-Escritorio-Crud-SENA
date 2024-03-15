package com.tienda;

import com.tienda.Modelo.Producto;
import com.tienda.Vista.Index;
import com.tienda.controlador.ProductosDAO;
import java.sql.SQLException;

public class Tienda {

    public static void main(String[] args) throws SQLException, Exception {
        
        /////////CREATE////////// ok
        /*
        Producto p = new Producto(6, "F25 Pro", "Oppo" ,499);
        Crud_Productos cp = new Crud_Productos();
        cp.create(p);
        */
        
        /////////READ////////// ok
        /*
        ProductosDAO cp = new ProductosDAO();
        cp.read(6);
        */
        
        /////////UPDATE//////////
        /*
        Producto p = new Producto(0,"Mate 12", "Xiaomi", 799);
        Crud_Productos cp = new Crud_Productos();
        cp.update(p);
        */
        
        /////////DELETE//////////
        /*
        Producto p = new Producto(0);
        ProductosDAO cp = new ProductosDAO();
        cp.delete(p);
        */
        
        Index venIndex = new Index();
        venIndex.setVisible(true);
        
    }
}
