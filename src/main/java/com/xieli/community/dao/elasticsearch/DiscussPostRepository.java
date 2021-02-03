package com.xieli.community.dao.elasticsearch;

import com.xieli.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xieli on 2021/2/3.
 */

@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost,Integer> {

}
