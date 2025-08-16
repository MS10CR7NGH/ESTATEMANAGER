package com.javaweb.repository.custom.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public void querySqlJoin(BuildingSearchBuilder builder, StringBuilder join) {
        Long staffId= builder.getStaffId();
        if (staffId != null) {
            join.append(" INNER JOIN assignmentbuilding asb ON b.id = asb.buildingid");
        }

        Long rentAreaFrom = builder.getRentAreaFrom();
        Long rentAreaTo = builder.getRentAreaTo();
        if (rentAreaFrom != null || rentAreaTo != null) {
            join.append(" INNER JOIN rentarea rt ON b.id = rt.buildingid");
        }

    }

    public void queryNormal(BuildingSearchBuilder builder, StringBuilder where) {
        try{
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();//lay ten cac fields cua obj dua vao 1 mang
            for(Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if(!fieldName.equals("staffId") && !fieldName.startsWith("rentPrice")
                        && !fieldName.startsWith("rentArea") && !fieldName.equals("typeCode")) {
                    Object value = item.get(builder);
                    if(value != null && !value.equals("")) {
                        if(item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Integer")) {
                            where.append(" AND b."+ fieldName.toLowerCase() +"= '"+value+"' ");
                        }else if(item.getType().getName().equals("java.lang.String")) {
                            where.append(" AND b."+ fieldName.toLowerCase() +" LIKE '%"+ value + "%' ");
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void querySpecial(BuildingSearchBuilder builder, StringBuilder where) {
        Long rentAreaFrom = builder.getRentAreaFrom();
        Long rentAreaTo = builder.getRentAreaTo();
        if (rentAreaFrom != null || rentAreaTo != null) {
            if(rentAreaFrom != null) {
                where.append(" AND rt.value >= " + rentAreaFrom);
            }
            if(rentAreaTo != null) {
                where.append(" AND rt.value <= " + rentAreaTo);
            }
        }

        Long staffId = builder.getStaffId();
        if (staffId != null) {
            where.append(" AND asb.staffid = " + staffId);
        }

        Long rentPriceFrom = builder.getRentPriceFrom();
        Long rentPriceTo = builder.getRentPriceTo();
        if (rentPriceFrom != null || rentPriceTo != null) {
            if(rentPriceFrom != null) {
                where.append(" AND b.rentprice >= " + rentPriceFrom);
            }
            if(rentPriceTo != null) {
                where.append(" AND b.rentprice <= " + rentPriceTo);
            }
        }

        List<String> typeCode = builder.getTypeCode();
        if (typeCode != null && !typeCode.isEmpty()) {
            where.append(" AND ( ");
            where.append(typeCode.stream().map(item-> " b.type LIKE '%" + item + "%' ").collect(Collectors.joining("OR")));
            where.append(" ) ");
        }
    }

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder builder) {
        List<BuildingEntity> results = new ArrayList<BuildingEntity>();
        StringBuilder sql = new StringBuilder("SELECT b.* FROM building b ");
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        querySqlJoin(builder, sql);
        queryNormal(builder, where);
        querySpecial(builder, where);
        sql.append(where).append(" GROUP BY b.id ");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();

    }
}
