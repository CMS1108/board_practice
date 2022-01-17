package edu.dnslab.boardpractice.repository;


import edu.dnslab.boardpractice.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Member update(Member member) {
        jdbcTemplate.update("update board set content=? where id=?", member.getContent(), member.getId());
        return member;
    }

    @Override
    public Member save(Member member) {
        jdbcTemplate.update("insert into board(id, name, content) values(?, ?, ?)", member.getId(), member.getName(), member.getContent());
        return member;
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update("delete from board where id = ?", id);
        return "Deleted " + id;
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from board", this::dataRowMapper);
    }

    @Override
    public Member findById(int id) {
        return jdbcTemplate.queryForObject("select id, name, content from board where id = ?", this::dataRowMapper, id);
    }

    private Member dataRowMapper(ResultSet rs, int rowNum) throws SQLException {
        return new Member(rs.getInt("id"), rs.getString("name"), rs.getString("content"));
    }
}
