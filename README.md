# Sticksnpucks

[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)](LICENSE)
[![Pipeline](https://git.fhict.nl/I426146/sticksnpucks/badges/master/pipeline.svg)](https://git.fhict.nl/I426146/sticksnpucks/badges/master/pipeline)

### API status
[![Quality gate](http://localhost:9000/api/project_badges/quality_gate?project=sticks-pucks)](http://localhost:9000/dashboard?id=sticks-pucks)

### Web status
[![Quality gate](http://localhost:9000/api/project_badges/quality_gate?project=com.sticksnpucks%3ASticks-n-pucks)](http://localhost:9000/dashboard?id=com.sticksnpucks%3ASticks-n-pucks)


## Idea
Sticks’n’pucks is a project whose goal is to make hockey management easier for everyone but mostly for the team managers. Team managers can add their players, captains and team assistants to the application, keep track of what happened during the played games and check for free agents that they can sign to improve their team’s performance. Furthermore, players can see their progress over time, their goals, assists, team roles and penalties and fans can enjoy full statistics of the played games of their team and favourite players.

## Target users
The users that the project is targeting can be separated in four different groups:
* Hockey team managers
* Hockey players without a team (prospects and free agents)
* Hockey players part of a registered team
* Fans
The most important target group from the business side of the project are the team managers. Most of the features are tailored specifically to managers to make their every day work even easier.

# Architecture of the project
	
## Subprojects
The main project (Sticks’n’pucks) consists of two sub projects - an API that communicates with the database and a web application. 
The API consists mainly of models containing classes that handle CRUD operations of objects, repository (which is currently the so-called Fake Data Store where the information is stored) and resources which contain the API endpoints. 
The web application consists of the standard structure for a Spring project - controllers and static css, static html, templates.

## Used technologies
* Jira - used for project management, adding deadlines for the tasks, keeping track of things to do and as a features backlog
* GitLab - used for version control of the source of the code of the project
* GitLab CI/CD - used for checking if the project is compiling, running unit tests and linting the code before merging to master
* Spring - used for the web application
* Java + Gradle  - used for the API
* MySQL - used for the database
* Vue.js - frontend framework
* Tailwind - CSS library used in combination with Vue.js
* Thymeleaf - used as templating engine for Spring
* SonarQube - for continuous inspection of code quality
* Checkstyle - for making sure that the code follows the Java language conventions
* Cypress - for end to end testing
* Storybook - tool for UI development