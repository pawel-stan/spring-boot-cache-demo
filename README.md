# Spring Boot Cache Demo

Projekt demonstrujący cache'owanie w aplikacji Spring Boot.

## Baza danych

Przed uruchomieniem projektu przygotuj pustą bazę danych PostgreSQL.

## Zmienne

- `spring.datasource.url` — adres bazy danych wraz z portem;
- `spring.datasource.username` — nazwa użytkownika w bazie danych;
- `spring.datasource.password` — hasło użytkownika w bazie danych;
- `spring.redis.database` — indeks bazy redis, opcjonalny;
- `spring.redis.host` — adres redis, domyślnie _localhost_;
- `spring.redis.port` — port redis, domyślnie _6379_;
- `spring.redis.password` — hasło redis, opcjonalne.

Przykład użycia jako argumenty JVM:

```java
-Dspring.datasource.url="jdbc:postgresql://localhost:5432/spring_boot_cache_demo" 
-Dspring.datasource.username=wsb
-Dspring.datasource.password=secret
-Dspring.redis.database=10
-Dspring.redis.host=localhost
-Dspring.redis.port=6379
-Dspring.redis.password=mypass
```

