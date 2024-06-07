# Tourism Attractions API

Tourism Attractions API is a Spring Boot REST API connecting to a PostgreSQL database, inspired by [SingaStays](https://github.com/Aishahaha/ntu-project-1). The API allows users to manage members, attractions, categories and favourites data. The database is loaded with preset data for users to explore usage of the API.

## Features

- Create, read, update and delete members
- Create, read, update and delete attractions
- Create, read, update and delete categories
- Add attraction to category
- Remove all attractions from a category
- Add attraction and category to member's favourites 
- Read and delete favourites
- Search member by first name
- Search category by name

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA

## API Endpoints

| Method | URL                                  | Description                                                                                 | Query Parameters       |
| ------ | ------------------------------------ | ------------------------------------------------------------------------------------------- | ---------------------- |
| GET    | `/members`                           | Retrieve all members                                                                        |                        |
| GET    | `/members/{id}`                      | Retrieve one member based on ID                                                             |                        |
| POST   | `/members`                           | Create a member                                                                             |                        | 
| PUT    | `/members/{id}`                      | Update a member's details based on ID                                                       |                        |
| DELETE | `/members/{id}`                      | Delete one member                                                                           |                        |
| GET    | `/members/search`                    | Search members by first name                                                                | `firstName` (required) |
| GET    | `/attractions`                       | Retrieve all attractions                                                                    |                        |
| GET    | `/attractions/{id}`                  | Retrieve one attraction based on ID                                                         |                        |
| POST   | `/attractions`                       | Create an attraction                                                                        |                        |
| PUT    | `/attractions/{id}`                  | Update an attraction based on ID                                                            |                        |
| DELETE | `/attractions/{id}`                  | Delete one attraction                                                                       |                        |
| GET    | `/categories`                        | Retrieve all categories                                                                     |                        |
| GET    | `/categories/{id}`                   | Retrieve one category based on ID                                                           |                        |
| POST   | `/categories`                        | Create a category                                                                           |                        |
| PUT    | `/categories/{id}`                   | Update a category based on ID                                                               |                        |
| DELETE | `/categories/{id}`                   | Delete one category <br>(Category cannot be deleted if there are any attractions linked to it) |                        |
| PUT    | `/categories/{id}/attractions`       | Remove all attractions in a category                                                        |                        |
| GET    | `/categories/search`                 | Search categories by name                                                                   | `name` (required)      |
| GET    | `/user-favourites`                   | Retrieve all favourites entries                                                             |                        |
| GET    | `/user-favourites/{id}`              | Retrieve one favourites entry based on ID                                                   |                        |

Example requests for all endpoints are available in the Thunder Client collections included in the thunder_clients directory.

<!-- ## Trying it Out -->

## Limitations

- This is a mock API and does not provide real data
- Upon restarting the application, all data will be deleted and the database will be reloaded with preset data.

## Group Contributions

This project was developed by a team of contributors. The key features and implementation were done by:

- Lin Xuan: Worked on categories and members
- Aishah: Worked on attractions
- YH: Worked on favourites

