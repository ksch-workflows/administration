# Registration Desk

The web application to be used at the registration desk.

## Getting Started

This project is a starting point for a Flutter application.

A few resources to get you started if this is your first Flutter project:

- [Lab: Write your first Flutter app](https://flutter.dev/docs/get-started/codelab)
- [Cookbook: Useful Flutter samples](https://flutter.dev/docs/cookbook)

For help getting started with Flutter, view our
[online documentation](https://flutter.dev/docs), which offers tutorials,
samples, guidance on mobile development, and a full API reference.

## Maintenance

### SonarCube analysis

```
docker run --env ES_JAVA_OPTS="-Xms1024m -Xmx1024m" -d -p 9000:9000 -p 9092:9092 \
  experimentalsoftware/sonarqube-dart:0.1
sonar-scanner -Dsonar.login=$SONAR_LOGIN -Dsonar.password=$SONAR_PASSWORD
ccsh sonarimport http://localhost:9000 registration_desk > /tmp/sonar.json
```