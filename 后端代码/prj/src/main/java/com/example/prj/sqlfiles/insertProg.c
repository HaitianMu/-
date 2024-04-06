#include <string.h>
#include <assert.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
//
//#include<iostream>
//#include<cstdio>
//#include<cstring>
//using namespace std;


int main(int argc,char* argv[]){
	char seq1[1000] = "/opt/model/sqoop1/bin/sqoop export --connect jdbc:mysql://rm-cn-4xl3d2aea000kz1o.rwlb.rds.aliyuncs.com/companydata --username root1 --password 09CloudDB --table ";
	char que1[1000];
	
	char seq2[100] = " --export-dir ";
	char que2[1000];
	
	char seq3[100] = " --input-fields-terminated-by '\\t' ";
	
	char col[100];
	char seq4[100] = "--columns ";
	char que3[1000];
	
	char seq5[1000] = "hdfs dfs -put ";
	char res1[1000],res2[1000];
	
	printf("Please input the name of the table you want to insert to:\n");
	scanf("%s",que1);
	
	printf("The absolute path of your data source file:\n");
	scanf("%s",que2);
	
	strcat(res1,seq5);
	strcat(res1,que2);
	strcat(res1," ");
	strcat(res1,que2);
	
	strcat(res2,seq1);
	strcat(res2,que1);
	strcat(res2,seq2);
	strcat(res2,que2);
	strcat(res2,seq3);
	
	
	printf("Want to self-define columns correspondence? (y/n):\n");
	scanf("%s",col);
	if(col[0]=='y' || col[0]=='Y'){
		printf("Input your columns, in the order of columns in your source file:\n");
		scanf("%s",que3);
		strcat(res2,seq4);
		strcat(res2,que3);
	}
	
	int fdbk1 = system(res1);
	int fdbk2 = system(res2);
//	printf("%s\n\n",res1);
//	printf("%s\n",res2);
	if(fdbk1!=-1 && fdbk2 != -1) printf("Task success!\n");
	
	return 0;
}
