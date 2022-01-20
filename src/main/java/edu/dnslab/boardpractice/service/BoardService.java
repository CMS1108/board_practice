package edu.dnslab.boardpractice.service;


import edu.dnslab.boardpractice.domain.Article;
import edu.dnslab.boardpractice.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final ArticleRepository articleRepository;

    public Article addArticle(Article article){
        return articleRepository.save(article);
    }

    public Article updateArticle(Article article){
        return articleRepository.update(article);
    }

    public Article findArticleById(int id){
        return articleRepository.findById(id);
    }

    public List<Article> allArticle(){
        return articleRepository.findAll();
    }

    public Boolean deleteArticleById(int id){
        return articleRepository.deleteById(id);
    }

}
