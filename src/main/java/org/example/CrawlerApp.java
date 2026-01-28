package org.example;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class CrawlerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- FastScan: Advanced File Crawler ---");
        System.out.print("Taranacak Klasör Yolu: ");
        String path = scanner.nextLine();

        System.out.print("Aranacak Dosya Uzantısı (örn: .java, .pdf): ");
        String ext = scanner.nextLine();

        FileCrawler crawler = new FileCrawler();
        long startTime = System.currentTimeMillis();

        System.out.println("Tarama başlatıldı...");

        // Yeni ForkJoinPool yapısını çağırıyoruz
        crawler.scanDirectory(new File(path), ext);

        // Artık InterruptedException fırlatmadığı için try-catch'i kaldırdık
        List<String> results = crawler.getResults();
        long endTime = System.currentTimeMillis();

        System.out.println("\n--- TARAMA TAMAMLANDI ---");
        System.out.println("Bulunan Dosya Sayısı: " + results.size());
        System.out.println("Geçen Süre: " + (endTime - startTime) + " ms");

        if (results.size() > 0) {
            System.out.println("\n--- Bulunan Bazı Dosyalar ---");
            results.stream().limit(10).forEach(System.out::println);
        } else {
            System.out.println("Eşleşen dosya bulunamadı. Klasör yolunu veya uzantıyı kontrol et.");
        }
    }
}