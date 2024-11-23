package com.rs.garaMan218.dao;

import com.rs.garaMan218.model.NhaCungCap218;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhaCungCap218DAO extends DAO{

    public NhaCungCap218DAO(){
        super();
    }

    public NhaCungCap218 layNhaCungCap(int id) throws SQLException{
        String sql = """
                SELECT 
                    ncc.id, 
                    ncc.ten, 
                    ncc.email, 
                    ncc.soDienThoai, 
                    ncc.maSoThue
                FROM 
                    tblnhacungcap218 AS ncc
                WHERE 
                    ncc.id = ?
                """;

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            NhaCungCap218 nhaCungCap218 = new NhaCungCap218(
                    resultSet.getInt("id"),
                    resultSet.getString("ten"),
                    resultSet.getString("email"),
                    resultSet.getString("soDienThoai"),
                    resultSet.getString("maSoThue")
            );
            return nhaCungCap218;
        }

        return null;
    }
}
