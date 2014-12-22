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
