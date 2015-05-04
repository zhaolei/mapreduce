package org.zhaolei;  
import java.io.IOException;  
import java.net.URI;  
import org.apache.hadoop.conf.Configuration;  
import org.apache.hadoop.fs.FileSystem;  
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.io.IOUtils;  
import org.apache.hadoop.io.IntWritable;  
import org.apache.hadoop.io.SequenceFile;  
import org.apache.hadoop.io.Text;  
/** 
 * @author Eric.sunah 2014年12月10日
  * 
 */  
public class SeqRead {  
   
 private static final String OPERA_FILE = "./output.seq";  
   
 public static void main(String[] args) throws IOException {  
  //writeSequenceFile(OPERA_FILE);  
  readSequenceFile(OPERA_FILE);  
 }  
   
 private static void readSequenceFile(String inputFile) throws IOException {  
  Configuration config = new Configuration();  
  Path path = new Path(inputFile);  
  SequenceFile.Reader reader = null;  
  try {  
     
   FileSystem fs = FileSystem.get(URI.create(inputFile), config);  
   reader = new SequenceFile.Reader(fs, path, config);  
   IntWritable key = new IntWritable();  
   Text value = new Text();  
   long posion = reader.getPosition();  
   // reader.next()返回非空的话表示正在读，如果返回null表示已经读到文件结尾的地方  
   while (reader.next(key, value)) {  
    //打印同步点的位置信息  
    String syncMark = reader.syncSeen() ? "*" : "";  
    System.out.printf("[%s\t%s]\t%s\t%s\n", posion, syncMark, key, value);  
    posion = reader.getPosition();  
   }  
  } finally {  
   IOUtils.closeStream(reader);  
  }  
 }
   
 }  
   
   
