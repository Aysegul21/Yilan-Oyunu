package yilanoyunu;
import java.util.Random;
public class Yilan {
 
 Random random= new Random();
 public Node head;
 public Node tail;
 public Node tmp;
 public int matrisBoyutu;
 public int dugumSayisi = 0;
 public int yazilacakDugum = 0;
 public int x = -1;
 public int y = -1;
 public int GameOver = 1;
 public Yilan(int boyut){
 matrisBoyutu = boyut;
 }
 
 //Oyun basladiginda 5 eleman bastan ekleme
 public void sonaekle(Node n){
 dugumSayisi ++;
 if(head == null){
 head = n;
 tail = n;
 head.yonX = random.nextInt(matrisBoyutu/2);
 head.yonY = random.nextInt(matrisBoyutu/2);
 }else{
 tail.next = n;
 tail.next.yonX = tail.yonX;
 tail.next.yonY = tail.yonY +1;
 tail = n;
 }
 }
 //Yemek yedikten sonra yeni bogum ekleme
 public void sonaekle2(Node n){
 dugumSayisi ++; 
 
 tail.next = n;
 tail.next.yonX = x;
 tail.next.yonY = y;
 tail = n; 
 }
 
 public void yukari(){
 x = head.yonX;
 y = head.yonY;
 
 if(head.yonX == 0){
 head.yonX = matrisBoyutu - 1;
 }else{ 
 head.yonX --;
 }
 
 }
 
 public void asagi(){
 
 x = head.yonX;
 y = head.yonY;
 
 if(head.yonX == matrisBoyutu -1){
 head.yonX = 0;
 }else{
 
 head.yonX ++;
 }
 
 }
 
 public void sag(){
 
 x = head.yonX;
 y = head.yonY;
 
 if(head.yonY == matrisBoyutu -1){
 head.yonY = 0;
 
 }else{
 
 head.yonY ++;
 } 
 }
 
 public void sol(){
 
 x = head.yonX;
 y = head.yonY;
 
 if(head.yonY == 0){
 head.yonY = matrisBoyutu -1;
 }else{ 
 head.yonY --;
 } 
 }
 
 //Yilanin basi bir baska boguma carpmasi durumunu kontrol etme
 public void oyunBitirme(char tercih){
 Node gecici = head;
 while(gecici.next != null){
 if(tercih == 'w'){
 if((gecici.next.yonX == head.yonX - 1) && (gecici.next.yonY == head.yonY)){
 GameOver = 0;
 }
 }else if(tercih == 'a'){
 if((gecici.next.yonX == head.yonX) && (gecici.next.yonY == head.yonY -1)){
 GameOver = 0;
 }
 }else if(tercih == 's'){
 if((gecici.next.yonX == head.yonX + 1) && (gecici.next.yonY == head.yonY)){
 GameOver = 0; 
 }
 }else if(tercih == 'd'){
 if((gecici.next.yonX == head.yonX) && (gecici.next.yonY == 1 + head.yonY)){
 GameOver = 0;
 }
 }
 gecici = gecici.next;
 }
 }
 
 //Kullanicinin tercih ettigi yone gore yilanin basi haric kalan bogumlari duzenleme
 public void kalanElemanlariDuzenle(){
 
 Node gecici = head;
 int yeniX = x;
 int yeniY = y;
 
 while(gecici.next != null){
 
 yeniX = gecici.next.yonX;
 yeniY = gecici.next.yonY;
 
 gecici.next.yonX = x;
 gecici.next.yonY = y;
 
 x = yeniX;
 y = yeniY;
 
 gecici = gecici.next;
 }
 }
 
 //3 defa bomba uzerinden gecme durumunda 3. elemani silme
 public void elemanSil(){
 if(head.next.next.next == null){
 GameOver = 0;
 }else{
 Node gecici = head.next.next;
 Node gecici2 = head.next;
 while(gecici.next != null && gecici2.next != null){
 gecici2.next = gecici.next;
 gecici = gecici.next;
 gecici2 = gecici2.next;
 }
 }
 }
 
 
 public void baslangicKonumunuAyarla(){
 tmp = head;
 }
 
 public void tmpNext(){ 
 if(tmp.next != null){
 tmp = tmp.next;
 }
 }
}