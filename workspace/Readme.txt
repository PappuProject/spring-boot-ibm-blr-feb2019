1. install and setup MySQL with the given schema
username: root
password: root (Change it to suite yours)

Log into mysql terminal/client and execute the following in mysql> prompt:

create database springdb;

use spring db;

CREATE TABLE `emp` (
  `empno` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `emp` VALUES (100,'Amitabh','Mumbai',20000),(101,'Shekhar','Hyderabad',30000),(102,'Rekha','Mumbai',23000),(103,'Kalluram','Delhi',60000),(104,'Ajay','Bangalore',80000);

1. start eureka-server
2. start emp-data-service
3. start hr-service
4. start zuul-proxy

test the applications using the appropriate url 's

Running the given circuit breaker sample

import the circuite breaker sample as maven project
1. run bookstore
2. run reading

use the url : http://localhost:8080/to-read

you will get response from bookstore application.
Now shutdown bookstore application and use the same given url to test the circuite breaker in 'reading' application. As bookstore is down, you will get a fallback message from circuit breaker.
