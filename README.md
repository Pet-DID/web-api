# Web-api

```mysql
CREATE TABLE event_entry (
    `id`            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `type`          VARCHAR(255),
    `content_type`  VARCHAR(255),
    `payload`       MEDIUMTEXT,
    `timestamp`     DATETIME
) CHARACTER SET utf8;
```
