package edu.dnslab.boardpractice.controller;

import edu.dnslab.boardpractice.domain.Article;
import edu.dnslab.boardpractice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/write")
    public Article addArticle(@RequestBody Article article){
        return boardService.addArticle(article);
    }

    @PutMapping("/update")
    public Article updateArticle(@RequestBody Article article){
        return boardService.updateArticle(article);
    }

    @GetMapping("/article/{id}")
    public Article findArticleById(@PathVariable int id){
        return boardService.findArticleById(id);
    }
    @GetMapping("/list")
    public List<Article> allArticle(){
        return boardService.allArticle();
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteArticleById(@PathVariable int id){
        return boardService.deleteArticleById(id);
    }
}
