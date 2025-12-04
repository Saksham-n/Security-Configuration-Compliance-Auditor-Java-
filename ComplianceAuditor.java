import java.io.File;
import java.util.Scanner;

public class ComplianceAuditor {

    public static void main(String[] args) {
        System.out.println("Starting Automated Compliance Audit...");
        System.out.println("Standard: ISO 27001 & Flipkart Security Policy\n");

        try {
            File file = new File("config.json");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("serverId")) {
                    auditServer(scanner);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading config file: " + e.getMessage());
        }
    }

    private static void auditServer(Scanner scanner) {
        String serverId = "";
        boolean isEncrypted = false;
        boolean publicAccess = false;
        
        // Regex parsing
        serverId = scanner.nextLine().split(":")[1].replace("\"", "").replace(",", "").trim();
        isEncrypted = scanner.nextLine().contains("true");
        publicAccess = scanner.nextLine().contains("true");
        
        System.out.println("--- Auditing Asset: " + serverId + " ---");
        int score = 100;

        //  Encryption (ISO 27001)
        if (!isEncrypted) {
            System.out.println("[FAIL] VIOLATION: Data at Rest is not encrypted.");
            System.out.println("       -> Risk: High (Data Leakage)");
            score -= 40;
        }

        //  Public Access (NIST CSF: Protect - Access Control)
        if (publicAccess) {
            System.out.println("[FAIL] VIOLATION: Server is accessible to Public Internet.");
            System.out.println("       -> Risk: Critical (Unauthorized Access)");
            score -= 50;
        }

        System.out.println("COMPLIANCE SCORE: " + score + "/100");
        if (score < 50) System.out.println("STATUS: NON-COMPLIANT (Immediate Action Required)");
        else System.out.println("STATUS: COMPLIANT");
        System.out.println();
    }
}