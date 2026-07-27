# Contracts

Shared gRPC/protobuf contracts for the banking microservices project.

The package contains `.proto` files and generates Java classes for service stubs,
requests, and responses.

## Modules

Contracts are stored in `src/main/proto`:

- `auth.proto` - authentication, signup, tokens, roles, password changes.
- `user.proto` - user profile data.
- `account.proto` - bank accounts.
- `card.proto` - cards and card limits.
- `transaction.proto` - transaction service contract.
- `notification.proto` - notification service contract.

Generated Java packages use the `*.contract.v1` naming convention, for example
`auth.contract.v1` and `account.contract.v1`.

## Build

```bash
./mvnw clean install
```

If Maven Wrapper is not available:

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
    <version>0.0.4</version>
</dependency>
```

## Publishing

The package is configured for GitHub Packages:

```bash
mvn deploy
```

Publishing requires Maven credentials for the `github` repository id.

## Updating Contracts

1. Edit the required `.proto` file in `src/main/proto`.
2. Run `./mvnw clean install`.
3. Update dependent services to the new package version.

Keep field numbers stable once a contract is used by other services.
