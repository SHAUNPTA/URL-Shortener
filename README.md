# URL-Shortener

A Spring Boot service that takes a long URL and returns a short, random 6 character code. Visiting the short code redirects to the original URL. 

Project was built with Spring Data JPA and an H2 in-memory database.

Spent longer than I'd like to admit fighting curl, terminals and powershell over how they escape quotation marks in a JSON body, before discovering Invoke-RestMethod with an unquoted -Body string just works
Got a URISyntaxException because the URL stored in the database had literal quote marks baked into the string — turns out "the terminal sent slightly wrong data" is a real bug category, not just a skill issue.
Wrote four Java files in VS Code, saved none of them with a .java extension, and then spent a good while insisting they were correctly saved. They were not.
Systemm does not require a long URL to demo

This one looked like a small step up from a CRUD API. It was not. Small project, disproportionate number of lessons.


## Tech Stack
Java 21
Spring Boot 4.1.1
Spring Data JPA
H2 Database (in-memory)
Maven
Project Structure
src/main/java/com/example/demo/
├── entity/       # ShortURL.java — maps to the database table
├── repository/   # ShortURLRepository.java — Spring Data JPA interface
├── service/      # URLShortenerService.java — code generation + business logic
└── controller/   # URLShortenerController.java — REST endpoints

## Running Locally
1. Clone the repo.
2. From the project root (where pom.xml lives), run:
   ./mvnw spring-boot:run

On Windows:

   .\mvnw spring-boot:run
The app starts on http://localhost:8080.


## API Endpoints
   | Method | Endpoint | Description |
   |--------|----------|-------------|
   | POST | `/api/shorten` | Submit a URL, get back a short code |
   | GET | `/{shortCode}` | Redirects to the original URL |
"https://example.com"

## Example response
json
{
  "id": 1,
  "shortCode": "aB3xY9",
  "originalURL": "https://example.com",
  "createdAt": "2026-09-06T01:40:03.4197086"
}

Visiting http://localhost:8080/aB3xY9 in a browser then redirects to https://example.com.

example.com is a real URL reserved specifically for use in demos and tutorials like this one

## Database

H2, in-memory. Watch it live while the app is running:

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:urlshortenerdb

Username: sa

Password: (blank)


## Known Limitations
1. The generated short codes are unlikely to collide in a 6-character alphanumeric space but not guarded against.
2. No click counter or expiration on short codes.
