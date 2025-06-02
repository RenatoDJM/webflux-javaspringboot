🎬 Movie Information API

This project was developed as part of a real junior backend Java job test. It implements the requested features in a concise and functional way.

It is a reactive REST API built with Spring Boot + WebFlux, designed to consume public data about movies filmed in San Francisco. The data source is the city's open data portal:

📡 https://data.sfgov.org/resource/yitu-d5am.json

📌 Features

🔍 List all movies

🧠 Autocomplete movie titles by prefix

🔎 Filter movies by title (case-insensitive)

🚀 Endpoints

✅ 1. List All Movies

Request:
GET /movies

Example:
GET http://localhost:8080/movies

Description:
Returns all movie records available from the public data source.

🔎 2. Search by Title
Request:
GET /movies?title={term}

Example:
GET http://localhost:8080/movies?title=matrix

Description:
Filters movies where the title contains the given term (case-insensitive).

🧠 3. Autocomplete Titles
Request:
GET /movies/autocomplete?q={prefix}

Example:
GET http://localhost:8080/movies/autocomplete?q=sta

Description:
Returns up to 10 unique movie titles that start with the given prefix.


💾 Sample Response

json

[
  {
    "title": "The Matrix",
    "release_year": "1999",
    "locations": "San Francisco",
    "production_company": "Warner Bros",
    "distributor": "Warner Bros",
    "director": "The Wachowskis",
    "writer": "The Wachowskis",
    "actor_1": "Keanu Reeves",
    "actor_2": "Laurence Fishburne",
    "actor_3": "Carrie-Anne Moss"
  }
]


📦 Project Structure

src/
└── main/
    └── java/
        └── com/
            └── yourapp/
                ├── WebFluxApplication.java         # Main application class
                ├── controller/
                │   └── MovieInformationController.java
                ├── model/
                │   └── MovieInformation.java
                └── service/
                    └── MovieInformationService.java


🧪 How to Run
Make sure you have Java 17+ and Maven installed.

Clone the repository:


git clone https://github.com/RenatoDJM/webflux-javaspringboot.git
cd webflux-javaspringboot
Run the application:

./mvnw spring-boot:run
Access the API via browser, Postman, or Insomnia:

http://localhost:8080/movies

🔧 Technologies Used

Java 17
Spring Boot
Spring WebFlux
Project Lombok
WebClient

📝 License
This project uses public data and is available under the MIT License.

🙋‍♂️ Contributions
Contributions are welcome! Feel free to open issues and submit pull requests.