create database if not exists companyCredit;
use companyCredit;

create table if not exists redBaseInfo(
	
	stockNumber varchar(50),
    fullName varchar(50) not null,
    briefName varchar(50),
    legalRepresentative varchar(50),
    industryClass varchar(50),
    listingDate varchar(50),
    area varchar(50),
    businessIncome double,
    
    businessProfit double,
    pureProfit double,
    undistributedProfit double,
    totalAssets double,
    totalDebt double,
    pureAssets double,
    profitPerShare double
)
row format delimited 
fields terminated by '\t';

create table if not exists redExec(
	stockNumber varchar(50),
    fullName varchar(50),
    level int,
    position varchar(50),
    personName varchar(50)
)
row format delimited 
fields terminated by '\t';

create table if not exists redHolder(
	stockNumber varchar(50),
    fullName varchar(50),
    rank int,
    holderName varchar(50),
    holdAmount int,
    holdRate float
)
row format delimited 
fields terminated by '\t';
    
	-- local data local inpath '' into table baseInfo;
    
    
    
    
    
    
    
    
    
    
    
    
    