/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import db.DBUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.News;

/**
 *
 * @author Thang
 */
public class DataAccess {
    public void addNew(News n){
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("insert into news values(?,?,?,?,?,?,?)");
           
            ps.setInt(1, n.getId());
            ps.setString(2, n.getTitle());
            ps.setString(3, n.getDate());
            ps.setString(4, n.getDescription());
            ps.setString(5, n.getDetail());
            ps.setString(6, n.getCategory());
            ps.setString(7, n.getImage());
            ps.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   //  News n = new News(0, title, date, description, detail, category, image);
    
    public static List<News> getAll(){
        List<News> ls = new LinkedList<>();
        
        try {
            ResultSet rs = DBUtils.getPreparedStatement("select * from news").executeQuery();
            while(rs.next()){
                News n = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ls;
    }
    
    public static List<News> getNewById(int id){
        List<News> ls = new LinkedList<>();
        String sql = "select * from news where id = " +id;
        try {
            ResultSet rs = DBUtils.getPreparedStatement(sql).executeQuery();
            while(rs.next()){
                News n = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ls;
    }
    
    
    public void edit(int id, String title, String description, String detail, String category, String image){
        try {
            String sql = "update news SET title = ?, description = ?, detail = ?, category = ?, image = ?" + " where id = ?";
            PreparedStatement ps= DBUtils.getPreparedStatement(sql);
            
          
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3, detail);
            ps.setString(4, category);
            ps.setString(5, image);
            ps.setInt(6, id);
            ps.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void delete(int id){
        try {
            String sql = "delete news where id = ?";
            PreparedStatement ps = DBUtils.getPreparedStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
