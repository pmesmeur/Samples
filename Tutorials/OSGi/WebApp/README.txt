http://www.hascode.com/2010/07/how-to-create-a-simple-osgi-web-application-using-maven/

1) Download Felix

2) In the Felix distribution, set the HTTP port in the file conf/config.properties:
   e.g. org.osgi.service.http.port=8686

3) Launch Felix
   java -jar bin/felix.jar

4) Build the InformationBrokerBundle and the ServletBundle
   mvn package

5) In the Felix console
  * List the bundles

    g! lb
    START LEVEL 1
       ID|State      |Level|Name
        0|Active     |    0|System Bundle (5.4.0)|5.4.0
        1|Active     |    1|Apache Felix Bundle Repository (2.0.6)|2.0.6
        2|Active     |    1|Apache Felix Gogo Command (0.16.0)|0.16.0
        3|Active     |    1|Apache Felix Gogo Runtime (0.16.2)|0.16.2
        4|Active     |    1|Apache Felix Gogo Shell (0.10.0)|0.10.0

  * Install the InformationBrokerBundle
    g! felix:install file:/media/data/Users/phimesme/Devel/Perso/Samples/Java/OSGi/WebApp/InformationBrokerBundle/target/information-broker-bundle-0.0.1-SNAPSHOT.jar
    Bundle ID: 5
    g! lb
    START LEVEL 1
       ID|State      |Level|Name
        0|Active     |    0|System Bundle (5.4.0)|5.4.0
        1|Active     |    1|Apache Felix Bundle Repository (2.0.6)|2.0.6
        2|Active     |    1|Apache Felix Gogo Command (0.16.0)|0.16.0
        3|Active     |    1|Apache Felix Gogo Runtime (0.16.2)|0.16.2
        4|Active     |    1|Apache Felix Gogo Shell (0.10.0)|0.10.0
        5|Installed  |    1|Information Broker Service Bundle (0.0.1.SNAPSHOT)|0.0.1.SNAPSHOT
    g! start 5
    g! lb
    START LEVEL 1
       ID|State      |Level|Name
        0|Active     |    0|System Bundle (5.4.0)|5.4.0
        1|Active     |    1|Apache Felix Bundle Repository (2.0.6)|2.0.6
        2|Active     |    1|Apache Felix Gogo Command (0.16.0)|0.16.0
        3|Active     |    1|Apache Felix Gogo Runtime (0.16.2)|0.16.2
        4|Active     |    1|Apache Felix Gogo Shell (0.10.0)|0.10.0
        5|Active     |    1|Information Broker Service Bundle (0.0.1.SNAPSHOT)|0.0.1.SNAPSHOT

  * Install the API and the Jetty server
    g! obr:deploy "Apache Felix Http Api"
    g! obr:deploy "Apache Felix Http Api"
    g! obr:deploy "Apache Felix Http Jetty"

  * Start all the newly installed bundles
    lb
    ....
    start <bundleId>

  * Install the ServletBundle
    g! install file:/media/data/Users/phimesme/Devel/Perso/Samples/Java/OSGi/WebApp/ServletBundle/target/information-broker-servlet-bundle-0.0.1-SNAPSHOT.jar
    Bundle ID: 12
    g! start 12

6) In an explorer, open the following URL:
    http://localhost:8686
    (8686 being the port specified in the configuration file conf/config.properties)