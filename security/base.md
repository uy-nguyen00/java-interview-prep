# Basic questions

## I. What are the top vulnerabilities in web applications?

### 1. Broken Access Control

- **Core Failure**: Users act outside permissions.
- **Consequences**: Unauthorized disclosure, modification, destruction of data.
- **Principle Violation**: "Least privileged" + "Deny by default".
- **CORS Misonfigured**: Allow API access from untrusted origins.
- **Force Browsing**: Accessing authenticated / privileged pages without proper rights.

**HOW TO PREVENT?**

- Default deny.
- Logging + Monitoring.
- API rate limiting.
- Short-lived JWTs.
- Token revocation.

### 2. Cryptographic Failures

- **Core Failure**: Fail to protect data **at rest** and **in transit**.
- **Clear text tranmission**
- **Weak algo & protocols**
- **Poor key management**: Default & weak keys + No key rotations + Keys in source code.
- **Information leakage** by error messages.

**HOW TO PREVENT?**

- **Data management**:
  - Classify data
  - Do not store sensitive raw data
- **Encryption**:
  - Encrypt sensitive data **at rest** & **in transit**
- **Improve algorithm**
- **No caching for sensitive data**

### 3. Injection

- **Core Failure**: User-supplied data is sent to an interpreter as part of a command or query.
- **Root Causes**:
  - Missing validation, filtering, sanitization.
  - Dynamic queries.
  - Concatening untrusted data into commands.

**How to prevent?**

- Keep data separate from commands and queries.
- Use prepared statements.
- Use ORM tools.
- Server-side input validation.
- Escape special characters.

### 4. Vulnerable and Outdated Components

- **Lack of Inventory**: Not knowing the versions of all client-side, server-side, and nested dependencies.
- **Outdated Stack**: Using vulnerale, unsupported, outdated software (OS, web server, librairies, frameworks).
- **Poor Security Hygiene**:
  - Not scanning for vulnerabilities regularly.
  - Infrequent / Slow patching cycles (e.g., monthly/quaterly).
- **Integration Issues**: Failing to test compatibility after library updates or patches.
- **Misconfiguration**: Not securing the configurations of 3rd-party components.

**HOW TO PREVENT?**

- **Patch Management Process**:
  - Remove unused/unnecessary dependencies, features, files.
  - Inventory all components and their versions continuously.
  - Monitor vulnerability databases (CVE) for known issues.
- Obtain components from official sources.
