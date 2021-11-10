FROM openjdk:8u191-jre-alpine3.8
WORKDIR /usr/share/teste
ADD target/testcomseleniumjunit.jar testcomseleniumjunit.jar
ADD target/testcomseleniumjunit-tests.jar testcomseleniumjunit-tests.jar
ADD target/libs libs
ADD src/test/resources/loginttest.xml loginttest.xml
ENTRYPOINT java -cp testcomseleniumjunit.jar;testcomseleniumjunit-tests.jar;C:/Projectos/testcomseleniumjunit/target/libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
