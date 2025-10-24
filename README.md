# InvestingApp

투자 관리 애플리케이션

## 기술 스택

- **백엔드**: Python + FastAPI
- **프론트엔드**: React + TypeScript + Material-UI (MUI)
- **데이터베이스**: MongoDB + Mongo Express

## 프로젝트 구조

```
investingApp/
├── backend/           # FastAPI 백엔드
│   ├── main.py
│   ├── requirements.txt
│   └── .env.example
├── frontend/          # React 프론트엔드
│   ├── src/
│   ├── public/
│   ├── package.json
│   └── .env.example
├── docker-compose.yml # MongoDB & Mongo Express
└── README.md
```

## 시작하기

### 1. MongoDB 실행

```bash
docker-compose up -d
```

- MongoDB: http://localhost:27018
- Mongo Express: http://localhost:8081 (admin/admin)

### 2. 백엔드 실행

```bash
cd backend
python -m venv venv
source venv/bin/activate  # Windows: venv\Scripts\activate
pip install -r requirements.txt
cp .env.example .env
uvicorn main:app --reload --host 0.0.0.0 --port 8001
```

백엔드 API: http://localhost:8001

### 3. 프론트엔드 실행

```bash
cd frontend
npm install
cp .env.example .env
npm start
```

프론트엔드: http://localhost:3001

## 환경 변수

### 백엔드 (.env)
```
MONGODB_URL=mongodb://admin:password123@localhost:27018
MONGODB_DB_NAME=investingapp
API_HOST=0.0.0.0
API_PORT=8001
```

### 프론트엔드 (.env)
```
REACT_APP_API_URL=http://localhost:8001
PORT=3001
```

## 개발 명령어

### 백엔드
```bash
# 개발 서버 실행
uvicorn backend.main:app --reload

# 의존성 설치
pip install -r requirements.txt
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
```