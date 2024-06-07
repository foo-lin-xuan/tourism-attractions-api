# Tourism Attractions API

Tourism Attractions API is a Spring Boot REST API connecting to a PostgreSQL database, inspired by [SingaStays](https://github.com/Aishahaha/ntu-project-1). The API allows users to manage members, attractions, categories and favourites data. The database is loaded with preset data for users to explore usage of the API.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Example Requests](#example-requests)
- [Limitations](#limitations)
- [Group Contributions](#group-contributions)

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
- PostgreSQL
- Thunder Client (for API testing)

## Installation

1. **Clone the repository:**
    ```sh
    git clone https://github.com/toonuaaa/tourism-attractions-api.git
    cd tourism-attractions-api
    ```

2. **Set up the PostgreSQL database:**
    - Install PostgreSQL if it's not already installed.
    - Create a new database named `singastays`.

3. **Configure environment variables:**
    - Create a `.env` file in the `tourism-attractions-api/src/main/resources/` directory and add the following:
      ```
      DATASOURCE_URL=jdbc:postgresql://localhost:5432/singastays
      DATASOURCE_USERNAME=yourusername
      DATASOURCE_PASSWORD=yourpassword
      ```

4. **Run the application:**
    ```sh
    mvn clean spring-boot:run
    ```

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

## Example Requests

Example requests for all endpoints are available in the Thunder Client collections included in the thunder_clients directory.

### Thunder Client Collections

To use the Thunder Client collections:

1. Open Visual Studio Code.
2. Ensure you have the Thunder Client extension installed.
3. Navigate to the Thunder Client extension.
4. Click on the `Collections` tab.
5. Click on the `Import` button.
6. Select the exported collection files located in the `thunder_clients` folder in this repository.

### Collection Files

- [Members Collection](thunder_clients/thunder-collection_Members.json)
- [Attractions Collection](thunder_clients/thunder-collection_Attractions.json)
- [Categories Collection](thunder_clients/thunder-collection_Category.json)
- [Favourites Collection](thunder_clients/thunder-collection_UserFavourite.json)

## Limitations

- This is a mock API and does not provide real data
- Upon restarting the application, all data will be deleted and the database will be reloaded with preset data.

## Group Contributions

This project was developed by a team of contributors. The key features and implementation were done by:

- Lin Xuan: Worked on categories and members
- Aishah: Worked on attractions
- YH: Worked on favourites

[Original GitHub Repository](https://github.com/Aishahaha/singastays-m3)

