# Repository Overview

`Contracts` is the shared contract artifact for the banking microservices
project. It contains protobuf definitions, generated gRPC Java stubs, generated
protobuf message classes, and Maven publishing configuration.

## Artifact

| Property | Value |
| --- | --- |
| Group ID | `com.burov` |
| Artifact ID | `contracts` |
| Current version | `0.0.23` |
| Packaging | `jar` |
| Java release | `17` |

## Build Stack

| Dependency | Version |
| --- | --- |
| Protobuf | `4.31.1` |
| gRPC Java | `1.73.0` |
| Checkstyle | `12.3.1` |

## Layout

| Path | Purpose |
| --- | --- |
| `src/main/proto` | Public protobuf and gRPC contracts. |
| `config/checkstyle` | Checkstyle configuration used by Maven. |
| `.github/workflows/ci.yml` | Runs `mvn --batch-mode verify` for pushes and pull requests to `main`. |
| `.github/workflows/publish.yml` | Publishes the Maven package on GitHub release creation or manual dispatch. |
| `target` | Generated and compiled build output. Do not edit manually. |

## Generated Packages

Each proto file uses a domain package such as `auth.v1` and a Java package in
the `*.contract.v1` format, for example `auth.contract.v1`.

The proto APIs currently represent enum-like values such as `role`, `status`,
`currency`, `type`, and social login `provider` as strings. Keep accepted
values aligned across the producing and consuming services, and update
[contracts.md](contracts.md) when those accepted values change.
