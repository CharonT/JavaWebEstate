use estate;
CREATE TABLE  role(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    code VARCHAR(255) NOT NULL
	
);

CREATE TABLE  user(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    fullname VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL

);

CREATE TABLE  rentarea(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
   value int NOT NULL,
   buildingid bigint NOT NULL

);

CREATE TABLE  assignmentbuilding(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
   staffid bigint NOT NULL,
   buildingid bigint NOT NULL

);

CREATE TABLE  buidling(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(255)  NULL,
   ward VARCHAR(255)  NULL,
   street VARCHAR(255) NULL,
   structure VARCHAR(100) NULL,
   numberofbasement INT NULL,
   floorarea INT NULL,
   direction VARCHAR(255) NULL,
   rank VARCHAR(255) NULL,
   rentareadescription TEXT NULL,
   rentcost INT NULL,
   costdescription TEXT NULL,
    servicecost VARCHAR(255) NULL,
	carcost VARCHAR(255) NULL,
	motorcost VARCHAR(255) NULL,
	overtimecost VARCHAR(255) NULL,
	electricbill VARCHAR(255) NULL,
	deposit VARCHAR(255) NULL,
	payment VARCHAR(255) NULL,
	timerent VARCHAR(255) NULL,
	timedecorator VARCHAR(255) NULL,
	managername VARCHAR(255) NULL,
	managerphone VARCHAR(255) NULL, 
    district VARCHAR(255) NULL,
   type TEXT NULL
);

CREATE TABLE  user_role(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
   userid bigint NOT NULL,
   roleid  bigint NOT NULL

);
CREATE TABLE  usertracking(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    fullname VARCHAR(255) NOT NULL,
    action VARCHAR(255) NOT NULL,
    createddate DATETIME NULL
	
);
CREATE TABLE  buidlingtracking(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(255)  NULL,
   ward VARCHAR(255)  NULL,
   street VARCHAR(255) NULL,
   structure VARCHAR(100) NULL,
   numberofbasement INT NULL,
   floorarea INT NULL,
   direction VARCHAR(255) NULL,
   rank VARCHAR(255) NULL,
   rentareadescription TEXT NULL,
   rentcost INT NULL,
   costdescription TEXT NULL,
    servicecost VARCHAR(255) NULL,
	carcost VARCHAR(255) NULL,
	motorcost VARCHAR(255) NULL,
	overtimecost VARCHAR(255) NULL,
	electricbill VARCHAR(255) NULL,
	deposit VARCHAR(255) NULL,
	payment VARCHAR(255) NULL,
	timerent VARCHAR(255) NULL,
	timedecorator VARCHAR(255) NULL,
	managername VARCHAR(255) NULL,
	managerphone VARCHAR(255) NULL, 
    district VARCHAR(255) NULL,
	type TEXT NULL,
    action VARCHAR(255) NOT NULL,
      createddate DATETIME NULL
);
CREATE TABLE  rentareatracking(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
   value int NOT NULL,
   buildingid bigint NOT NULL,
    action VARCHAR(255) NOT NULL,
      createddate DATETIME NULL
);
CREATE TABLE  assignmentbuildingtracking(
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
   staffid bigint NOT NULL,
   buildingid bigint NOT NULL,
     action VARCHAR(255) NOT NULL,
      createddate DATETIME NULL

);
ALTER TABLE user_role
 ADD FOREIGN KEY (userid) REFERENCES user(id);
 
 ALTER TABLE user_role
 ADD FOREIGN KEY (roleid) REFERENCES role(id);
 
 ALTER TABLE rentarea
 ADD FOREIGN KEY (buildingid) REFERENCES building(id);

ALTER TABLE assignmentbuilding
 ADD FOREIGN KEY (buiding) REFERENCES user(id);


ALTER TABLE role
ADD createddate DATETIME NULL,ADD  modifieddate DATETIME NULL, ADD  createdby VARCHAR(255)  NULL,ADD  modifiedby VARCHAR(255) NULL ;

ALTER TABLE user
ADD createddate DATETIME NULL,ADD modifieddate DATETIME NULL, ADD createdby VARCHAR(255)  NULL,ADD modifiedby VARCHAR(255) NULL ;

ALTER TABLE user_role
ADD createddate DATETIME NULL,ADD modifieddate DATETIME NULL, ADD createdby VARCHAR(255)  NULL,ADD modifiedby VARCHAR(255) NULL ;

ALTER TABLE building
ADD createddate DATETIME NULL,ADD modifieddate DATETIME NULL, ADD createdby VARCHAR(255)  NULL,ADD modifiedby VARCHAR(255) NULL ;

ALTER TABLE rentarea
ADD createddate DATETIME NULL,ADD modifieddate DATETIME NULL, ADD createdby VARCHAR(255)  NULL,ADD modifiedby VARCHAR(255) NULL ;

ALTER TABLE assignmentbuilding
ADD createddate DATETIME NULL,ADD modifieddate DATETIME NULL, ADD createdby VARCHAR(255)  NULL,ADD modifiedby VARCHAR(255) NULL ;

