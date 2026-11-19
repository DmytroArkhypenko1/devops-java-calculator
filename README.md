# Java Calculator - DevOps Project

## Contact

- **Maintainer:** [DmytroArkhypenko1](https://github.com/DmytroArkhypenko1)
- **Email:** L00194711@atu.ie
- **Availability:** Mon-Fri 10am-9pm (GMT+0)

Use GitHub Issues for project tasks, ordinary bug reports and feature requests. Use email for direct enquiries or information that should not be posted publicly.

## Overview

A planned Spring Boot web calculator supporting addition, subtraction, multiplication and division.

This project will demonstrate GitHub project planning, feature branches, pull requests, automated testing and continuous integration.

**Current status: initial setup.** Application functionality, tests and CI will be added through the project backlog. This README will be updated as the implementation progresses.

## Planned features

- Four arithmetic operations with whole and decimal numbers.
- A web interface built with Thymeleaf.
- Server-side validation of missing, invalid and non-finite input.
- Division-by-zero and arithmetic overflow messages.
- Preservation of submitted values and the selected operation.
- Unit tests, HTTP validation tests and an explicit JUnit test suite.
- Automated build and test execution through GitHub Actions.

The calculator will use Java `double` arithmetic. Some decimal values cannot be represented exactly, so small rounding differences are expected.

## Planned technology

- Java 21
- Spring Boot 3.5.6
- Maven
- Spring MVC
- Thymeleaf
- JUnit Jupiter and JUnit Platform Suite
- Spring MockMvc
- GitHub Actions

## Prerequisites

Install JDK 21, Maven and Git.

Verify the installation:

```shell
java -version
javac -version
mvn -version
git --version
```

Both Java and Maven should use JDK 21. Set `JAVA_HOME` to the JDK installation if Maven uses a different Java version.

## Get the project

```shell
git clone https://github.com/DmytroArkhypenko1/devops-java-calculator devops-java-calculator
cd devops-java-calculator
```

Development work will be integrated into `dev`. Reviewed releases will be merged into `main` through a separate pull request.

## Build, run and test

Build and startup instructions will be added after the initial Maven application is implemented and verified.

Test commands and browser usage examples will be documented as the corresponding features become available.

## Testing and continuous integration

Tests will be added alongside the arithmetic and web functionality. Planned coverage includes:

- Positive, negative, zero and decimal operands.
- Division by zero and floating-point overflow behavior.
- Controller operation selection and model attributes.
- Missing or invalid HTTP parameters.
- Rendered error messages and escaped input.

An explicit JUnit suite will group the test classes.

GitHub Actions will be configured to build and test pull requests targeting `dev` and `main`, and pushes to those branches. The workflow will use Java 21 and Maven. Its configuration and verified commands will be documented when CI is implemented.

## Branching strategy

| Branch | Purpose |
|---|---|
| `main` | Default branch for stable releases |
| `dev` | Integration of completed development work |
| `feature/*` | Work on an individual Issue |

The development flow is:

```text
feature branches -> dev -> main
```

For each implementation task:

1. Select the Issue and move it from **Todo** to **In Progress**.
2. Update the local `dev` branch.
3. Create the Issue's feature branch from `dev`.
4. Implement the change and run the relevant tests.
5. Commit with the Issue number and push the feature branch.
6. Open a pull request targeting `dev` and reference the Issue.
7. Review the diff and validation results. Once CI is configured, confirm the latest checks pass.
8. Merge the PR into `dev` using **Create a merge commit**.
9. Verify the integrated work and move the Issue to **Ready for release**.

New tasks start from the latest `dev`:

```shell
git switch dev
git pull --ff-only origin dev
git switch -c feature/example-task
```

After the initial repository bootstrap, changes are submitted through PRs rather than direct development pushes to `dev` or `main`.

A release PR merges `dev` into `main` using **Create a merge commit**, preserving the original commits and their Issue references.

## Commit messages and Issue references

Every development commit must reference its related Issue.

Use `Refs` while work is ongoing:

```text
feat: add multiplication method (Refs #4)
```

Use `Closes` when the implementation and its required verification are complete:

```text
feat: complete multiplication with tests (Closes #4)
```

The number above is an example; use the actual GitHub Issue number.

With `main` as the default branch, a closing commit does not close an Issue while it is only on a feature branch or `dev`. GitHub closes the Issue when that commit reaches `main`.

PR descriptions must also include the related Issue, a summary of the changes and actual validation results.

The release Issue uses `Refs` and remains open until post-merge checks, tagging and publication are complete.

## Project planning

[Open the GitHub Project board](https://github.com/users/DmytroArkhypenko1/projects/2).

The initial backlog is organised into ten Issues covering project setup, arithmetic operations, the controller, the interface, validation, the test suite and CI, documentation, and release.

Each Issue includes a description, tasks, acceptance criteria, Definition of Ready and Definition of Done, together with an assignee, labels, milestone and sprint.

| Milestone | Scope |
|---|---|
| M1 - Calculator operations | Project setup and four arithmetic operations |
| M2 - Working web calculator | Controller, interface and validation |
| M3 - Tested and documented release | Test suite, CI, documentation and release |

- **Sprint 1:** Project setup and operations.
- **Sprint 2:** Web interface and release.
- **Statuses:** Todo -> In Progress -> Ready for release -> Done.

Issues are moved to **Ready for release** after their verified changes are merged into `dev`. The Project's **Item closed** workflow should be configured to move closed Issues to **Done**.

## Planned release

The first planned release is `v1.0.0`.

Before publishing, the integrated application will be checked through automated tests and browser verification. The release PR will merge `dev` into `main`, followed by verification of CI on `main`, creation of the release tag and publication of release notes.

## Documentation and security

The README will be updated throughout development with verified build instructions, usage examples, test commands, repository structure and troubleshooting guidance.

A `SECURITY.md` file will be added with supported-version and vulnerability-reporting information. A link will be included here once the policy is available.
