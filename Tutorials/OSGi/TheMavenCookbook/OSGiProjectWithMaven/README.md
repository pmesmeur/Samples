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

Connect to http://localhost:8080/system/console
*Before that, possible relaunch the Felix OSGi container*

    mvn install pax:provision


Instruct the Pax plugin to install a bundle's full compile and runtime dependencies in provision/pom.xml

    mvn pax:import-bundle -DgroupId=org.apache.felix -DartifactId=org.apache.felix.http.jetty -Dversion=1.0.1 -DimportTransitive=true -DimportOptional=true -DwidenScope=true
    

Creating an OSGi bundle

    mvn pax:create-bundle -Dpackage=org.sonatype.mcookbook -Dname=osgi-bundle -Dversion=1.0-SNAPSHOT
