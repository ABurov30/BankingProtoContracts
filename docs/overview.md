# Repository Overview

`Contracts` is the shared contract artifact for the banking microservices
project. It contains protobuf definitions, generated gRPC Java stubs, generated
protobuf message classes, and shared Java enum constants.

## Artifact

| Property | Value |
| --- | --- |
| Group ID | `com.burov` |
| Artifact ID | `contracts` |
| Current version | `0.0.15` |
| Packaging | `jar` |
| Java release | `17` |

## Build Stack

| Dependency | Version |
| --- | --- |
| Protobuf | `4.31.1` |
| gRPC Java | `1.73.0` |
| Checkstyle | `13.6.0` |

## Layout

| Path | Purpose |
| --- | --- |
| `src/main/proto` | Public protobuf and gRPC contracts. |
| `src/main/java/enums` | Shared enum constants used by service implementations. |
| `config/checkstyle` | Checkstyle configuration used by Maven. |
| `target` | Generated and compiled build output. Do not edit manually. |

## Generated Packages

Each proto file uses a domain package such as `auth.v1` and a Java package in
the `*.contract.v1` format, for example `auth.contract.v1`.

The proto APIs currently represent enum-like values such as `role`, `status`,
`currency`, and `type` as strings. Keep those accepted string values aligned with
the Java enums under `src/main/java/enums`.
