package com.example.mapper;

import com.example.domain.Area;

import java.util.List;

public interface AreaMapper {
    List<Area> queryArea();

    Area queryAreaById(Integer areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteAreaById(Integer areaId);
}
