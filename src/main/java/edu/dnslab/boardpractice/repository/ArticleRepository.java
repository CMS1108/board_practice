package edu.dnslab.boardpractice.repository;


import edu.dnslab.boardpractice.domain.Article;

import java.util.List;

public interface ArticleRepository {
    Article save(Article article);
    Article update(Article article);
    String deleteById(int id);
    List<Article> findAll();
    Article findById(int id);

}
