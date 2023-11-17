#### push-sdk
推送消息SDK

#####  修改版本号流程

1.  只更新父模块的版本号;
	```shell
	mvn versions:set -DnewVersion=2.0.0-SNAPSHOT
	```
2.  更新子模块和父模块一样的版本号;
	```shell
	mvn -N versions:update-child-modules
	```
3.  提交更新
	```shell
	mvn versions:commit
	```

#####  发布版本流程

1. 修改 parent version 版本号；

2. 参考修改版本号流程，修改 version 版本号；

3. 修改 commons.version 版本号； 

4. 修改 push.version 版本号； 

5. 执行命令
	```shell
	mvn clean deploy -Possrh
	```
