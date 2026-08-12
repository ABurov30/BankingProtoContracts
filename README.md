# Contracts

Shared gRPC/protobuf contracts for the banking microservices project.

This repository publishes the Maven artifact used by the backend services to
share generated gRPC stubs, protobuf messages, and Java enum constants.

## Documentation

- [Documentation index](docs/README.md)
- [Repository overview](docs/overview.md)
- [Contract catalog](docs/contracts.md)
- [Build and publishing](docs/build-and-publish.md)
- [Change guidelines](docs/change-guidelines.md)
- [Agent instructions](AGENTS.md)

## What Is Included

- `src/main/proto` - protobuf service contracts.
- `src/main/java/enums` - shared Java enum constants used by services.
- `config/checkstyle` - Checkstyle rules used during Maven verification.
- `pom.xml` - Maven build, protobuf generation, and GitHub Packages publishing.

Generated Java packages use the `*.contract.v1` naming convention, for example
`auth.contract.v1` and `account.contract.v1`.

## Contract Modules

| File | Java package | Responsibility |
| --- | --- | --- |
| `auth.proto` | `auth.contract.v1` | Authentication, signup, tokens, roles, password changes. |
| `user.proto` | `user.contract.v1` | User profile lookup and listing. |
| `account.proto` | `account.contract.v1` | Accounts, balances, account state, and fund reservation. |
| `card.proto` | `card.contract.v1` | Cards, card status, and card limits. |
| `transaction.proto` | `transaction.contract.v1` | Transaction creation and transaction lookup. |
| `notification.proto` | `notification.contract.v1` | Notification service health contract. |

## Build

This repository currently does not include a Maven Wrapper. Use a local Maven
installation:

```bash
mvn clean install
```

The build generates protobuf and gRPC Java sources and installs the artifact into
the local Maven repository.

## Maven Dependency

```xml
<dependency>
    <groupId>com.burov</groupId>
    <artifactId>contracts</artifactId>
    <version>0.0.15</version>
</dependency>
```

Keep the dependency version in consumer services aligned with the version in
`pom.xml`.

## Updating Contracts

1. Edit the required `.proto` file in `src/main/proto`.
2. Preserve existing field numbers and package names.
3. Update related enum documentation when string enum values change.
4. Run `mvn clean install`.
5. Publish the new artifact when downstream services need the change.
6. Update dependent services to the new package version.

For compatibility details, see [change guidelines](docs/change-guidelines.md).
