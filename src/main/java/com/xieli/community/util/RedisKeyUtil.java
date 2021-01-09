package com.xieli.community.util;

/**
 * Created by xieli on 2021/1/8.
 */

public class RedisKeyUtil {

    public static final String SPLIT = ":";
    public static final String PREFIX_ENTITY_LIKE = "like:entity";

    // 某个实体的赞
    // like:entity:entityType:entityId
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

}
