package cn.msw.springbootthymeleafstart.service.impl;

import cn.msw.springbootthymeleafstart.bean.City;
import cn.msw.springbootthymeleafstart.mapper.CityMapper;
import cn.msw.springbootthymeleafstart.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 毛送文
 * @Date 2021/1/24 16:30
 * @Version 1.0
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    public City getCityById(Long id){
        return cityMapper.getById(id);
    }

    @Override
    public void saveCity(City city) {
        cityMapper.insert(city);

    }
}
