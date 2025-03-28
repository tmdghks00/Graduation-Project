✅ 구현된 기능
🔐 사용자 인증 및 회원 기능
 회원가입 (POST /api/users/signup)

 로그인 → JWT 토큰 발급 (POST /api/users/login)

 사용자 정보 조회 (GET /api/users/{id})

 사용자 닉네임 수정 (PUT /api/users/{id}?nickname=...)

 사용자 삭제 (DELETE /api/users/{id})

 로그인한 사용자만 접근 가능하도록 Spring Security + JWT 설정

📝 게시글 기능 (CRUD)
 게시글 작성 (POST /api/posts) - 로그인한 사용자만 가능

 게시글 전체 조회 (GET /api/posts)

 게시글 단건 조회 (GET /api/posts/{id})

 게시글 수정 (PUT /api/posts/{id}) - 작성자만 가능

 게시글 삭제 (DELETE /api/posts/{id}) - 작성자만 가능

🐶 강아지 프로필 등록
 강아지 정보 등록 (POST /api/dogs)

(👀 향후: 조회, 수정, 삭제 기능 추가 예정)

⚙️ 기술 스택
Backend: Spring Boot 3, Spring Security, JPA, MySQL

JWT 인증: jjwt 라이브러리 사용

빌드 도구: Gradle

IDE: IntelliJ IDEA
