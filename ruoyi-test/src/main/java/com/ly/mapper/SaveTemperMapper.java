package com.ly.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface SaveTemperMapper {
    @Insert("insert into tempertest (Temp1,Temp2,Temp3,Temp4,Temp5,Temp6,Temp7,Temp8,Temp9,Temp10) values (#{Temp1},#{Temp2},#{Temp3},#{Temp4},#{Temp5},#{Temp6},#{Temp7},#{Temp8},#{Temp9},#{Temp10});")
    public int addTemperValue(@Param("Temp1") Integer Temp1, @Param("Temp2") Integer Temp2, @Param("Temp3") Integer Temp3,
                              @Param("Temp4") Integer Temp4, @Param("Temp5") Integer Temp5, @Param("Temp6") Integer Temp6, @Param("Temp7") Integer Temp7
            , @Param("Temp8") Integer Temp8, @Param("Temp9") Integer Temp9, @Param("Temp10") Integer Temp10
    );
}
