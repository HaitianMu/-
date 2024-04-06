## 对sqlfiles文件夹下文件的介绍
### 1. hive-init.sql
根据爬虫获取的数据格式，初始化hive数据库

### 2. mysql-init.sql
初始化云端mysql数据库,数据库表的设计解释详见 04文档包-概要设计文档

### 3. insertCommand.txt
利用sqoop将数据从hive导出到mysql的所需命令。文件里介绍了我们从不同数据表中导出数据时的sqoop命令。

### 4. insertProg.c
一个基于c语言的自动化sqoop数据导出程序，
可以将数据从hive导出到mysql。
在hadoop所在linux系统上编译运行该程序，
输入mysql的接收表名、源数据文件在hadoop文件系统上的绝对路径，
程序便可自动将命令拼接完成，交给sqoop执行。

该程序还提供了列名可选项，可以选择是否按指定字段顺序导出数据，并自定义该顺序。
