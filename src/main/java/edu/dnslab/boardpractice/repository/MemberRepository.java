package edu.dnslab.boardpractice.repository;


import edu.dnslab.boardpractice.domain.Member;

import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Member update(Member member);
    String deleteById(int id);
    List<Member> findAll();
    Member findById(int id);

}
