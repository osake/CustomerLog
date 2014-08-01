CustomerLog
===========

Project MenuApp used archetype:
mvn archetype:generate -DgroupId=com.sunRays -DartifactId=MenuApp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

What is One-To-Many Association?
One-to-many relationships occur when each record in TableA may have many linked records in TableB but each record in TableB may have only one corresponding record in TableA.


Create DB & Table:
---------------------
mysql -u root -p sunRays <Enter>

CREATE TABLE customer
(
custId int NOT NULL AUTO_INCREMENT,
custName varchar(255),
contactNo varchar(255),
PRIMARY KEY ( custId )
);

CREATE TABLE customerDetails
(
addressId int NOT NULL AUTO_INCREMENT,
custId int ,
address varchar(255),
pincode varchar(255),
PRIMARY KEY ( addressId ),
FOREIGN KEY (custId) REFERENCES customer(custId)
);


mysql> insert into customer values('101','Sunil Gupta','9820177118');
mysql> insert into customerdetails values('1','101','pune','411057');
mysql> insert into customerdetails values('2','101','mumbai','400076');

mysql> select * from customer a join customerdetails b on a.custid=b.custid;
+--------+-------------+------------+-----------+--------+---------+---------+
| custId | custName    | contactNo  | addressId | custId | address | pincode |
+--------+-------------+------------+-----------+--------+---------+---------+
|    101 | Sunil Gupta | 9820177118 |         1 |    101 | pune    | 411057  |
|    101 | Sunil Gupta | 9820177118 |         2 |    101 | mumbai  | 400076  |
+--------+-------------+------------+-----------+--------+---------+---------+
2 rows in set (0.00 sec)