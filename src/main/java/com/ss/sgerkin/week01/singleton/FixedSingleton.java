package com.ss.sgerkin.week01.singleton;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This singleton has been "fixed" so as to compile and act correctly. That being said, there are
 * additional changes that can be made to improve upon the functionality considerably. For example,
 * ideally we should be injecting the database details rather than hard coding them. Additionally,
 * refactoring to use a connection pool, rather than opening a new connection for each query, may
 * significantly improve performance.
 */
public class FixedSingleton {

  private static final String DATABASE_CONN = "url of database";

  // eager initialization is thread safe
  private static final FixedSingleton INSTANCE = new FixedSingleton();

  private FixedSingleton() {
  }

  public static FixedSingleton getInstance() {
    return INSTANCE;
  }

  public void databaseQuery(BigDecimal input) {
    var sql = "select id from table";

    try (var conn = DriverManager.getConnection(DATABASE_CONN);
        var st = conn.createStatement();
        var rs = st.executeQuery(sql)) {

      var x = new BigDecimal(0);
      while (rs.next()) {
        x = input.multiply(BigDecimal.valueOf(rs.getInt(1)));
        System.out.println(x);
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }
}
