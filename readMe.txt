spring-boot2.0 mvc demo
读写分离多数据源

打包:
mvn clean package -Dmaven.test.skip=true

1个主库，2个从库，所有读操作都走从库，写操作走主库，有些读操作由于有及时性要求，添加注解@Master，也走主库
