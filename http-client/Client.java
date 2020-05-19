
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;

//run with:
//java -Djavax.net.ssl.keyStore=$HOME/dev/srv/nginx-ssl/tmp/keystore.jks Client "https://example.com"
public class Client {
    public static void main(String[] args) throws Exception {
        new Client().process(args[0]);
    }

    public void process(String urlPath) throws Exception {
        URL url = new URL(urlPath);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        printCert(conn);
        printContent(conn);
    }

    private void printContent(HttpsURLConnection c) {
        System.out.println("*** Contents ***");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()))) {
            //BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                System.out.println(input);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void printCert(HttpsURLConnection c) throws Exception {
        System.out.println("*** Cert ***");
        System.out.println("Response Code : " + c.getResponseCode());
        System.out.println("Cipher Suite : "  + c.getCipherSuite());

        Certificate[] certs = c.getServerCertificates();
        for(Certificate cert : certs){
           System.out.println("* Type: " + cert.getType());
           System.out.println("* Hash: " + cert.hashCode());
           System.out.println("* Public Key Algorithm: "
                                        + cert.getPublicKey().getAlgorithm());
           System.out.println("* Public Key Format : "
                                        + cert.getPublicKey().getFormat());
        }
        System.out.println("*** /Cert ***");
    }
}

