package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	
	
    @Override
    public void insert(Department obj) {
       PreparedStatement st = null;
       
       try {
    	   st = conn.prepareStatement("INSERT INTO department (Id, Name) VALUES (?, ?)");
    	   
    	   st.setInt(1, obj.getId());
    	   st.setString(2, obj.getName());
    	   int row = st.executeUpdate();    	   
    	   
    	   if(row == 0) {
    		   throw new DbException("no lines affected! please check if the information is correct!!!!");
    	   }
    	   
       }catch(SQLException e) {
    	   throw new DbException(e.getMessage());
       }
       finally {
    	   DB.closeStatement(st);
       }
     
    }
    
    

    @Override
    public void update(Department obj) {
    	 PreparedStatement st = null;
         
         try {
      	   st = conn.prepareStatement("UPDATE department SET  Name = ? WHERE Id = ?");
      	   
      	  
      	   st.setString(1, obj.getName());
      	   st.setInt(2, obj.getId());
      	   
      	   int row = st.executeUpdate();    	   
      	   
      	   if(row == 0) {
      		   throw new DbException("no lines affected! please check if the information is correct!!!!");
      	   }
      	   
         }catch(SQLException e) {
      	   throw new DbException(e.getMessage());
         }
         finally {
      	   DB.closeStatement(st);
         }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        
        try {
        	st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
        	st.setInt(1, id);
        	
        	st.executeUpdate();
        	
        }catch(SQLException e) {
        	throw new DbException(e.getMessage());
        }
        finally {
        	DB.closeStatement(st);
        	
        }
    }

    @Override
    public Department findById(Integer Id) {
    	 PreparedStatement st = null;
    	 ResultSet rs = null;
         
         try {
      	   st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
      	   
      	   st.setInt(1, Id);
      	   
      	   st.executeQuery();
      	   rs =  st.executeQuery();
		 
		 if(rs.next()) {
			 Department dep = new Department();
			 dep.setId(rs.getInt("Id"));
			 dep.setName(rs.getString("Name"));
			 return dep;
			 
		 }
		 return null;
		 
         } 
         catch(SQLException e) {
        	 throw new DbException(e.getMessage());
         }
         finally {
        	 DB.closeStatement(st);
         }
    }

    @Override
    public List<Department> findAll() {
       PreparedStatement st = null;
       ResultSet rs = null;
       
       try {
    	   st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
    	   
    	   rs = st.executeQuery();
    	   
    	   List<Department> list = new ArrayList<>();
    	   
    	   while(rs.next()) {
    		   Department obj = new Department();
    		   obj.setId(rs.getInt("Id"));
    		   obj.setName(rs.getString("Name"));
    		   
    		   list.add(obj);
    	   }
    	   return list;
    	   
       }catch(SQLException e) {
    	   throw new DbException(e.getMessage());
       }
       finally {
    	   DB.closeResultSet(rs);
    	   DB.closeStatement(st);
       }
    	
    }

}