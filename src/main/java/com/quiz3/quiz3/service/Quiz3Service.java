package com.quiz3.quiz3.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface Quiz3Service {

    JSONObject getEarthquakeList(int pageNum, int pageSize);

    JSONObject searchMagnitude(JSONObject request);

    JSONObject countPart1(String mag_type, float small_time2, float large_time2);

    JSONObject updateEarthquake(JSONObject request);

    JSONObject searchTime2(JSONObject request);

}
