package com.quiz3.quiz3.dao;

import com.alibaba.fastjson.JSONObject;
import com.quiz3.quiz3.model.Quiz3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Quiz3Dao {
    @Select("SELECT * FROM earthquake")
    List<Quiz3> getEarthquakeList();

    @Select("SELECT latitude,longitude,time,time2,mag,place FROM earthquake WHERE #{small_time2}<=time2 AND time2<=#{large_time2} AND magType=#{mag_type} ORDER BY mag DESC")
    List<Quiz3> searchMagnitude(JSONObject request);

    int countPart1(@Param("mag_type") String mag_type,@Param("small_time2") float small_time2,@Param("large_time2") float large_time2);

    @Update("UPDATE earthquake SET mag=#{mag},place=#{place} WHERE time2=#{time2}")
    void updateEarthquake(JSONObject request);

    @Select("SELECT * FROM earthquake WHERE time2=#{time2}")
    List<Quiz3> searchTime2(JSONObject request);



}
