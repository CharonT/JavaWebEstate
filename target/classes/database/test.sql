use estate;
select * from building b 
 where
LOWER(b.name) like LOWER('%building%')
and ((b.type like '%TANG_TRET%') or (b.type like '%NOI_THAT%'))
and exists (select * from rentarea ra where (b.id = ra.buildingid and ra.value >=500));

SELECT * FROM building A WHERE 1=1  AND LOWER(A.name) LIKE LOWER('%building%') AND EXISTS (SELECT * FROM rentarea ra WHERE (A.id = ra.buildingid AND ra.value >= 500)) and ((A.type LIKE '%TANG_TRET%') or (A.type LIKE '%NOI_THAT%'));

SELECT * FROM building A WHERE 1=1  AND LOWER(A.name) LIKE LOWER('%acsadasdas%');

UPDATE  building
SET name = 'Phước Thành Tower', street = 'Tô Ký';
