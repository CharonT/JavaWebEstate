use estate;

INSERT INTO user(username,fullname,password) VALUES 
('phuocthanh','Trần Phước Thành','123456'),
('mylinh','Lê Trần Mỹ Linh','123456'),
('ngocphuc','Trần Thị Ngọc Phúc','123456'),
('phuochai','Trần Phước Hải','123456');

INSERT INTO role(name,code) VALUES
 ('Quản Lý','MANAGER'),
  ('Nhân Viên','STAFF');
  
   
  INSERT INTO building(name,numberofbasement,floorarea,district,ward,street,rentcost,costdescription,managername,managerphone,type) VALUES 
('Nam Giao Building Tower',2,500,'QUAN_1','Phường 2','59 Phan Xích Long',15,'15 triệu/m2','thoa','123456','TANG_TRET,NGUYEN_CAN'),
('ACM Tower',2,650,'QUAN_2','Phường 4','96 Cao Thắng',18,'18 triệu/m2','cÆ°Æ¡ng','123456','NGUYEN_CAN'),
('ALPHA 2 Building Tower',1,200,'QUAN_1','Phường 6','153 Nguyễn Ánh Chiêu',20,'20 triệu/m2','huy','123456','NOI_THAT'),
('IDD 1 Building',1,200,'QUAN_4','Phường 7','111 Lê Chiến Thắng',12,'12 triệu/m2','vy','123456','TANG_TRET,NGUYEUN_CAN,NOI_THAT');

INSERT INTO rentarea(value,buildingid) VALUES
 (100,1),
 (200,1),
(200,2),
(300,2),
(400,2),
(300,3),
(400,3),
(500,3),
(100,4),
(400,4),
(250,4);

INSERT INTO assignmentbuilding(staffid,buildingid) VALUES
 (2,1),
(2,3),
(3,1),
(3,4);
  


  