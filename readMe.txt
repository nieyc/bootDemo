打包:
mvn clean package -Dmaven.test.skip=true
运行：
java -jar bootDemo-0.0.1-SNAPSHOT.jar

进程压倒后台运行：
nohup java -jar bootDemo-0.0.1-SNAPSHOT.jar &
