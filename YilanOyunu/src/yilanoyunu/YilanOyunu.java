package yilanoyunu;
import java.util.Scanner;
public class YilanOyunu {
 public static void main(String[] args) {
 
 Scanner scanner = new Scanner(System.in);
 char yon = ' ';
 System.out.println("Matris tahtasi boyutunu giriniz: ");
 int matrisBoyutu = scanner.nextInt();
 
 MatrisTahtasi matrisTahtasi1 = new MatrisTahtasi(matrisBoyutu);
 matrisTahtasi1.matrisOlustur();
 int secim = 1;
 while(secim == 1){
 System.out.println("Yonu seciniz");
 System.out.println("w: Yukari"
 + "\ns: Asagi"
 + "\na: Sol"
 + "\nd: Sag");
 
 char eskiYon = yon;
 if(matrisTahtasi1.yilan1.head.next.next.next == null){
 secim = 0;
 break;
 }
 yon = scanner.next().charAt(0);
 if((eskiYon == 'w' && yon == 's') || (eskiYon == 's' && yon == 'w')){
 secim = 0;
 }else if((eskiYon == 'a' && yon == 'd') || (eskiYon == 'd' && yon == 'a')){
 secim = 0;
 }
 matrisTahtasi1.yilan1.oyunBitirme(yon);
 if(matrisTahtasi1.yilan1.GameOver == 0){
 secim = 0;
 }
 
 if(secim == 1){
 matrisTahtasi1.getYon(yon);
 matrisTahtasi1.yonuSec();
 matrisTahtasi1.matrisOlustur();
 }
 }
 System.out.println("\nGame Over!!!");
 System.out.println("\n**OYUN TABLOSU**");
 System.out.println("Skorunuz: " + matrisTahtasi1.skor);
 
 }
 
}