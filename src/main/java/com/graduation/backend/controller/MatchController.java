package com.graduation.backend.controller;

import com.graduation.backend.entity.Match;
import com.graduation.backend.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @PostMapping("/request")
    // ➕ 매칭 요청 생성
    public Match requestMatch(@RequestBody Match match) {
        return matchService.requestMatch(match);
    }

    @GetMapping
    // 🔍 전체 매칭 목록 조회
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PutMapping("/{id}/status")
    // 📝 특정 매칭 상태 변경
    public Match updateStatus(@PathVariable Long id, @RequestParam String status) {
        return matchService.updateMatchStatus(id, status);
    }
}
