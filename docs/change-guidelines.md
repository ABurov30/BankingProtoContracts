# Change Guidelines

Contract changes affect every service that depends on the `contracts` artifact.
Use additive, backward-compatible changes whenever possible.

## Protobuf Compatibility

- Do not change existing field numbers.
- Do not reuse a field number for a different meaning.
- Do not rename packages without migrating every consumer.
- Do not change request or response message names unless consumers are migrated.
- Add new fields with new field numbers.
- Add new RPCs instead of changing the behavior of existing RPCs in incompatible ways.
- When removing a field, reserve both the field number and the field name.

Example:

```proto
message ExampleResponse {
  reserved 3;
  reserved "oldField";

  string id = 1;
  string name = 2;
}
```

## Enum-Like Values

Proto fields currently represent values such as `role`, `status`, `currency`,
and `type` as strings. Keep the accepted string values aligned with the Java enum
constants in `src/main/java/enums`.

When adding or renaming an enum value:

1. Update the Java enum.
2. Update the service validation that accepts the string value.
3. Update [contracts.md](contracts.md).
4. Rebuild the artifact.

## Update Checklist

1. Change the relevant `.proto` file or Java enum.
2. Update documentation in `docs/`.
3. Update `pom.xml` version when preparing a release for downstream services.
4. Run `mvn clean install`.
5. Publish with `mvn deploy` when the artifact must be shared through GitHub Packages.
6. Update downstream services to the new dependency version.

## Review Checklist

- Field numbers are stable.
- Removed fields are reserved.
- Imports are still valid.
- Java packages still follow `*.contract.v1`.
- README dependency example matches `pom.xml`.
- Consumer services have a planned version update.
