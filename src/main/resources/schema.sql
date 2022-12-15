DROP TABLE if EXISTS meet5_user;
CREATE TABLE meet5_user
(
  id         VARCHAR(100) NOT NULL PRIMARY KEY,
  name       VARCHAR(50) NOT NULL,
  age        INT NOT NULL,
  created_ts timestamp NOT NULL
);

DROP TABLE if EXISTS meet5_Visitor;
create table meet5_Visitor (
  visitor_id varchar(100) not null,
  visited_id varchar(100) not null,
  visited_ts timestamp NOT NULL,
  foreign key (visitor_id) references meet5_user(id),
  foreign key (visitor_id) references meet5_user(id)

)
