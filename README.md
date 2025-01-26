# Dataset

## How to configure Git Hooks

This repository uses Git Hooks to ensure that the data is always clean and up-to-date. To configure the hooks, execute the following command:

1. Set the hooks path to the `.github/hooks` directory:

```bash
git config core.hooksPath .github/hooks
```

2. Make the hooks executable:

```bash
chmod +x .github/hooks/*
```

With these configurations, the hooks will be executed every time you run a Git command.
