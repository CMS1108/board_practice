package edu.dnslab.boardpractice.controller;

import edu.dnslab.boardpractice.domain.Member;
import edu.dnslab.boardpractice.repository.MemberRepository;
import edu.dnslab.boardpractice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/write")
    public Member addArticle(@RequestBody Member member){
        return boardService.addArticle(member);
    }

    @PutMapping("/update")
    public Member updateArticle(@RequestBody Member member){
        return boardService.updateArticle(member);
    }

    @GetMapping("/article/{id}")
    public Member findArticleById(@PathVariable int id){
        return boardService.findArticleById(id);
    }
    @GetMapping("/list")
    public List<Member> allArticle(){
        return boardService.allArticle();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticleById(@PathVariable int id){
        return boardService.deleteArticleById(id);
    }
}
