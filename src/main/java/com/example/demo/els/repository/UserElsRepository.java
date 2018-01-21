package com.example.demo.els.repository;

import com.example.demo.domain.els.UserEls;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserElsRepository  extends ElasticsearchRepository<UserEls, String> {
}
