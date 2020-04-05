# spring-boot-rest-jpa-h2-example
A simple application of Spring Boot using WEB, JPA, H2 and Swagger document auto generate.

### Browse

swagge web ui
http://localhost:8080/swagger-ui.html

## Api operation 

##### CREATE 

```
POST : http://localhost:8080/service/post

{
	"id" : "P1",
	"title" : "title -1",
	"content" : "this is second post",
	"status" : "active",
	"tag" : "tag1,tag2"
}
```

##### Update

```
PUT : http://localhost:8080/service/post/P1

{
	"title" : "test post1",
	"content" : "updated test post content1",
	"status" : "active",
	"tag" : "tag1,tag2"
}
```

##### GET All Post

```
GET : http://localhost:8080/service/posts
```

##### GET All Post

```
GET : http://localhost:8080/service/post/P1
```



##### DELETE

```
DELETE : http://localhost:8080/service/post/P2
```
