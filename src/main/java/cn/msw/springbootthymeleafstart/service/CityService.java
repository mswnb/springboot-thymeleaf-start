package cn.msw.springbootthymeleafstart.service;

import cn.msw.springbootthymeleafstart.bean.City;

/**
 * @Author 毛送文
 * @Date 2021/1/24 19:23
 * @Version 1.0
 */
public interface CityService {
    City getCityById(Long id);
    void saveCity(City city);
}
