@echo off
echo "Installazione librerie WEB SERVICE CLIENT ALFRESCO"

call mvn install:install-file -DgroupId=org.alfresco.webservice -DartifactId=alfresco-ws-api -Dpackaging=jar -Dversion=3.2 -Dfile=alfresco-web-service-client-3.2.jar -DgeneratePom=true
call mvn install:install-file -DgroupId=org.apache.axis -DartifactId=axis -Dpackaging=jar -Dversion=1.4 -Dfile=axis-1.4.jar -DgeneratePom=true


echo "Fatto!"

echo "Installazione librerie per la MAIL-PORTLET"

call mvn install:install-file -DgroupId=com.liferay.portlet -DartifactId=mail-portlet-service -Dpackaging=jar -Dversion=1.0 -Dfile=mail-portlet-service.jar -DgeneratePom=true


echo "Fatto!"

echo "Installazione librerie per calendar-liferay"
call mvn install:install-file -Dfile=calendar-portlet-service.jar -DgroupId=com.liferay.portal -DartifactId=calendar-portlet -Dversion=6.2.0-RC5 -Dpackaging=jar
echo "Fatto!"

echo "Installazione librerie per jod converter"
call mvn install:install-file -DgroupId=com.artofsolving -DartifactId=jodconverter -Dpackaging=jar -Dversion=2.2.2 -Dfile=jodconverter-2.2.2.jar -DgeneratePom=true
echo "Fatto!"

call mvn install:install-file -DgroupId=org.codehaus.mojo -DartifactId=build-helper-maven-plugin -Dpackaging=jar -Dversion=1.7 -Dfile=build-helper-maven-plugin-1.7.jar -DgeneratePom=true
call mvn install:install-file -DgroupId=org.apache.cxf -DartifactId=cxf-codegen-plugin -Dpackaging=jar -Dversion=2.4.2 -Dfile=cxf-codegen-plugin-2.4.2.jar -DgeneratePom=true
call mvn install:install-file -DgroupId=com.javaexchangeconnector -DartifactId=jec -Dpackaging=jar -Dversion=1.53_11 -Dfile=jec-1.53_11.jar -DgeneratePom=true
call mvn install:install-file -DgroupId=org.apache.maven.plugins -DartifactId=maven-antrun-plugin -Dpackaging=jar -Dversion=1.3 -Dfile=maven-antrun-plugin-1.3.jar -DgeneratePom=true
call mvn install:install-file -DgroupId=org.apache.maven.plugins -DartifactId=maven-antrun-plugin -Dpackaging=jar -Dversion=1.1 -Dfile=maven-antrun-plugin-1.1.jar -DgeneratePom=true
call mvn install:install-file -DgroupId=com.liferay.maven.plugins -DartifactId=liferay-maven-plugin -Dpackaging=jar -Dversion=6.2.0-RC5 -Dfile=liferay-maven-plugin-6.2.0-RC5.jar -DgeneratePom=true
call mvn install:install-file -DgroupId=org.codehaus.plexus -DartifactId=plexus-utils -Dpackaging=jar -Dversion=1.1 -Dfile=plexus-utils-1.1.jar -DgeneratePom=true
call mvn install:install-file -DgroupId=net.sourceforge.cssparser -DartifactId=cssparser -Dpackaging=jar -Dversion=0.9.11 -Dfile=cssparser-0.9.11.jar -DgeneratePom=true
echo "Fatto!"

echo "Installazione librerie DIOGENE REST CLIENT"
call mvn install:install-file -Dfile=diogene-restclient.jar -DgroupId=it.innovapuglia.diogene.fronttier -DartifactId=diogene-restclient -Dversion=2.1 -Dpackaging=jar
call mvn install:install-file -Dfile=diogene-models-2.0.jar -DgroupId=it.innovapuglia.diogene.middletier -DartifactId=diogene-models -Dversion=2.0 -Dpackaging=jar
echo "Fatto!"

