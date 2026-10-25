# Contributing

There are two of us, so the rules are short.

## Workflow

1. Start from an up to date `main`: `git switch main` then `git pull`.
2. Create a branch named after the change: `feature/create-listing`, `fix/window-check`, `docs/setup-guide` or `test/reserve-rules`.
3. Make small commits. Each one is a real change that builds on its own.
4. Push the branch and open a pull request. Fill in the template.
5. Wait for CI to be green and for the other person to review.
6. Merge with **Create a merge commit**, so every commit stays visible in the history, then delete the branch.

Nobody pushes straight to `main`.

## Commit messages

Use the form `type(scope): what changed`.

| Type | Use it for |
|------|-----------|
| `feat` | a new feature |
| `fix` | a bug fix |
| `test` | adding or changing tests |
| `docs` | documentation only |
| `ci` | the pipeline |
| `chore` | build files and other housekeeping |

Example: `feat(listings): reject a reservation after the pickup window closes`

Commit when there is a real change. Empty or padding commits make the history harder to read, so we do not make them.

## Reviews

* Read the change, run it if you can, and leave comments that explain why.
* Approve only when you understand the change and CI is green.
* Review within a day where possible, so nobody is blocked.

## Before you push

```
mvn -B verify
```

## Repository settings (set once by the repo owner)

Settings, Branches, add a rule for `main`:

* Require a pull request before merging, with 1 approval
* Require status checks to pass before merging, and choose the `build` check (it appears after the first workflow run)
* Block force pushes
