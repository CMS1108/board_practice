package edu.dnslab.boardpractice.controller;

import edu.dnslab.boardpractice.domain.Member;
import edu.dnslab.boardpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardController {
    private final MemberRepository memberRepository;

    @GetMapping("/list")
    public List<Member> apiListPage(){
        List<Member> member = new ArrayList<>();
        memberRepository.findAll().forEach(i -> member.add(i));
        return member;
    }

}
