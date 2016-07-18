https://books.sonatype.com/mcookbook/reference/sect-osgi-generate-project.html

Create the module OSGiProjectWithMaven
    mvn org.ops4j:maven-pax-plugin:create-project -DgroupId=org.sonatype.mcookbook -DartifactId=OSGiProjectWithMaven -Dversion=1.0-SNAPSHOT

Start up Felix
    mvn install pax:provision
