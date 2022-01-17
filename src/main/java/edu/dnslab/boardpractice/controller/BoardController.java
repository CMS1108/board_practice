package edu.dnslab.boardpractice.controller;

import edu.dnslab.boardpractice.domain.Member;
import edu.dnslab.boardpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
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

    @GetMapping
    public String showFirstPage(Model model){
        List<Member> member = new ArrayList<>();

    }
}
