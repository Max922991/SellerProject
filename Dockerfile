FROM openjdk:17
ADD /target/SellerProject-0.0.1-SNAPSHOT.jar seller.jar
ENTRYPOINT ["java", "-jar", "seller.jar"]