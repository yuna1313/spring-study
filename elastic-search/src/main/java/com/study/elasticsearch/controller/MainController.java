package com.study.elasticsearch.controller;

import com.study.elasticsearch.dto.Member;
import com.study.elasticsearch.service.MemberSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    MemberSearchService memberSearchService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(Member member) {
        return "/test";
    }

    @RequestMapping(value = "members/search", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Member> searchKeyword(@RequestParam String keyword, Member member) {
        return memberSearchService.searchAddableMembers(keyword, member);
    }

    @RequestMapping(value = "members/save", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Member saveMember(@RequestBody Member member) {
        return memberSearchService.save(member);
    }

    @RequestMapping(value = "members/get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Member> getMember() {
        return memberSearchService.findAll();
    }
}
