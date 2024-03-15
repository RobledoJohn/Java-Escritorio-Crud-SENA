
package com.tienda.controlador;

import com.datos.Conexion;
import com.tienda.Modelo.Producto;
import com.tienda.Vista.Productos;
import java.sql.*;
import javax.swing.JOptionPane;

public class ProductosDAO extends Conexion {
    
    public boolean create(int id, String modelo, String marca, int precio) throws SQLException{
        Connection conexion = null;
        PreparedStatement ps = null;
        Producto p = new Producto(id, modelo, marca, precio);
        String sql ="INSERT INTO productos(id,modelo,marca,precio) VALUES(?,?,?,?)";
        try{
            conexion = getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1,p.getId());
            ps.setString(2,p.getModelo());
            ps.setString(3,p.getMarca());
            ps.setInt(4,p.getPrecio());
            ps.execute();
            System.out.println("Producto Almacenado en la Base de Datos");
            System.out.println(p.toString());
            return true;
        }catch(SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Producto no pudo ser creado");
            return false; 
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }        
    }
    
    public Producto read(int id) throws SQLException, Exception{
        Connection conexion = null;
        PreparedStatement ps = null;
        String sql ="SELECT * FROM productos WHERE id = ?";
        try{
            conexion = getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int productoId = rs.getInt("id");
                String productoModelo = rs.getString("modelo");
                String productoMarca = rs.getString("marca");
                int productoPrecio = rs.getInt("precio");
                
                System.out.println(" Producto encontrado: " + 
                                   "\n Id: " + productoId +
                                   "\n modelo: " + productoModelo + 
                                   "\n Marca: " + productoMarca + 
                                   "\n Precio: " + productoPrecio); 
                
                Producto productoEncontrado = new Producto(productoId, productoModelo, productoMarca, productoPrecio);
                
                return productoEncontrado;
            }else {
                throw new Exception("El producto con ID " + id + " no se encontró.");
            }    
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }        
    }
    public boolean update(int id, String modelo, String marca, int precio) throws SQLException, Exception{
        Connection conexion = null;
        PreparedStatement ps = null;
        Producto p = new Producto(id, modelo, marca, precio);
        
        String sql ="UPDATE productos SET modelo = ?, marca = ?, precio = ? WHERE id = ?";
        try{
            conexion = getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setString(1,p.getModelo());
            ps.setString(2,p.getMarca());
            ps.setInt(3,p.getPrecio());
            ps.setInt(4,p.getId());
            ps.executeUpdate();
            
            System.out.println(" Producto Actualizado: " + p.toString());
            return true;
        }catch(SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Producto no pudo ser actualizado");
            return false; 
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }        
    }
    public boolean delete(int id) throws SQLException{
        
        Connection conexion = null;
        PreparedStatement ps = null;
        Producto p = new Producto(id);
        String sql ="DELETE FROM productos WHERE id = ?";
        try{
            conexion = getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1,p.getId());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Producto eliminado");
            
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false; 
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }        
    }
}