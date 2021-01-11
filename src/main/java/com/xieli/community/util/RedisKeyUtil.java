package com.xieli.community.util;

/**
 * Created by xieli on 2021/1/8.
 */

public class RedisKeyUtil {

    public static final String SPLIT = ":";
    public static final String PREFIX_ENTITY_LIKE = "like:entity";
    public static final String PREFIX_USER_LIKE = "like:user";
    public static final String PREFIX_FOLLOWEE = "followee";
    public static final String PREFIX_FOLLOWER = "follower";

    // 某个实体的赞
    // like:entity:entityType:entityId
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    // 某个用户的赞
    // like:user:userId
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER_LIKE + SPLIT + userId;
    }

    // 某个用户关注的实体
    // followee:userId:entityType -> zet(entityId,now)
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    // 某个实体拥有的粉丝
    // follower:entityType:entityId -> zet(userId,now)
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }

}
