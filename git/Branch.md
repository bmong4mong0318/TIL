# Branch

### create git branch (Local Repository)

```
# make new branch and checkout
git branch {branch name}
git checkout {branch name}

# make new branch and checkout at the same time
git checkout -b {branch name}
```

### create git branch (Remote Repository)
```
git remote add origin {repository address}
git push origin {branch name}
```

### git list lookup

```
git branch  (로컬 브랜치 목록 조회)
git branch -r  (원격 브랜치 목록 조회)
git branch -a  (모든 브랜치 목록 조회)

(master)$ git branch 
* master
  newbranch
  newbranch2

(master)$ git branch -r
  origin/master
  origin/newbranch

(master)$ git branch -a
* master # local branch // checkout 
  newbranch # local branch 
  newbranch2 # local branch
  remotes/origin/master # remote branch
  remotes/origin/newbranch # remote branch
```

### delete git branch
```
git push origin --delete {branch name}
```

### cloning a specific branch
```
git clone -b {branch_name} --single-branch {repository URL}
```
<br> ps. HEAD branch == current branch