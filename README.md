# 🐾 PawMate 백엔드

강아지 커뮤니티 및 미팅 플랫폼 **PawMate**의 백엔드 서버입니다.  
회원 가입부터 실시간 채팅, 강아지 프로필 등록까지 다양한 기능을 제공합니다.

---

## ✅ 구현된 기능

### 🔐 사용자 인증 및 회원 기능

- 회원가입: `POST /api/users/signup`
- 로그인 (JWT 발급): `POST /api/users/login`
- 사용자 정보 조회: `GET /api/users/{id}`
- 닉네임 수정: `PUT /api/users/{id}?nickname=...`
- 회원 탈퇴: `DELETE /api/users/{id}`
- 로그인 사용자 인증: Spring Security + JWT 적용

---

### 📝 커뮤니티 게시글 기능 (CRUD)

- 게시글 작성: `POST /api/posts` (*로그인 필수*)
- 게시글 전체 조회: `GET /api/posts`
- 게시글 상세 조회: `GET /api/posts/{id}`
- 게시글 수정: `PUT /api/posts/{id}` (*작성자만 가능*)
- 게시글 삭제: `DELETE /api/posts/{id}` (*작성자만 가능*)

---

### 🐶 강아지 프로필 기능

| 기능 | API 경로 | 설명 |
|------|----------|------|
| 강아지 등록 | `POST /api/dogs` | 사용자 1명당 1마리 등록 |
| 강아지 조회 | `GET /api/dogs/{id}` | 강아지 ID로 단건 조회 |
| 강아지 수정 | `PUT /api/dogs/{id}` | 이름, 품종, 나이, 성별, 이미지 등 수정 |
| 강아지 삭제 | `DELETE /api/dogs/{id}` | 강아지 프로필 삭제 |

---

### 💬 실시간 1:1 채팅 기능

- WebSocket 연결: `/ws-stomp`
- 메시지 발신: `/pub/chat/{chatRoomId}`
- 메시지 수신 구독: `/sub/chat/{chatRoomId}`
- 채팅 테스트 페이지: `stomp-chat-test.html`
- 구성: `WebSocketBrokerConfig`, `StompController`, `StompHandler`

---

### 💘 매칭 기능

- 매칭 로직 기본 구현 완료
- `MatchService`, `MatchController`, `MatchRepository` 구성
- 🔧 매칭 기준 정의 및 UI 연동은 추후 예정

---

### 📝 리뷰 기능

- 리뷰 등록/조회/삭제 기능 구현 완료
- 리뷰 대상자 및 작성자 정보 포함
- 구성: `ReviewService`, `ReviewController`, `ReviewRepository`

---

### 🚨 긴급 알림 기능

- 알림 저장 기능 구현 (`AlertService`, `AlertRepository`)
- 🔧 실시간 알림 전송/푸시 기능은 추후 구현 예정

---

### 🗃️ MySQL 데이터베이스 테이블

- 테이블 구성:
  - `user`
  - `post`
  - `dog_profile`
  - `chat_message`
  - `match`
  - `review`
  - `alert`
- 외래키 포함 관계 정상 설정
- AWS RDS 연동 (application.properties 확인)

---

## ⚙️ 기술 스택

| 항목 | 내용 |
|------|------|
| Backend | Spring Boot 3, Spring Security |
| 인증 | JWT (`jjwt` 라이브러리 사용) |
| ORM | JPA (Hibernate) |
| DB | MySQL (AWS RDS) |
| 실시간 통신 | WebSocket + STOMP |
| API 문서화 | Swagger 사용 |
| Build Tool | Gradle |
| IDE | IntelliJ IDEA |
