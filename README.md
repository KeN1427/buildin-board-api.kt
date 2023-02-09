# buildin-board-api.kt
API build in Kotlin and SpringBoot for buildin board application.

## API Schema
TBD

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