https://books.sonatype.com/mcookbook/reference/sect-osgi-generate-project.html

Create the module OSGiProjectWithMaven
    mvn org.ops4j:maven-pax-plugin:create-project -DgroupId=org.sonatype.mcookbook -DartifactId=OSGiProjectWithMaven -Dversion=1.0-SNAPSHOT

Start up Felix
    mvn install pax:provision

Install Apache Felix Web Management Console
    mvn pax:import-bundle -DgroupId=org.apache.felix -DartifactId=org.apache.felix.webconsole -Dversion=1.2.8
    
Install some of Apache Felix Web Management console's prerequisites
    mvn pax:import-bundle -DgroupId=org.apache.felix -DartifactId=javax.servlet -Dversion=1.0.0
    mvn pax:import-bundle -DgroupId=org.apache.felix -DartifactId=org.apache.felix.scr -Dversion=1.0.8
    mvn pax:import-bundle -DgroupId=org.apache.felix -DartifactId=org.apache.felix.http.jetty -Dversion=1.0.1

