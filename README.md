## 测试

生成dao: 

-Dmybatis.generator.overwrite=true mybatis-generator:generate

## 部署

目录: /root/app/publicAccount

- 下载远程目录文件: 

  scp -r root@www.vpser.net:/user/local/  /home/test/

- 上传本地文件

   scp -r /Users/guangzhong.wgz/antWorkSpace/WxPublicAccount/webapp/target/publicAccount.jar root@116.62.101.237:/root/app/publicAccount


## 应用启动

  nohup 
  
  java -jar wxp-proxy.jar -Xms4g -Xmx4g -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m -Xmn2g -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSMaxAbortablePrecleanTime=5000 -XX:+CMSClassUnloadingEnabled -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=80 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/root/appHome/logs/heapdump.hprof -Xloggc:/root/appHome/logs/gc.log -XX:ErrorFile=java_error_%p.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Djava.awt.headless=true -Dsun.net.client.defaultConnectTimeout=10000 -Dsun.net.client.defaultReadTimeout=30000 -XX:MaxDirectMemorySize=1g -XX:SurvivorRatio=10 -XX:+ExplicitGCInvokesConcurrent -Dsun.rmi.dgc.server.gcInterval=2592000000 -Dsun.rmi.dgc.client.gcInterval=2592000000 -XX:ParallelGCThreads=4 -Dfile.encoding=GB18030 -Dhsf.publish.delayed=true -Dproject.name=wxp-proxy -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n -Djava.io.tmpdir=/root/appHome/log/.default/temp -Dspring.profiles.active=prd