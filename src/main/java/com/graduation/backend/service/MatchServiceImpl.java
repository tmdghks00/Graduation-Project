package com.graduation.backend.service;

import com.graduation.backend.entity.Match;
import com.graduation.backend.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    // 매칭 요청 생성 (기본 상태: 매칭되지 않음, 요청 시간 저장)
    @Override
    public Match requestMatch(Match match) {
        match.setMatched(false);
        match.setMatchedAt(LocalDateTime.now());
        return matchRepository.save(match);
    }

    // 전체 매칭 리스트 조회
    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    // 매칭 상태 업데이트 ("ACCEPTED"일 경우 matched true 처리)
    @Override
    public Match updateMatchStatus(Long matchId, String status) {
        Match match = matchRepository.findById(matchId).orElseThrow();
        match.setMatchStatus(status);
        match.setMatched("ACCEPTED".equals(status));
        return matchRepository.save(match);
    }
}
