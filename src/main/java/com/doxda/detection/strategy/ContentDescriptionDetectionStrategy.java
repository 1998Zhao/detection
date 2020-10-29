package com.doxda.detection.strategy;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.doxda.detection.metadate.ContentDescription;
import com.doxda.detection.result.Result;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 内容描述 元数据
 * @author zgq
 */
public class ContentDescriptionDetectionStrategy implements IDetectionStrategy{
    private ContentDescription contentDescription;
    /**
     * 对元数据进行校验
     * @return 校验结果
     */
    @Override
    public Result detection() {
        boolean check = false;
        Map<String ,String> map = new HashMap<String, String>();
        String[] arrays = new String[]{"title","date"};
        int j= 0;
        for (int i = 0; i < arrays.length; i++) {
            if (StrUtil.isBlank(arrays[i])){
                map.put(arrays[i],arrays[i]+"'s value can't be null");
            }
            else {
                j++;
            }
        }
        String date = contentDescription.getDate();
        try {
            Date d =Convert.toDate(date);
        }
        catch (Exception e){
            map.put("date","date 's format is wrong!");
            return new Result(false,map);
        }

        if (j==arrays.length){
            check = true;
        }
        return new Result(check,map);
    }
}
