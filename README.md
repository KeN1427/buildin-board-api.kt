# bulletin-board-api.kt
API built in Kotlin and SpringBoot for bulletin board application.

## API Schema
swagger: http://localhost:8080/swagger-ui/index.html

- GET /v1/healthCheck 

- POST /v1/users
- GET /v1/users/{user_id}
- PUT /v1/users/{user_id}
- DELETE /v1/users/{user_id}
 
- GET /v1/threads
- POST /v1/threads
- GET /v1/threads/{thread_id}
- DELETE /v1/threads/{thread_id}

- POST /v1/comments
- PUT /v1/comments/{comment_id}
- DELETE /v1/comments/{comment_id}

## Database Schema
### Users
| Column       | Type        |
|:-------------|:------------|
| id           | INT(8)      |
| username     | VARCHAR(30) |
| mail_address | VARCHAR(30) |
| status       | ENUM        |
| create_time  | DATETIME    |
| update_time  | DATETIME    |

### Threads
| Column      | Type     |
|:------------|:---------|
| id          | INT(8)   |
| user_id     | INT(8)   |
| Status      | ENUM     |
| create_time | DATETIME |
| update_time | DATETIME |
 
### Comments
| Column      | Type     |
|:------------|:---------|
| id          | INT(8)   |
| thread_id   | INT(8)   |
| user_id     | INT(8)   |
| comment     | TEXT     |
| status      | ENUM     |
| create_time | DATETIME |
| update_time | DATETIME |