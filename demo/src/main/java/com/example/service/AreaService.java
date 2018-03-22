package com.example.service;

import com.example.domain.Area;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AreaService {
    Area getAreaByAreaId(Integer areaId);

    List<Area> getAreaList();

    boolean addArea(Area area);

    boolean modifyArea(Area area);

    boolean deleteArea(Integer areaId);
}
