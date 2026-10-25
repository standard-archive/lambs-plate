# Lamb's Plate wiki

## Pages

* [Getting started](getting-started.md): set up your laptop and check it works
* [MVP scope and open questions](mvp.md): what we are building first, and what is still undecided

## Decisions log

| # | Decision | Reason |
|---|----------|--------|
| D1 | Javalin 6.7.0 | It was the version listed as current on the Javalin documentation page when we chose. Javalin 7.0 (February 2026) exists and needs Java 17 or newer. We can move later, since the app is small. |
| D2 | Java 21 (LTS) in CI and for both developers | Long term support release. `maven.compiler.release` is 21, so a newer local JDK still produces compatible output. |
| D3 | Very few dependencies: Javalin, slf4j-simple, JUnit | Library versions have to match each other. Fewer libraries means fewer mismatches. Each new library is added in the pull request that needs it. |
| D4 | Tests use the JDK's own HTTP client and a random free port | No extra test library is needed, and tests never clash over a port. |
| D5 | Documentation lives in `docs/wiki` as Markdown | It is reviewed in pull requests and travels with the code. GitHub's built in wiki is a separate repository. |
| D6 | GitHub Actions runs `mvn -B verify` on pull requests and on pushes to `main`. Actions used: `actions/checkout@v6` and `actions/setup-java@v5`. | Those were the versions in the Eclipse Temurin guide when we checked. Newer majors may exist. |
| D7 | Pull requests with a merge commit, one approval, CI must pass | Keeps every commit visible and gives each change a second pair of eyes. |
| D8 | No licence file yet | A public repository without a licence is not open for reuse. The owner will choose one. |
