package com.phuocthanh.repository.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.phuocthanh.annotation.Column;
import com.phuocthanh.annotation.Table;
import com.phuocthanh.builder.BuildingSearchBuilder;
import com.phuocthanh.dto.BuildingDTO;
import com.phuocthanh.entity.BuildingEntity;
import com.phuocthanh.repository.IBuildingRepository;

public class BuildingRepository extends SimpleJpaRepository<BuildingEntity> implements IBuildingRepository {

	@Override
	public List<BuildingEntity> findAll(Map<String,Object> params,BuildingSearchBuilder builder) {
		
		StringBuilder sql=new StringBuilder("SELECT * FROM building A ");
		if(builder.getStaffId()!=null && builder.getStaffId()!=-1) {
			sql.append(" INNER JOIN assignmentbuilding ab on b.id = ab.buildingid");
		}
		sql.append("WHERE 1=1 ");
		sql=this.createSQLFindAllCommon(sql, params);
		sql=createSQLspecial(sql,builder);
		return this.findAll(sql.toString());
	}
//	private StringBuilder createSQLFindAllCommon(StringBuilder sql,Map<String,Object> params) {
////		if(builder.getName()!=null) {
////			sql.append(" AND b.name LIKE '%"+builder.getName()+"%'");
////		}
////		if(builder.getDistrict()!=null) {
////			sql.append(" AND b.district LIKE '%"+builder.getDistrict()+"%'");
////		}
////		if(builder.getNumberOfBasement()!=null) {
////			sql.append(" AND b.numberofbasement = "+builder.getNumberOfBasement()+"");
////		}
////		if(builder.getFloorArea()!=null) {
////			sql.append(" AND b.floorarea = "+builder.getFloorArea()+"");
////		}
//		
//		if(params!=null && params.size()>0) {
//			String[] keys=new String[params.size()];
//			Object[] values=new Object[params.size()];
//			int i=0;
//			for(Map.Entry<String, Object> item:params.entrySet()) {
//				keys[i]=item.getKey();
//				values[i]=item.getValue();
//				i++;
//				
//				
//			}
//			for(int i1=0;i1<keys.length;i1++) {
//				if(values[i1] instanceof String) {
//					if(StringUtils.isNoneBlank(values[i1].toString())) {
//						sql.append(" AND LOWER(b."+keys[i1]+")"+" LIKE LOWER('%"+values[i1].toString()+"%')");
//					}
//					
//				}else {
//					if(values[i1]!=null){
//						sql.append(" AND b."+keys[i1]+" = "+values[i1]+"");
//					}
//				}
//			}
//			
//		}
//		return sql;
//	}

	private StringBuilder createSQLspecial(StringBuilder sql, BuildingSearchBuilder builder) {
		if(StringUtils.isNotBlank(builder.getRentAreaFrom()) || StringUtils.isNotBlank(builder.getRentAreaTo())) {
			sql.append(" AND EXISTS (SELECT * FROM rentarea ra WHERE (A.id = ra.buildingid");
			if(StringUtils.isNotBlank(builder.getRentAreaFrom())){
				sql.append(" AND ra.value >= "+builder.getRentAreaFrom()+"");
			}
			if(StringUtils.isNotBlank(builder.getRentAreaTo())) {
				sql.append(" AND ra.value <= "+builder.getRentAreaTo()+"");
			}
			sql.append("))");
		}
		//java 7
		/*if(builder.getTypes().length>0) {
			sql.append(" and (");
			for(String type:builder.getTypes()) {
				if(type.equals(builder.getTypes()[0])) {
					sql.append("A.type LIKE '%"+type+"%'");
				}else {
					sql.append(" or A.type LIKE '%"+type+"%'");
				}
			}
			sql.append(")");
		}*/
		if(builder.getTypes().length>0) {
			sql.append(" and (");
			String sqlType=Arrays.stream(builder.getTypes()).map(item -> "(A.type LIKE '%"+item+"%')").collect(Collectors.joining(" or "));
			sql.append(sqlType);
			sql.append(")");
		}
		if(StringUtils.isNotBlank(builder.getRentCostFrom())) {
			sql.append(" AND A.rentcost >= "+builder.getRentCostFrom()+"");
			
		}
		if(StringUtils.isNotBlank(builder.getRentCostTo())) {
			sql.append(" AND A.rentcost <= "+builder.getRentCostTo()+"");
			
		}
		if(builder.getStaffId()!=null && builder.getStaffId()!=-1) {
			sql.append(" AND ab.staffid = "+builder.getStaffId()+"");
		}
		return sql;
	}

}
