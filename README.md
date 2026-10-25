# Lamb's Plate

Helps people rescue surplus food before it is thrown away.

**Status:** foundation only. The server starts, answers `GET /health`, and CI runs the tests. The MVP below is planned and not built yet.

## The idea

Wholesalers, restaurants and shops often end up with food they cannot sell. Lamb's Plate lets them post it, and lets people nearby reserve a portion and collect it before the pickup window closes.

## Planned MVP

* **Donor side:** post a listing (what the food is, how much, where, and a pickup window), and view or cancel your own listings.
* **Receiver side:** browse open listings, reserve a portion, and confirm collection.
* **Rules we will test carefully:**
  * nobody can reserve more than what is left
  * nobody can reserve after the pickup window has closed
  * two people cannot take the last portion at the same moment

Not in the MVP: notifications, maps, email and a price tracker. We will check what is free and allowed before planning those.

The open product questions are listed in [docs/wiki/mvp.md](docs/wiki/mvp.md).

## Tech

Java 21, [Javalin](https://javalin.io) 6.7.0, Maven, JUnit 5, GitHub Actions. SQLite and plain HTML come with the first features that need them.

## Run and test

You need JDK 21 or newer, Maven 3.9 or newer, and Git. Setup steps are in [docs/wiki/getting-started.md](docs/wiki/getting-started.md).

```
mvn -B verify
```

To run the server, run `com.lambsplate.App.main` from your IDE, then open http://localhost:7070/health. It should show `ok`. Set the `PORT` environment variable to use another port.

## Project layout

```
src/main/java/com/lambsplate/   application code
src/test/java/com/lambsplate/   tests
docs/wiki/                      notes, decisions and setup guides
.github/workflows/ci.yml        runs mvn -B verify on every pull request
```

## Working together

Nobody pushes straight to `main`. Read [CONTRIBUTING.md](CONTRIBUTING.md) for the branch, commit and review rules, and [docs/wiki/Home.md](docs/wiki/Home.md) for the decisions behind the setup.

## Team

* Lichume Standard ([@standard-archive](https://github.com/standard-archive)), planned: donor side
* Lumko Majozi ([@Lumko02](https://github.com/Lumko02)), planned: receiver side
