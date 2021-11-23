# 数据库设计
## table
Staff：{

StaffId, username,password, truename, phone, email, departmentId

} 
StaffSalary {

StaffId,month,postwage,meritpay,senioritypay,subsidy,payed

}

department{

departmentId,name,parentId

}

adminstrator{

managerId,username,password,truename

}

```sql
create schema SalarySystem;
create table department
(
        departmentId int auto_increment
        primary key,
        name         varchar(20) not null,
        parentId     int         null,
        floor        int         not null
);

create table staff
(
	staffId int auto_increment,
	username varchar(20) not null,
	password varchar(20) not null,
	truename varchar(20) not null,
	phone char(11) null,
	email varchar(30) null,
	departmentId int null,
	constraint staff_pk
		primary key (staffId),
	constraint staff_department_departmentId_fk
		foreign key (departmentId) references department (departmentId)
);

create table staffSalary
(
	staffId int not null,
	month int not null,
	postwage double null,
	meritpay double null,
	senioritypay double null,
	subsidy double null,
	payed boolean not null,
	constraint staffSalary_pk
		primary key (staffId, month)
);

create table administrator
(
	managerId int auto_increment,
	username varchar(20) not null,
	password varchar(20) not null,
	truename varchar(20) not null,
	constraint administrator_pk
		primary key (managerId)
);

INSERT INTO salarysystem.department (name, parentId) VALUES ('西工大', null)
INSERT INTO salarysystem.department (name, parentId) VALUES ('财务处', null)
INSERT INTO salarysystem.department (name, parentId) VALUES ('教务处', null)
INSERT INTO salarysystem.department (name, parentId) VALUES ('校内财务', null)
INSERT INTO salarysystem.department (name, parentId) VALUES ('校外财务', null)
INSERT INTO salarysystem.department (name, parentId) VALUES ('本科教务', null)
INSERT INTO salarysystem.department (name, parentId) VALUES ('研究生教务', null)

UPDATE salarysystem.department t SET t.parentId = 3 WHERE t.departmentId = 6
UPDATE salarysystem.department t SET t.parentId = 3 WHERE t.departmentId = 7
UPDATE salarysystem.department t SET t.parentId = 2 WHERE t.departmentId = 4
UPDATE salarysystem.department t SET t.parentId = 2 WHERE t.departmentId = 5

INSERT INTO salarysystem.administrator (username, password, truename) VALUES ('root1', '123456', 'wqy')
INSERT INTO salarysystem.administrator (username, password, truename) VALUES ('root2', '123456', 'yym')
INSERT INTO salarysystem.administrator (username, password, truename) VALUES ('root3', '123456', 'syk')
INSERT INTO salarysystem.administrator (username, password, truename) VALUES ('root4', '123456', 'whj')

INSERT INTO salarysystem.staff (username, password, truename, phone, email, departmentId) VALUES ('user1', '123456', 'zed', null, null, 1)
INSERT INTO salarysystem.staff (username, password, truename, phone, email, departmentId) VALUES ('user2', '123456', 'jinx', null, null, 2)
INSERT INTO salarysystem.staff (username, password, truename, phone, email, departmentId) VALUES ('user3', '123456', 'vi', null, null, 3)
INSERT INTO salarysystem.staff (username, password, truename, phone, email, departmentId) VALUES ('user4', '123456', 'jazz', null, null, 4)
INSERT INTO salarysystem.staff (username, password, truename, phone, email, departmentId) VALUES ('user5', '123456', 'victor', null, null, 5)
INSERT INTO salarysystem.staff (username, password, truename, phone, email, departmentId) VALUES ('user6', '123456', 'ekko', null, null, null)
```



