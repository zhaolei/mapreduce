mapreduce
=========
Create code project
---------------
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=org.conan.mymahout -DartifactId=myPro -DpackageName=org.conan.mymahout -Dversion=1.0-SNAPSHOT -DinteractiveMode=false

Run class
--------------------
mvn exec:java -Dexec.mainClass="org.zhaolei.Kmeans"
mvn exec:java -Dexec.mainClass="org.zhaolei.Kmeans"  -Dexec.args="arg0 arg1 arg2"

mapreduce study self


/www/local/mahout/bin/mahout seqdirectory -i file://$(pwd)/d1/ -o file://$(pwd)/d1seq/ -c UTF-8 -chunk 64 -xm sequential

mahout seqdumper -i /data/out/reuters-sparse/wordcount/part-r-00000 
