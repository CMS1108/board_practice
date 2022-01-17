package edu.dnslab.boardpractice.controller;

import edu.dnslab.boardpractice.domain.Member;
import edu.dnslab.boardpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardController {
    private final MemberRepository memberRepository;

    @PostMapping("/write")
    public Member addArticle(@RequestBody Member member){
        return memberRepository.save(member);
    }

    @PutMapping("/update")
    public Member updateArticle(@RequestBody Member member){
        return memberRepository.update(member);
    }

    @GetMapping("/article")
    public Member findArticleById(@RequestParam int id){
        return memberRepository.findById(id);
    }
    @GetMapping("/list")
    public List<Member> allArticle(){
        return memberRepository.findAll();
    }

    @DeleteMapping("/delete")
    public String deleteArticleById(@RequestParam int id){
        return memberRepository.deleteById(id);
    }
}
