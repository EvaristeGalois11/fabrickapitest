[![Build](https://github.com/EvaristeGalois11/fabrickapitest/actions/workflows/build.yml/badge.svg)](https://github.com/EvaristeGalois11/fabrickapitest/actions/workflows/build.yml)
[![Deploy](https://github.com/EvaristeGalois11/fabrickapitest/actions/workflows/deploy.yml/badge.svg)](https://github.com/EvaristeGalois11/fabrickapitest/actions/workflows/deploy.yml)
[![Sonar](https://github.com/EvaristeGalois11/fabrickapitest/actions/workflows/sonar.yml/badge.svg)](https://github.com/EvaristeGalois11/fabrickapitest/actions/workflows/sonar.yml)
[![CodeQL](https://github.com/EvaristeGalois11/fabrickapitest/actions/workflows/codeql.yml/badge.svg)](https://github.com/EvaristeGalois11/fabrickapitest/actions/workflows/codeql.yml)

# fabrickapitest
Just a simple demo project to test some fabrick apis

### Build from source
`./mvnw verify`

**_The project needs Java 21 to compile_**

### Run with podman
`podman run -d -p 8080:8080 ghcr.io/evaristegalois11/fabrickapitest`

The application uses h2 as its database by default.
Postgres and Oracle are also supported: pass the jdbc url with the environment variable `SPRING_DATASOURCE_URL` (username and password are `fabrickapitest`).

### Usage
Head over to `http://localhost:8080/swagger-ui/index.html` to make use of the embedded swagger or just use `curl` to query the application directly.

