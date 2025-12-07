# Git Workflow for Bank Account Management System

This document outlines the Git version control workflow used in the development of the Bank Account Management System project. It follows a feature-branch model to isolate changes for refactoring, exception handling, testing, and other enhancements. This approach ensures controlled integration, reduces risks, and allows for selective application of changes via cherry-picking.

## Workflow Overview

- **Main Branch (`main`)**: Serves as the stable production branch. All merges and pushes to production happen here after reviews and testing.
- **Feature Branches**: Created for specific features or tasks (e.g., refactoring, adding exceptions). Development occurs in isolation, and branches are merged back to `main` once complete.
- **Commit Strategy**: Use meaningful commit messages. Commit frequently for small, atomic changes. Include at least 5 commits showing progress (refactoring, exceptions, testing, merging).
- **Merging and Cherry-Picking**: Merge completed feature branches into `main`. Use cherry-pick to apply specific commits from one branch to another without full merge.
- **Conflict Resolution**: Resolve merge conflicts manually when integrating branches.
- **Pushing to Remote**: Push to GitHub after local verification. The repository is hosted at [https://github.com/gideondakore/BankManagementCleanCodeTestingAndGit](https://github.com/gideondakore/BankManagementCleanCodeTestingAndGit).

## Branches Used

| Branch Name            | Purpose |
|------------------------|---------|
| `main`                | Stable codebase; default branch for releases. |
| `feature/refactor`    | Code refactoring for clean structure, Javadocs, and modular methods. |
| `feature/exceptions`  | Implementing custom exceptions and error handling. |
| `feature/error-handling` | Enhanced validation and try-catch blocks for user inputs. |
| `feature/testing`     | Adding JUnit tests for deposit, withdraw, and transfer methods. |

## Example Git Commands

The following commands illustrate the workflow based on the project's implementation phases:

### Phase 1: Setup and Refactoring
1. `git checkout -b feature/refactor` - Create and switch to refactoring branch.
2. Make changes (e.g., refactor Account and TransactionManager).
3. `git add .` - Stage files.
4. `git commit -m "Refactored AccountManager and TransactionManager"` - Commit changes.

### Phase 2: Exception Handling
1. `git checkout -b feature/exceptions` - Create exceptions branch.
2. Add custom exceptions (e.g., InvalidAmountException).
3. `git add .`
4. `git commit -m "Added custom exceptions and try-catch blocks"`

### Phase 3: Testing and Verification
1. `git checkout -b feature/testing` - Create testing branch.
2. Add JUnit tests.
3. `git add .`
4. `git commit -m "Added unit tests for deposit and withdraw"`
5. `git cherry-pick <refactor-commit-hash>` - Apply specific refactoring commits to testing branch.

### Phase 4: Merge and Documentation
1. `git checkout main` - Switch to main.
2. `git merge feature/exceptions` - Merge exceptions branch (resolve conflicts if any).
3. `git merge feature/testing` - Merge testing branch.
4. `git push origin main` - Push to remote repository.

## Key Commit History

Here is a list of key commits from the repository (as of December 07, 2025). Hashes are abbreviated for brevity:

| Commit Hash | Date          | Message                                      |
|-------------|---------------|----------------------------------------------|
| d6cd58f9   | Dec 6, 2025  | Added test runners                          |
| 1823edf2   | Dec 6, 2025  | Add run test options functionality in app menu |
| 1e763676   | Dec 5, 2025  | Add GitHub workflow                         |
| 0d8e7e06   | Dec 5, 2025  | Merge branch 'feature/testing' to main      |
| 0b6aa93b   | Dec 5, 2025  | Merge branch 'feature/error-handling' to main |
| 51392aef   | Dec 5, 2025  | Added test for withdrawal and deposit       |
| a2dd484c   | Dec 5, 2025  | Cherry pick the commit of removing same code in subclass of Account to the Account parent class to feature/refactor |
| cd70412d   | Dec 5, 2025  | Generated Test for the Account class        |
| 7c737a35   | Dec 5, 2025  | Add javadocs to transaction                 |
| 75ec6d1b   | Dec 5, 2025  | Include javadocs in the Account Management  |
| 73f86dd0   | Dec 5, 2025  | Resolve merge conflict in Withdraw method   |
| 1637e411   | Dec 5, 2025  | Add javadoc to Account and it subclasses    |
| 96af49c5   | Dec 5, 2025  | Update the exit app exit message            |
| a6d5992f   | Dec 5, 2025  | Add ability to generate account statement   |
| bd6afc96   | Dec 5, 2025  | Add manage account option and move create account and view account as sub options and did same to Perform transaction |
| ea26b8ec   | Dec 5, 2025  | Refactor InputValidationHelper util to static |
| 81b669a5   | Dec 4, 2025  | Fully implemented the transfer logic        |
| aba13d92   | Dec 4, 2025  | Add transfer functionality                  |
| 5c9480a1   | Dec 3, 2025  | Did some refactoring                        |
| 818fe31d   | Dec 3, 2025  | Change helpers to utils and seperate displayAccountDetails and displayCustomerDetails into different interfaces |
| 25146efd   | Dec 2, 2025  | Did some cleaning                           |
| bb321813   | Dec 1, 2025  | Added overriding toString() to necessary classes |
| 54fbb0dc   | Dec 1, 2025  | updated the READEME                         |
| 3bc20846   | Nov 30, 2025 | Adding MIT License                          |

## Best Practices Followed
- **Atomic Commits**: Each commit focuses on a single change for easier review and rollback.
- **Branch Isolation**: Features developed in separate branches to avoid interfering with main.
- **Cherry-Picking**: Used to apply tested changes (e.g., refactoring) to other branches selectively.
- **Merge Conflicts**: Resolved by reviewing code differences and ensuring functionality.
- **Documentation**: Workflow documented here, with commit messages providing context.
- **Minimum Commits**: At least 5 commits demonstrate progress across phases.

This workflow aligns with the project requirements for Git integration, ensuring clean, testable, and maintainable code development. For more details, refer to the repository commit history.