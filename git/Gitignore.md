# .gitignore

It should always exist in the `root` directory.

Share code neatly, hide files that need to be hidden!
```
### Ignore all files ending in .exe

- .exe

### Among them, Go.exe is not ignored.

!Go.exe

### Find all test folders throughout the project and ignore them

test/

### Ignore only the test folder that exists at the top of the project

/test
```

If you write it in a folder called .gitignore, you can write the files you do not want to include. For example,

```bash
### VS Code ###
.vscode/
```

It is possible to push to the remote repository except for all sub-files in .vscode!

To apply this to my remote repository,

```bash
### IntelliJ IDEA ###
/.idea
*.iws
*.iml
*.ipr
out/

### VS Code ###
/.vscode
```
