package com.graduation.backend.service;

import com.graduation.backend.entity.Match;

import java.util.List;

/**
 * 강아지 매칭 서비스 인터페이스
 */
public interface MatchService {

    // 매칭 요청 생성
    Match requestMatch(Match match);

    // 모든 매칭 요청 목록 조회
    List<Match> getAllMatches();

    // 매칭 상태 업데이트 (예: 요청 → 수락/거절)
    Match updateMatchStatus(Long matchId, String status);
}
