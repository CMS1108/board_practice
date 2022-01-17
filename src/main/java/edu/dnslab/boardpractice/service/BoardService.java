package edu.dnslab.boardpractice.service;


import edu.dnslab.boardpractice.domain.Member;
import edu.dnslab.boardpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final MemberRepository memberRepository;

    public Member addArticle(Member member){
        return memberRepository.save(member);
    }

    public Member updateArticle(Member member){
        return memberRepository.update(member);
    }


    public Member findArticleById(int id){
        return memberRepository.findById(id);
    }

    public List<Member> allArticle(){
        return memberRepository.findAll();
    }


    public String deleteArticleById(int id){
        return memberRepository.deleteById(id);
    }

}
