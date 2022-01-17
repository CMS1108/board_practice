package edu.dnslab.boardpractice.controller;

import edu.dnslab.boardpractice.domain.Member;
import edu.dnslab.boardpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/article/{id}")
    public Member findArticleById(@PathVariable int id){
        return memberRepository.findById(id);
    }
    @GetMapping("/list")
    public List<Member> allArticle(){
        return memberRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticleById(@PathVariable int id){
        return memberRepository.deleteById(id);
    }
}
