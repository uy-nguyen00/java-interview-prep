# Basic questions

## 1. What is CI/CD? Why important?

**What is CI/CD?**

- Continuous Integration and Continuous Delivery/Deployment.
- **CI**: When code merged &rarr; Automatic builds + tests &rarr; Detect early issues
- **CDelivery**:
  - Ensure code in deployable state.
  - Manual approval for deployment.
- **CDeployment**:
  - Auto deploy code to production / staging.

**Why important?**

- Software stability.
- Accelerate realease cycles + reduce manual effort.
- Enhance collaboration dev <> oprations teams.
- Faster feedback loops.
- Quicker time-to-market.

## 2. Differences between CDelivery and CDeployment?

- **CDelivery**:
  - Code tested, prepared for deployment.
  - Manual approval for deployment.
- **CDeployment**:
  - Code tested.
  - Auto deploy.

## 3. Jenkins, GitlabCI, Github Actions?

- **Jenkins**:
  - Standalone automation server.
  - Highly customizable.
  - Vast plugin ecosystem.
  - Require more maintenance.
  - Use Jenkinsfile (Groovy script).

- **GitlabCI**:
  - Integrated with Gitlab.
  - Easy to setup.
  - Support Docker + K8s.
  - Use YAML file.

- **Github Actions**:
  - Github native.
  - Easy to setup.
  - Marketplace with reusable "actions" created by community and vendors.
  - Use YAML files.

## 4. How Jenkins works? Key features?

- Jenkins is an open-source automation server for automatic CI/CD pipelines.

**HOW IT WORKS?**

- Code pushed to git.
- Jenkins detect changes &rarr; triggers build.
- Runs auto tests + generates build artifact.
- If tests passed &rarr; code deployed.

**KEY FEATURES:**

- Plugin ecosystem.
- Supports declarative + scripted pipelines.
- Integrates with almost everything (plugins required).

## 5. CI/CD pipeline from scratch?

**I. Code Commit**: Code pushed to git.

**II. Build**: Compile code + resolve dependencies.

**III. Test**: Unit tests, Integration tests, E2E tests.

**IV. Static Analysis**: Code quality checks (SonarQube).

**V. Artifact Creation**: Generate deployable artifacts (Docker Images).

**VI. Deployement**: Staging / Prod envs.

**VII. Monitoring**: Monitor the app & pipeline performance.

**Tools used**:

- Jenkins - orchestration
- Docker - containerization
- K8s - deployment

## 6. Environment-specific configurations?

- Use env. variables for different env. (dev, staging, prod).
- Store sensitive data (API keys, secret keys) in vault (secret manager, HashiCorp Vault).
- Config files with placeholders (`$...`).
- Helm (K8s) for env-specific values.

## 7. Types of tests in CI/CD pipeline?

- **Unit tests**: Test individual components (functions, classes) - after build. [JUnit]
- **Integration tests**: Test interactions between components - after build. [@SpringBootTest]
- **Static tests**: Code quality & Find defects without executing.
- **E2E tests**: Simulate user interactions - staging env. [Selenium]
- **Load tests**: Simulate high-trafic to test performance. [JMeter]
- **Security tests**: App dependencies.
- **Smoke tests (part of E2E)**: Check if app can start & core functionalities work.

## 8. How to deal with flaky tests?

- **Detect**: Use test reporting tools to detect.
- **Isolate**: Run flaky tests separately.
- **Retry**: Auto retries.
- **Adjust**: Wait time for async calls.
- **Monitor**: Monitor test stability.

## 9. Security in CI/CD pipeline?

- **Secret management**.
- **Static code analysis**: Scan code for vulnerabilities (SonarQube).
- **Dependency scanning**.
- **Role-based access control (RBAC)**: Restrict access to pipeline configs.
- **Immutable Infrastructure**: Containers &rarr; reduce attacks.

## 10. Blue-Green Deployment?

**I. 2 identical environments**: Blue(current) + Green(new).

**II. New version &rarr; Green**.

**III. Test Green**.

**IV. Switch traffic from Blue &rarr; Green**.

**V. If issues, rollback by switching to Blue**.

**BENEFITS**:

- Zero downtime.
- Easy rollback.
- Reduce risk.

## 10. Monitor + troubleshoot CI/CD pipelines?

- **Logging**: Use logging tools ELK (ElasticSearch, Logstash, Kibana).
- **Metrics**: Prometheus, Grafana &rarr; pipeline performance.
- **Alerts**: For pipeline failures (PagerDuty, Opsgenie).

**STEPS**:

- Check logs.
- Verify config files + env. files.
- Test individual pipeline stages.
- Use debug tools / Rerun failed stages.
