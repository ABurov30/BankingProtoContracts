# Build And Publishing

## Prerequisites

- JDK 17.
- Maven available as `mvn`.
- Network access when Maven needs to download dependencies or publish packages.

This repository currently does not include a Maven Wrapper, so examples use the
system Maven command.

## Build Locally

```bash
mvn clean install
```

The build:

- Generates protobuf Java classes.
- Generates gRPC Java stubs.
- Runs Checkstyle during `verify`.
- Installs `com.burov:contracts` into the local Maven repository.

## Consumer Dependency

```xml
<dependency>
    <groupId>com.burov</groupId>
    <artifactId>contracts</artifactId>
    <version>0.0.15</version>
</dependency>
```

Update the version in consuming services after a new artifact version is built
and published.

## Publishing

The Maven project is configured to publish to GitHub Packages:

```bash
mvn deploy
```

Publishing uses the `github` repository id from `distributionManagement`.
Credentials must be configured in Maven settings for that repository id before
running deploy.

## Generated Output

Generated sources and compiled output are written under `target/`. Do not edit or
commit manual changes there.
