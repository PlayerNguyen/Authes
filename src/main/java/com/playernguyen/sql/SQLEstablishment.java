package com.playernguyen.sql;

import java.sql.Connection;
import java.sql.SQLException;

public interface SQLEstablishment  {

    Connection openConnection() throws SQLException;

}
