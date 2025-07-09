package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para generar hashes SHA-1 y MD5 de las contraseñas
 */
public class hash {
    
    // ─── Constructor ────────────────────────────────────
    public hash() {
    }
    
    // ─── Método para generar hash SHA-1 ─────────────────
    public String sha1(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al generar hash SHA-1: " + e.getMessage());
            return null;
        }
    }
    
    // ─── Método para generar hash MD5 ──────────────────
    public String md5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al generar hash MD5: " + e.getMessage());
            return null;
        }
    }
    
    // ─── Método para generar hash SHA-256 (más seguro) ──
    public String sha256(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al generar hash SHA-256: " + e.getMessage());
            return null;
        }
    }
    
    // ─── Método para verificar contraseña ──────────────
    public boolean verificarPassword(String passwordOriginal, String hashAlmacenado, String algoritmo) {
        String hashGenerado = null;
        
        switch (algoritmo.toLowerCase()) {
            case "sha1":
                hashGenerado = sha1(passwordOriginal);
                break;
            case "md5":
                hashGenerado = md5(passwordOriginal);
                break;
            case "sha256":
                hashGenerado = sha256(passwordOriginal);
                break;
            default:
                System.err.println("Algoritmo no soportado: " + algoritmo);
                return false;
        }
        
        return hashGenerado != null && hashGenerado.equals(hashAlmacenado);
    }
}