# Contract Catalog

Contracts are stored in `src/main/proto`. The generated Java API uses the
`*.contract.v1` package convention.

## Auth

| Property | Value |
| --- | --- |
| Proto file | `src/main/proto/auth.proto` |
| Proto package | `auth.v1` |
| Java package | `auth.contract.v1` |
| Service | `AuthRpcService` |

RPCs:

- `GetAuthHealth`
- `Login`
- `Signup`
- `Logout`
- `Refresh`
- `ChangePassword`
- `BlockAuthUser`
- `UnlockAuthUser`
- `VerifyAuthUserByCode`
- `VerifyAuthUserByPrivilegeRole`
- `ChangeAuthUserRole`
- `GetAuthUserById`
- `ForgetPassword`
- `ResetPassword`

Related enums:

- `enums.auth.Roles`: `USER`, `MANAGER`, `ADMIN`
- `enums.auth.AuthUserStatus`: `ACTIVE`, `BLOCKED`, `PENDING`, `FORGET_PASSWORD`

## User

| Property | Value |
| --- | --- |
| Proto file | `src/main/proto/user.proto` |
| Proto package | `user.v1` |
| Java package | `user.contract.v1` |
| Service | `UserRpcService` |

RPCs:

- `GetUserHealth`
- `GetUserInfo`
- `GetAllUserInfo`
- `GetUserInfoByEmail`

Related enums:

- `enums.user.UserProfileStatus`: `ACTIVE`, `BLOCKED`, `PENDING`

## Account

| Property | Value |
| --- | --- |
| Proto file | `src/main/proto/account.proto` |
| Proto package | `account.v1` |
| Java package | `account.contract.v1` |
| Service | `AccountRpcService` |

RPCs:

- `GetAccountHealth`
- `CreateAccount`
- `GetAccountsByOwnerUserId`
- `GetAllAccounts`
- `FreezeAccount`
- `UnfreezeAccount`
- `GetAccountById`
- `TopUpAccount`
- `WithdrawAccount`
- `ReserveFundsForTransaction`

Related enums:

- `enums.account.AccountStatus`: `ACTIVE`, `FROZEN`, `CLOSED`
- `enums.account.AccountType`: `CHECKING`, `SAVINGS`
- `enums.common.Currency`: `USD`, `EUR`, `CNY`, `GBP`
- `enums.account.ReservationStatus`: `RESERVED`, `RELEASED`, `RELEASED_BY_TIME`, `COMPENSATED`, `FAILED`

## Card

| Property | Value |
| --- | --- |
| Proto file | `src/main/proto/card.proto` |
| Proto package | `card.v1` |
| Java package | `card.contract.v1` |
| Service | `CardRpcService` |

RPCs:

- `GetCardHealth`
- `CreateCard`
- `UpdateCard`
- `GetCardsByAccountId`

Related enums:

- `enums.card.CardStatus`: `ACTIVE`, `BLOCKED`, `FROZEN`, `EXPIRED`

## Transaction

| Property | Value |
| --- | --- |
| Proto file | `src/main/proto/transaction.proto` |
| Proto package | `transaction.v1` |
| Java package | `transaction.contract.v1` |
| Service | `TransactionRpcService` |

`transaction.proto` imports `account.proto` and embeds
`account.v1.AccountResponse` in transaction requests and responses.

RPCs:

- `GetTransactionHealth`
- `CreateTransaction`
- `GetTransactionsByAccounts`

Related enums:

- `enums.transaction.TransactionDirection`: `SENDER`, `RECIPIENT`
- `enums.transaction.TransactionStatus`: `FUNDS_RESERVED`, `FUNDS_REQUESTED`, `COMPLETED`, `FAILED`, `COMPENSATED`

## Notification

| Property | Value |
| --- | --- |
| Proto file | `src/main/proto/notification.proto` |
| Proto package | `notification.v1` |
| Java package | `notification.contract.v1` |
| Service | `NotificationRpcService` |

RPCs:

- `GetNotificationHealth`
