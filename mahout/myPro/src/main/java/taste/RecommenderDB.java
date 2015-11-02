package org.zhaolei.taste;

import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.neighborhood.*;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.similarity.*;
import java.io.*;
import java.util.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.jdbc.MySQLJDBCDiffStorage;
import org.apache.mahout.cf.taste.model.JDBCDataModel;

class RecommenderDB{

  private RecommenderDB() {
  }

  public static void main(String[] args) throws Exception {
	  File modelFile = null;
	  if (args.length > 0)
		  modelFile = new File(args[0]);
	  if(modelFile == null || !modelFile.exists())
		  modelFile = new File("intro.csv");
      /*
	  if(!modelFile.exists()) {
		  System.err.println("Please, specify name of file, or put file 'input.csv' into current directory!");
		  System.exit(1);
	  }
      */
	  //DataModel model = new FileDataModel(modelFile);

      MysqlDataSource dataSource = new MysqlDataSource();
      dataSource.setServerName("127.0.0.1");
      dataSource.setUser("root");
      dataSource.setPassword("root");
      dataSource.setDatabaseName("data");
      JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "mahout_item", "uid", "item", "score", "datetime");
      System.out.println("debug: mysql ok");

    UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
    UserNeighborhood neighborhood =
      new NearestNUserNeighborhood(2, similarity, dataModel);

    Recommender recommender = new GenericUserBasedRecommender(
        dataModel, neighborhood, similarity);

    List<RecommendedItem> recommendations =
        recommender.recommend(1, 1);

    for (RecommendedItem recommendation : recommendations) {
      System.out.println(recommendation);
    }

  }

}
