CREATE TABLE sake (
  id                  INTEGER auto_increment,
  name                VARCHAR(100) NOT NULL,
  brewing_name        VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO sake (name, brewing_name) VALUES ('若波', '若波酒造'), ('新政', '新政酒造'), ('十四代', '高木酒造');
