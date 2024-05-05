package com.study.elasticsearch.service;

import com.study.elasticsearch.dto.Member;
import com.study.elasticsearch.repository.MemberSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MemberSearchService {
    @Autowired private MemberSearchRepository memberSearchRepository;

    public Member save(Member member) {
        return memberSearchRepository.save(member);
    }

    public List<Member> findAll() {
        Page<Member> page = memberSearchRepository.findAll(Pageable.unpaged());
        return page.getContent();
    }

    public List<Member> searchAddableMembers(String keyword, Member member) {
        return memberSearchRepository.findByNicknameContainsIgnoreCase(keyword).stream()
                .filter(memberDocument -> !Objects.equals(memberDocument.getId(), member.getId()))
                .map(memberDocument -> new Member(memberDocument.getId(), memberDocument.getNickname(), memberDocument.getProfilePath()))
                .collect(Collectors.toList());
    }

}
