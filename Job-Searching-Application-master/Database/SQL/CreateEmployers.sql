use jobsearch;

create table employers(
employerID int not null auto_increment,
username varchar(10) not null,
password varchar(10) not null,
eName varchar(50) not null,
address varchar(200) not null,
contact varchar(20) not null,
aboutUs varchar(2000) not null,
website varchar(100) not null,
primary key(employerID)
);
