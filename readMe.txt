spring-boot2.0 mvc demo

打包:
mvn clean package -Dmaven.test.skip=true
运行：
java -jar bootDemo-0.0.1-SNAPSHOT.jar

进程压倒后台运行：
nohup java -jar bootDemo-0.0.1-SNAPSHOT.jar &

服务端运行：
上传jar包到服务器，假设部署路径为 /opt/springBoot-test.jar ，使用命令做一个软连接到 /etc/init.d 目录，myapp是服务别名，命令：
 ln -s /opt/springBoot-test.jar /etc/init.d/myapp
 启动:
 service myapp start
 停止:
 service myapp stop
 查看状态:
 service myapp status
 
 查看进程
ps -ef|grep java
ps -aux | grep spring

