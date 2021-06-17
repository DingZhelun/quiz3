package com.quiz3.quiz3.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quiz3.quiz3.dao.Quiz3Dao;
import com.quiz3.quiz3.model.Quiz3;
import com.quiz3.quiz3.service.Quiz3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "Quiz3Service")
public class Quiz3Impl implements Quiz3Service {
    @Autowired
    private Quiz3Dao quiz3Dao;

    @Override
    public JSONObject getEarthquakeList(int pageNum, int pageSize) {
        JSONObject result = new JSONObject();
        try {
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Quiz3> pageInfo = new PageInfo(quiz3Dao.getEarthquakeList());

            result.put("code", "0");
            result.put("msg", "operation success！");
            result.put("data", pageInfo.getList());
            result.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "query error！");
        }
        return result;
    }

    @Override
    public JSONObject searchMagnitude(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            int pageNum = request.getInteger("pageNum");
            int pageSize = request.getInteger("pageSize");
            PageHelper.startPage(pageNum, pageSize);

            PageInfo<Quiz3> pageInfo = new PageInfo(quiz3Dao.searchMagnitude(request));
//            int num = quiz3Dao.countPart1(request.getString("mag_type"),request.getInteger("small_time2"),request.getInteger("large_time2"));

            result.put("code", "0");
            result.put("msg", "operation success！");
            result.put("data", pageInfo.getList());
            //result.put("num", num);
            result.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "query earthquake error!");
        }
        return result;
    }

    public JSONObject countPart1(String mag_type, float small_time2, float large_time2) {
        JSONObject result = new JSONObject();
        try {
            int num = quiz3Dao.countPart1(mag_type,small_time2,large_time2);

            result.put("code", "0");
            result.put("msg", "operation success！");
            //result.put("num", num);
            result.put("count", num);
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "query earthquake error!");
        }
        return result;
    }

    @Override
    public JSONObject updateEarthquake(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            quiz3Dao.updateEarthquake(request);
            result.put("code", "0");
            result.put("msg", "operation success！");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "update people error!");
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public JSONObject searchTime2(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            int pageNum = request.getInteger("pageNum");
            int pageSize = request.getInteger("pageSize");
            PageHelper.startPage(pageNum, pageSize);

            PageInfo<Quiz3> pageInfo = new PageInfo(quiz3Dao.searchTime2(request));
//            int num = quiz3Dao.countPart1(request.getString("mag_type"),request.getInteger("small_time2"),request.getInteger("large_time2"));

            result.put("code", "0");
            result.put("msg", "operation success！");
            result.put("data", pageInfo.getList());
            //result.put("num", num);
            result.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "query earthquake error!");
        }
        return result;
    }

}
