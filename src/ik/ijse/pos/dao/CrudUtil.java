/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.dao;

import ik.ijse.pos.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql , Object... params) throws ClassNotFoundException, SQLException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i=0;i<params.length;i++){
            pstm.setObject((i+1),params[i]);
        }
        return pstm;
    }

    public static boolean executeUpdate(String sql , Object... params) throws ClassNotFoundException, SQLException{
        PreparedStatement pstm = getPreparedStatement(sql, params);
        return pstm.executeUpdate()>0;
    }

    public static ResultSet executeQuery(String sql, Object... params) throws ClassNotFoundException, SQLException{
        PreparedStatement pstm = getPreparedStatement(sql, params);
        return pstm.executeQuery();
    }
}

