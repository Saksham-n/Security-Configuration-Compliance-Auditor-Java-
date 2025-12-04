**# Security-Configuration-Compliance-Auditor-Java

A lightweight Java-based security automation tool that audits server configuration files (JSON format) and checks them against predefined security baselines.  
This project demonstrates how **security control automation** can reduce manual verification effort and improve compliance readiness—directly aligned with ISO 27001 Annex A controls.

 Features
 1. Automated Misconfiguration Detection
The tool scans configuration files and detects issues such as:
- **Unencrypted data storage**
- **Weak password policies**
- **Disabled MFA**
- **Public access enabled**
- **Missing logging/monitoring**
- **Insecure default configurations**
- **Lack of network restrictions**
- **Hardcoded credentials (optional rule)**

These findings simulate real-world risks that appear in vendor assessments, cloud misconfigurations, and internal governance audits.

 ISO 27001 Annex A Control Mapping

| Finding Type                     | ISO 27001 Control Mapping            | Description                               |
|----------------------------------|--------------------------------------|-------------------------------------------|
| Unencrypted storage              | A.10 – Cryptographic Controls        | Ensure encryption in transit & at rest    |
| Weak password policy             | A.9 – Access Control                 | Enforce strong authentication mechanisms  |
| MFA disabled                     | A.9 – User Access Management         | Strengthen access security                |
| Public access enabled            | A.13 – Network Security              | Protect against unauthorized network exposure |
| Missing logs                     | A.12.4 – Logging & Monitoring        | Ensure activity logging and monitoring    |
| Insecure defaults                | A.14 – Secure System Acquisition     | Use secure configurations                 |
| Over-permissive access           | A.9 – Least Privilege                | Restrict access to need-to-know           |
| Missing configuration reviews    | A.12 – Operational Security          | Ensure regular configuration audits       |

This mapping is essential to show how the automated tool supports organizational compliance efforts.

---

##  Output & Reporting

The auditor generates:

- A **compliance score** (0–100)
- A list of detected misconfigurations
- Suggested **remediation steps**
- JSON/console output for easy interpretation

Example Output:
Compliance Score: 72/100
Issues Detected:
StorageEncryption: DISABLED → Enable AES-256 encryption
PasswordMinLength < 12 → Enforce stronger password policy
PublicAccess: TRUE → Restrict via IAM & bucket policie

---


---

##  How to Run

### **Prerequisites**
- Java 8+ installed  
- A configuration file (e.g., `config.json`)

### **Steps**

1. Clone the repository:
2. git clone https://github.com/<your-username>/Compliance-Auditor
3. Navigate to the project:
    cd Compliance-Auditor/src
4. Place your JSON configuration file in the directory, e.g.:
   config.json
5. Compile the Java program:
    javac Auditor.java
6. Run the tool:
     java Auditor config.json


### Example JSON input:
{
"storageEncrypted": false,
"passwordMinLength": 8,
"mfaEnabled": false,
"publicAccess": true,
"loggingEnabled": false
}

This tool demonstrates:
- Security automation 
- Understanding of misconfigurations & risks
- Ability to map findings to ISO 27001 controls
- Knowledge of secure configuration baselines
- Practical GRC engineering mindset



