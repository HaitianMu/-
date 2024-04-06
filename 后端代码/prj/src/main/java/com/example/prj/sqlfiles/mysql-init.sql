create database if not exists companyCredit;
use companyCredit;

create table userInfo (
	uid int,
    username varchar(64),
    password varchar(64),
    isManager int
);

create table companybaseInfo(
	creditNumber varchar(255), 
    stockNumber varchar(255), 
    fullName varchar(255),
    briefName varchar(255),
    legalRepresentative varchar(255),
    industryClassification varchar(255),
    listingDate varchar(255),
    area varchar(255),
    registerationAddress varchar(255),
    registrationDate varchar(255),
    registeredAssets varchar(255),
    mainProducts varchar(255),
    
    businessIncome double,
    businessProfit double,
    pureProfit double,
    undistributedProfit double,
    totalAssets double,
    totalDebt double,
    pureAssets double,
    profitPerShare double
);

create table companyLeaders(
	stockNumber varchar(255),
    fullName varchar(255),
    level int,
    position varchar(255),
    personName varchar(255)
);

create table shareHolders(
	stockNumber varchar(255),
    fullName varchar(255),
    rank1 int,
    holderName varchar(255),
    holdAmount varchar(255),
    holdRate double
);

create table creditInfo(
	fullName varchar(255),
	creditNumber varchar(255),
    recordNumber varchar(255),
    attention int,
    recordTime varchar(255),
    area varchar(255)
);

create table focusList(
	uid int,
    stockNumber varchar(50),
    fullName varchar(50)
);

create table updateTime(
	latestUpdateTime varchar(50)
);


