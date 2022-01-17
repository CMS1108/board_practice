package edu.dnslab.boardpractice.service;


import edu.dnslab.boardpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final MemberRepository memberRepository;


}
