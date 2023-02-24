package com.ly.service;

import com.ly.mapper.SaveTemperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface addTemperService {
    public int addTemper(String name,Integer value);
}
