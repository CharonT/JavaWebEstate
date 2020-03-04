USE estate;
ALTER TABLE rentarea DROP  FOREIGN KEY rentarea_ibfk_1;
ALTER TABLE rentarea ADD FOREIGN KEY (buildingid) REFERENCES building(id) ON DELETE CASCADE;

ALTER TABLE assignmentbuilding DROP  FOREIGN KEY assignmentbuilding_ibfk_2;
ALTER TABLE assignmentbuilding ADD FOREIGN KEY (buildingid) REFERENCES building(id) ON DELETE CASCADE;

DELETE FROM building WHERE  id=4;