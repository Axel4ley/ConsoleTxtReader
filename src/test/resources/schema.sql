CREATE TABLE IF NOT EXISTS  document (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(75) NOT NULL,
  line_count INT NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE  IF NOT EXISTS document_line (
  id INT(11) NOT NULL AUTO_INCREMENT,
  line TEXT NOT NULL,
  document_id INT(11) NOT NULL,
  length INT(11) NOT NULL,
  longest_word VARCHAR(45) NOT NULL,
  shortest_word VARCHAR(45) NOT NULL,
  average INT(11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_document_id
  FOREIGN KEY (document_id)
  REFERENCES document(id));
