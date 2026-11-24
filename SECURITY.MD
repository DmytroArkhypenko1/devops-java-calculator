# Security Policy

## Supported versions

Security fixes are intended for the latest published release. Older releases are not maintained separately; users should update to the latest release.

This is an educational project maintained on a best-effort basis. There is no guaranteed response or remediation timeframe.

## Reporting a vulnerability

Please do not disclose vulnerability details, exploit instructions or sensitive information in a public GitHub Issue or pull request.

If private vulnerability reporting is enabled:

1. Open this repository's Security or Security and quality tab.
2. Select Advisories.
3. Click Report a vulnerability.
4. Submit the report privately.

If this option is unavailable, open an Issue requesting a private reporting channel. Do not include vulnerability details in that public request.

Include the following in the private report:

- Affected release tag or commit.
- A description of the vulnerability and its potential impact.
- Steps to reproduce it using a local test environment.
- Relevant requests, logs or screenshots with sensitive information removed.
- A suggested fix, if available.

Do not include passwords, access tokens or personal data.

## Handling reports

The maintainer will review the report, attempt to reproduce the issue and discuss next steps through the private reporting channel.

Confirmed vulnerabilities may result in a fix and a new release. Public disclosure should be coordinated after a fix or mitigation is available.

## Scope

Reports may concern application code, input handling, rendered output or dependencies.

Ordinary calculation errors and documentation problems can be reported through public GitHub Issues, provided they do not expose a security vulnerability.

Expected floating-point rounding differences are documented limitations rather than security vulnerabilities.

## Deployment considerations

The project is designed for local educational use. Public deployment requires a separate review of the deployment environment and application security.

Passing the automated tests does not constitute a comprehensive security assessment.