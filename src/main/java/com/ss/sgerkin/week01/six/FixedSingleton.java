package com.ss.sgerkin.week01.six;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;

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
