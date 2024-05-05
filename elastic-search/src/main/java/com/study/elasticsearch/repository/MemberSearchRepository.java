package com.study.elasticsearch.repository;

import com.study.elasticsearch.dto.Member;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberSearchRepository extends ElasticsearchRepository<Member, Long> {
    List<Member> findByNicknameContainsIgnoreCase(String nickname);
}
