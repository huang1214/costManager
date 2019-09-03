

ALTER TABLE `project` ADD  `book_video_id` int(11) NULL DEFAULT NULL;

ALTER TABLE `project` ADD CONSTRAINT `book_video_id` FOREIGN KEY (`book_video_id`) REFERENCES `book` (`id`);