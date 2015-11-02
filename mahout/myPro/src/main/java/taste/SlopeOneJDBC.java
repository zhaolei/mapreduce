package org.zhaolei.re;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.common.Weighting;
import org.apache.mahout.cf.taste.impl.model.jdbc.AbstractJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.jdbc.MySQLJDBCDiffStorage;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.slopeone.DiffStorage;
import org.apache.mahout.cf.taste.model.JDBCDataModel;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

class SlopeOneJDBC {

  Recommender buildRecommender() throws TasteException {
    AbstractJDBCDataModel model = new MySQLJDBCDataModel();
    DiffStorage diffStorage = new MySQLJDBCDiffStorage(model);
    return new SlopeOneRecommender(
        model, Weighting.WEIGHTED, Weighting.WEIGHTED, diffStorage);
  }


  public static void main(String[] args) throws Exception {
      MysqlDataSource dataSource = new MysqlDataSource();
      dataSource.setServerName("127.0.0.1");
      dataSource.setUser("root");
      dataSource.setPassword("root");
      dataSource.setDatabaseName("data");
      JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "mahout_item", "uid", "item", "score", "datetime");
      System.out.println("debug: mysql ok");
  }
}
