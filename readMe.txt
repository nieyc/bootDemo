spring-boot2.0 mvc demo
-redis集群查看分支：redisCluster-demo
-多数据源分支：multi-datasource
-读写分离分支：dynamic-datasource

打包:
mvn clean package -Dmaven.test.skip=true
运行：
java -jar bootDemo-0.0.1-SNAPSHOT.jar

进程压倒后台运行：
#nohup java -jar bootDemo-0.0.1-SNAPSHOT.jar &
nohup java -jar bootDemo-1.0-SNAPSHOT.jar >log.file 2>&1 &

 查看进程
ps -ef|grep java
ps -aux | grep spring

