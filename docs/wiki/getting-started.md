# Getting started

Run these in Git Bash.

## 1. Git identity

Use the email address that is on your GitHub account, otherwise GitHub will not credit your commits to your profile.

```
git config --global user.name "Your Name"
git config --global user.email "your-email@example.com"
git config --global user.name
git config --global user.email
```

The last two lines should print back what you typed.

## 2. JDK 21

Install a JDK 21 from https://adoptium.net, then close and reopen Git Bash and run:

```
java -version
```

It should report version 21 (a newer version also works).

## 3. Maven

Download the binary zip from https://maven.apache.org/download.cgi, unzip it somewhere like `C:\maven`, and add its `bin` folder to your PATH. Reopen Git Bash and run:

```
mvn -v
```

It should show Maven 3.9 or newer and the Java version from step 2.

## 4. Get the code and check it

```
git clone https://github.com/<owner>/lambs-plate.git
cd lambs-plate
mvn -B verify
```

Replace `<owner>` with the account that owns the repository. The build should end with `BUILD SUCCESS`. The first run downloads libraries and takes a few minutes.

## 5. Run the server

Run `com.lambsplate.App.main` from your IDE, then open http://localhost:7070/health. It should show `ok`.
