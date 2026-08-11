# 학생 성적 관리 시스템 API 명세서

Base URL: `http://localhost:8080`

## 1. 전체 학생 조회

| 항목 | 내용 |
|---|---|
| Method | GET |
| URL | `/students` |
| Request | 없음 |
| Response | 학생 리스트 |

**응답 예시**
```json
[
  { "id": 1, "name": "홍길동", "score": [90, 85, 100] }
]
```

## 2. 특정 학생 조회

| 항목 | 내용 |
|---|---|
| Method | GET |
| URL | `/students/{id}` |
| Request | 없음 (URL에 id 포함) |
| Response | 학생 1명 |

**요청 예시**: `GET /students/1`

**응답 예시**
```json
{ "id": 1, "name": "홍길동", "score": [90, 85, 100] }
```

## 3. 점수 이상 학생 조회

| 항목 | 내용 |
|---|---|
| Method | GET |
| URL | `/students?minScore={점수}` |
| Request | 쿼리스트링(`minScore`) |
| Response | 조건에 맞는 학생 리스트 |

**요청 예시**: `GET /students?minScore=80`

**응답 예시**
```json
[
  { "id": 1, "name": "홍길동", "score": [90, 85, 100] }
]
```

## 4. 학생 등록

| 항목 | 내용 |
|---|---|
| Method | POST |
| URL | `/students` |
| Request | JSON Body (name, score) |
| Response | 등록된 학생 (id 자동 부여) |

**요청 Body**
```json
{
  "name": "홍길동",
  "score": [90, 85, 100]
}
```

**응답 예시**
```json
{ "id": 1, "name": "홍길동", "score": [90, 85, 100] }
```

## 5. 학생 정보 수정

| 항목 | 내용 |
|---|---|
| Method | PATCH |
| URL | `/students/{id}` |
| Request | JSON Body (수정할 name, score) |
| Response | 수정된 학생 |

**요청 예시**: `PATCH /students/2`
```json
{
  "name": "김철수",
  "score": [95, 95, 95]
}
```

**응답 예시**
```json
{ "id": 2, "name": "김철수", "score": [95, 95, 95] }
```

## 6. 학생 삭제

| 항목 | 내용 |
|---|---|
| Method | DELETE |
| URL | `/students/{id}` |
| Request | 없음 (URL에 id 포함) |
| Response | 없음 |

**요청 예시**: `DELETE /students/2`

## 7. 개인 평균 점수 조회

| 항목 | 내용 |
|---|---|
| Method | GET |
| URL | `/students/{id}/average` |
| Request | 없음 (URL에 id 포함) |
| Response | 평균 점수 (숫자) |

**요청 예시**: `GET /students/1/average`

**응답 예시**
```json
91.66666666666667
```

## 8. 전체 학생 등수 조회

| 항목 | 내용 |
|---|---|
| Method | GET |
| URL | `/students/rank` |
| Request | 없음 |
| Response | 평균 점수 내림차순 정렬된 학생 리스트 |

**응답 예시**
```json
[
  { "id": 1, "name": "홍길동", "score": [90, 85, 100] },
  { "id": 2, "name": "김철수", "score": [60, 70, 65] }
]
```

---

## 아키텍처

```
Controller (요청 수신/응답) → Service (평균/등수/필터 로직) → Repository (인메모리 저장)
```

- 저장 방식: 인메모리 (`List<Student>`), 서버 재시작 시 초기화됨
- id: 등록 시 자동 증가 부여 (1부터 시작)
