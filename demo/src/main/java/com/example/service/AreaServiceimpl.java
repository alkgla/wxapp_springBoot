package com.example.service;

import com.example.domain.Area;
import com.example.mapper.AreaMapper;
import com.example.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaServiceimpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public Area getAreaByAreaId(Integer areaId) {
        return areaMapper.queryAreaById(areaId);
    }

    @Override
    public List<Area> getAreaList() {
        return areaMapper.queryArea();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaMapper.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("插入区域信息失败！");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            // 修改最后一次修改时间
            area.setLastEditTime(new Date());

            try {
                // 更新区域信息
                int effectedNum = areaMapper.updateArea(area);

                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("修改区域信息失败！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("修改区域信息失败！");
        }
    }

    @Override
    public boolean deleteArea(Integer areaId) {
        if (areaId > 0) {
            try {
                // 删除区域信息
                int effectedNum = areaMapper.deleteAreaById(areaId);

                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("删除区域信息失败！");
        }
    }
}
