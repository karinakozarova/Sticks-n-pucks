CREATE TABLE `Account` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `date_of_birth` date,
  `email` varchar(255)
);

CREATE TABLE `AccountRole` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `role` enum
);

CREATE TABLE `PlayerInformation` (
  `user_id` int PRIMARY KEY,
  `height` int,
  `weight` int,
  `position` enum,
  `shoots` enum
);

CREATE TABLE `Team` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(300),
  `logo_location` varchar(400),
  `rink_location` varchar(400)
);

CREATE TABLE `TeamPlayers` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `team_id` int,
  `start_date` datetime,
  `end_date` datetime
);

CREATE TABLE `TeamRoles` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `team_id` int,
  `start_date` datetime,
  `end_date` datetime,
  `role` enum
);

CREATE TABLE `GameInfo` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `host_team_id` int,
  `guest_team_id` int,
  `start_date` datetime,
  `end_date` datetime
);

CREATE TABLE `GameGoals` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `game_id` int,
  `scored_by_team_id` int,
  `goal_time` datetime
);

CREATE TABLE `GameGoalStatistics` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `goal_id` int,
  `player_id` int,
  `action` enum
);

CREATE TABLE `GamePenaltyStatistics` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `player_id` int,
  `time` datetime,
  `given_penalty_id` int,
  `action` enum
);

CREATE TABLE `Penalties` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100),
  `description` varchar(1000)
);

ALTER TABLE `AccountRole` ADD FOREIGN KEY (`user_id`) REFERENCES `Account` (`id`);

ALTER TABLE `PlayerInformation` ADD FOREIGN KEY (`user_id`) REFERENCES `Account` (`id`);

ALTER TABLE `TeamPlayers` ADD FOREIGN KEY (`user_id`) REFERENCES `Account` (`id`);

ALTER TABLE `TeamPlayers` ADD FOREIGN KEY (`team_id`) REFERENCES `Team` (`id`);

ALTER TABLE `TeamRoles` ADD FOREIGN KEY (`user_id`) REFERENCES `Account` (`id`);

ALTER TABLE `TeamRoles` ADD FOREIGN KEY (`team_id`) REFERENCES `Team` (`id`);

ALTER TABLE `GameInfo` ADD FOREIGN KEY (`host_team_id`) REFERENCES `Team` (`id`);

ALTER TABLE `GameInfo` ADD FOREIGN KEY (`guest_team_id`) REFERENCES `Team` (`id`);

ALTER TABLE `GameGoals` ADD FOREIGN KEY (`game_id`) REFERENCES `Team` (`id`);

ALTER TABLE `GameGoals` ADD FOREIGN KEY (`scored_by_team_id`) REFERENCES `Team` (`id`);

ALTER TABLE `GameGoalStatistics` ADD FOREIGN KEY (`goal_id`) REFERENCES `GameGoals` (`id`);

ALTER TABLE `Account` ADD FOREIGN KEY (`id`) REFERENCES `GameGoalStatistics` (`player_id`);

ALTER TABLE `GamePenaltyStatistics` ADD FOREIGN KEY (`player_id`) REFERENCES `Account` (`id`);

ALTER TABLE `GamePenaltyStatistics` ADD FOREIGN KEY (`given_penalty_id`) REFERENCES `Penalties` (`id`);
