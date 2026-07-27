# Contracts

Shared protobuf contracts for banking microservices.

## Build

```bash
./mvnw clean install
```

If Maven Wrapper is not available:

```bash
mvn clean install
```

## Protobuf response: tokens or empty

If an RPC response can contain either auth tokens or an empty successful result, model it with `oneof`.

```proto
message VerifyUserGrpcResponse {
  oneof result {
    AuthTokenResponse tokens = 1;
    VerifyUserEmptyResponse empty = 2;
  }
}

message VerifyUserEmptyResponse {}
```

Java usage:

```java
switch (response.getResultCase()) {
    case TOKENS -> {
        AuthTokenResponse tokens = response.getTokens();
    }
    case EMPTY -> {
        // Success without payload.
    }
    case RESULT_NOT_SET -> {
        // No result was set.
    }
}
```

For a simpler contract, leave only the optional message field and treat missing tokens as an empty result.

```proto
message VerifyUserGrpcResponse {
  AuthTokenResponse tokens = 1;
}
```

Java usage:

```java
if (response.hasTokens()) {
    AuthTokenResponse tokens = response.getTokens();
} else {
    // Empty result.
}
```

Use `oneof` when the contract must explicitly say "tokens or empty". Use `hasTokens()` when the absence of tokens is enough for the business logic.
