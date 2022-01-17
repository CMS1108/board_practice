package edu.dnslab.boardpractice.repository;


import edu.dnslab.boardpractice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Member update(Member member);
    Member delete(Member member);
    List<Member> findAll();
    Optional<Member> findByName(String name);

}
