FROM  jeremygilbert/centos-java

RUN  mkdir -p /home/jeremy/docker
WORKDIR  /home/jeremy/docker

ADD target/docker-spring-boot-0.0.1-SNAPSHOT.jar /home/ibest/docker/app.jar
ADD target/classes/application.yml  /home/ibest/docker

ENTRYPOINT ["java","-jar","/home/ibest/docker/app.jar"]

EXPOSE 8809