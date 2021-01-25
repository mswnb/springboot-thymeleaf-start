package cn.msw.springbootthymeleafstart.mapper;

import cn.msw.springbootthymeleafstart.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 毛送文
 * @Date 2021/1/24 16:29
 * @Version 1.0
 */
//@Mapper
public interface CityMapper {
    @Select("select * from city where id=#{id}")
    City getById(Long id);
    @Insert("insert into city(name,state,country) values (#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(City city);
}
