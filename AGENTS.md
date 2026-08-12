# Agent Instructions

This file is for coding agents working in the contracts repository.

## Start Here

- Read [README.md](README.md) for the project summary.
- Use [docs/README.md](docs/README.md) as the documentation index.
- Check [docs/contracts.md](docs/contracts.md) before changing proto APIs.
- Check [docs/change-guidelines.md](docs/change-guidelines.md) before editing field numbers, message names, packages, or enums.
- Check [docs/build-and-publish.md](docs/build-and-publish.md) before running release or publishing commands.

## Repository Rules

- Treat `.proto` files in `src/main/proto` as public contracts for other services.
- Do not renumber, reuse, or reorder existing protobuf field numbers.
- Prefer additive contract changes. When removing a field, reserve the field number and name in the proto file.
- Keep `package`, `java_package`, and `java_multiple_files` stable unless all consumers are migrated.
- Do not edit generated files under `target/`.
- Keep Maven dependency versions and README examples aligned with `pom.xml`.
- Keep enum values in `src/main/java/enums` aligned with string values accepted by service contracts.

## Validation

Run this before finishing contract changes when dependencies are available:

```bash
mvn clean install
```

If the command cannot be run, report the reason and the remaining validation risk.

## Documentation Updates

Update the docs in `docs/` when changing:

- A service RPC.
- A request or response message.
- A shared enum value.
- The artifact version or publishing flow.
- Compatibility rules for downstream services.
