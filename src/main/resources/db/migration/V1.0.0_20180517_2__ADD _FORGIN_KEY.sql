

ALTER TABLE `circular` ADD  `book_circular_id`  int(11) NULL DEFAULT NULL;

ALTER TABLE `circular` ADD CONSTRAINT `book_circular_id` FOREIGN KEY (`book_circular_id`) REFERENCES `book` (`id`);
