mysql> create database blog;
mysql> use blog


create table post(
   id VARCHAR(15) NOT NULL ,
   title VARCHAR(1000) NOT NULL,
   content VARCHAR(4000) NOT NULL,
   status VARCHAR(100) NOT NULL,
   tag VARCHAR(1000) NOT NULL,
   create_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY ( id )
);

INSERT INTO post (title, content, status, tag )
VALUES ('Test title','this is first post','active','tag1,tag2');