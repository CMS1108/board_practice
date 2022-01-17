package edu.dnslab.boardpractice.repository;


import edu.dnslab.boardpractice.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Member save(Member member) {
        jdbcTemplate.update("insert into board(id, name, content) values(?, ?, ?)", member.getId(), member.getName(), member.getContent());
        return member;


    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from board", this::dataRowMapper);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = jdbcTemplate.query("select * from board where name = ?", this::dataRowMapper, name);

        return result.stream().findAny();
    }

    private Member dataRowMapper(ResultSet rs, int rowNum) throws SQLException {
        return new Member(rs.getLong("id"), rs.getString("name"), rs.getString("content"));
    }
}
