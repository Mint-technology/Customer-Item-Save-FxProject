/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.dao;

import javafx.collections.ObservableList;

import java.sql.SQLException;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public interface CrudDAO <T,ID> extends SuperDAO{
    public boolean add(T t)throws ClassNotFoundException, SQLException;
    public boolean delete (ID id) throws ClassNotFoundException, SQLException;
    public boolean update (T t) throws ClassNotFoundException, SQLException;
    public T search (ID id) throws ClassNotFoundException, SQLException;
    public ObservableList<T> getAll () throws ClassNotFoundException, SQLException;
}
