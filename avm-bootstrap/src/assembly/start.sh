#!/bin/sh
baseDirForScriptSelf=$(cd "$(dirname "$0")"; pwd)
echo "full path to currently executed script is : ${baseDirForScriptSelf}"
cd ${baseDirForScriptSelf}
source ./setenv.sh
export $(cut -d= -f1 ${baseDirForScriptSelf}/setenv.sh |grep -v '^#')
cd ../lib
java -jar avm-bootstrap-1.0.1-SNAPSHOT.jar
