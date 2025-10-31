# InvestingApp

투자 관리 애플리케이션

## 기술 스택

- **백엔드**: Java 17 + Spring Boot 3.2 + Gradle
- **프론트엔드**: React + TypeScript + Material-UI (MUI)
- **데이터베이스**: MariaDB + phpMyAdmin

## 프로젝트 구조

```
investingApp/
├── backend/                    # Spring Boot 백엔드
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/investing/app/
│   │   │   │       ├── InvestingAppApplication.java
│   │   │   │       ├── common/        # 공통 설정
│   │   │   │       └── domain/        # 도메인별 패키지
│   │   │   └── resources/
│   │   │       └── application.yml
│   │   └── test/
│   ├── build.gradle
│   └── settings.gradle
├── frontend/                   # React 프론트엔드
│   ├── src/
│   ├── public/
│   ├── package.json
│   └── .env.example
├── docker-compose.yml         # MariaDB & phpMyAdmin
└── README.md
```

## 시작하기

### 1. MariaDB 실행

```bash
docker-compose up -d
```

- MariaDB: localhost:3307
- phpMyAdmin: http://localhost:8081 (root/rootpassword123)

### 2. 백엔드 실행

#### 필수 요구사항
- Java 17 이상
- Gradle (wrapper 포함)

#### 실행 방법

```bash
cd backend
./gradlew bootRun
```

또는 IDE에서 `InvestingAppApplication.java` 실행

백엔드 API: http://localhost:8001/api

### 3. 프론트엔드 실행

```bash
cd frontend
npm install
npm start
```

프론트엔드: http://localhost:3001

## 환경 변수

### 백엔드 (application.yml)
`backend/src/main/resources/application.yml`에서 설정:
```yaml
spring:
  datasource:
    url: jdbc:mariadb://localhost:3307/investingapp
    username: appuser
    password: password123

server:
  port: 8001
```

### 프론트엔드 (.env)
```
REACT_APP_API_URL=http://localhost:8001/api
PORT=3001
```

## 개발 명령어

### 백엔드
```bash
# 개발 서버 실행
./gradlew bootRun

# 빌드
./gradlew build

# 테스트
./gradlew test

# 클린 빌드
./gradlew clean build

# 의존성 확인
./gradlew dependencies
```

### 프론트엔드
```bash
# 개발 서버 실행
npm start

# 빌드
npm run build

# 테스트
npm test
```

### Docker
```bash
# 컨테이너 시작
docker-compose up -d

# 컨테이너 중지
docker-compose down

# 로그 확인
docker-compose logs -f

# 볼륨 삭제 (데이터베이스 초기화)
docker-compose down -v
```

## API 엔드포인트

기본 URL: `http://localhost:8001/api`

- `GET /` - API 정보
- `GET /health` - 헬스 체크