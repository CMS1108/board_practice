package edu.dnslab.boardpractice.repository;


import edu.dnslab.boardpractice.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository {
    private final JdbcTemplate jdbcTemplate;


    @Override
    public Article update(Article article) {
        jdbcTemplate.update("update board set content=? where id=?", article.getContent(), article.getId());
        return article;
    }

    @Override
    public Article save(Article article) {
        jdbcTemplate.update("insert into board(id, name, content) values(?, ?, ?)", article.getId(), article.getName(), article.getContent());
        return article;
    }

    @Override
    public Boolean deleteById(int id) {
        return jdbcTemplate.update("delete from board where id = ?", id) > 0;
    }

    @Override
    public List<Article> findAll() {
        return jdbcTemplate.query("select * from board", this::dataRowMapper);
    }

    @Override
    public Article findById(int id) {
        return jdbcTemplate.queryForObject("select * from board where id = ?", this::dataRowMapper, id);
    }

    private Article dataRowMapper(ResultSet rs, int rowNum) throws SQLException {
        return new Article(rs.getInt("id"), rs.getString("name"), rs.getString("content"));
    }
}
