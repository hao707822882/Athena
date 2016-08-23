package com.boom.athena.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/4/25.
 */
@Service
public class ObjectMapperService {

    private Logger logger = LoggerFactory.getLogger(ObjectMapperService.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    }

    public <T> T convert(String msg, Class<T> type) {
        try {
            return objectMapper.readValue(msg, type);
        } catch (Exception e) {
            logger.error("objectMapper convert msg error ¡¾{}¡¿", msg, e);
            return null;
        }
    }


    public String serialize(Object msg) {
        try {
            return objectMapper.writeValueAsString(msg);
        } catch (Exception e) {
            logger.error("objectMapper convert msg error ¡¾{}¡¿", msg, e);
            return null;
        }
    }


}
