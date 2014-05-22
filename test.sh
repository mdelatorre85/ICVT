 mvn clean install -f pom.xml -DskipTests
 mvn clean install -f core/pom.xml -DskipTests
 mvn clean install -f impl/pom.xml -DskipTests
 mvn clean install -f front/pom.xml -DskipTests
 asadmin undeploy icvt
 asadmin deploy --name icvt --contextroot / front/target/front-1.0-SNAPSHOT.war
