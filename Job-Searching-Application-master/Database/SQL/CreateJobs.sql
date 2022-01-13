use jobsearch;

create table jobs(
jobID int not null auto_increment,
employerID int not null,
title varchar(50) not null,
city varchar(20) not null,
address varchar(200) not null,
numOfPosition int unsigned not null,
description varchar(2000) not null,
qualification varchar(2000) not null,
postingDate varchar(100) not null,
closingDate varchar(100) not null,
note varchar(1000),
primary key(jobID),
foreign key(employerID) REFERENCES employers(employerID)
);
