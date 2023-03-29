CREATE TABLE IF NOT EXISTS Content(
  id INTEGER AUTO_INCREMENT,
  title VARCHAR(256) NOT NULL,
  desc text,
  status VARCHAR(25) NOT NULL,
  content_type VARCHAR(45) NOT NULL,
  date_created TIMESTAMP NOT NULL,
  date_updated TIMESTAMP,
  url VARCHAR(255),
  primary key(id)
);

INSERT INTO Content(title,desc,status,content_type,date_created)
VALUES('My spring data blog post',
'A post about spring data',
'IDEA',
'ARTICLE',
CURRENT_TIMESTAMP
);