@echo off
@echo "开始启动jetty..."
cd %~dp0
cd ..
set CLASSPATH=D:\workspace\java\bos\avm-bootstrap\target\avm-bootstrap-1.0.1-SNAPSHOT\avm-bootstrap-1.0.1-SNAPSHOT\lib
set ARCHFORCE_DOMAIN_URL=j64IpHGT+wzg1GGMErGwZI0H//RBNMSPr7UM4VuNRzGSIwA6gZkBX1AJ5rZ9/6qvBQJrS1Y7VOXcUZyYHpCUlduIT6riFL9ocdz0mBWdXKl9u9qsOza/yFN7wL6yjrOL;
set APP_NAME=TSM;
set INSTANCE_NAME=BOS_1_1_11;
set ARCHFORCE_DOMAIN_ENC=false;
set BASE_LOG_PATH=D/test/log/
start /b java -jar avm-bootstrap-1.0.1-SNAPSHOT.jar #后台持续运行
@echo "jetty启动成功！"
exit