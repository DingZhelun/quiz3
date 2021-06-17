package com.quiz3.quiz3.controller;

import com.alibaba.fastjson.JSONObject;
import com.quiz3.quiz3.service.Quiz3Service;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/earthquake")
public class Quiz3Controller {
    @Autowired
    private Quiz3Service quiz3Service;

    @RequestMapping(value = "/earthquakeList", method = RequestMethod.GET)
    public JSONObject getPeopleList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return quiz3Service.getEarthquakeList(pageNum, pageSize);
    }

    @RequestMapping(value = "/searchMagnitude",method = RequestMethod.POST)
    public JSONObject searchMagnitude(@RequestBody JSONObject request){
        return quiz3Service.searchMagnitude(request);
    }

    @RequestMapping(value = "/countPart1",method = RequestMethod.GET)
    public JSONObject countNight(@Param("mag_type") String mag_type, @Param("small_time2") float small_time2, @Param("large_time2") float large_time2){
        return quiz3Service.countPart1(mag_type,small_time2,large_time2);
    }

    @RequestMapping(value = "/updateEarthquake", method = RequestMethod.POST)
    public JSONObject updateEarthquake(@RequestBody JSONObject request) {
        return quiz3Service.updateEarthquake(request);
    }

    @RequestMapping(value = "/searchTime2",method = RequestMethod.POST)
    public JSONObject searchTime2(@RequestBody JSONObject request){
        return quiz3Service.searchTime2(request);
    }

}
