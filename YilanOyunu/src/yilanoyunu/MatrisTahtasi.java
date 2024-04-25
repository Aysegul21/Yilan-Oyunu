package yilanoyunu;
import java.util.Random;
public class MatrisTahtasi {
 
 Random random = new Random();
 public int matrisBoyutu;
 public char[][] matrisTahtasi;
 public int x;
 public int y;
 public Yilan yilan1 ;
 public Node n;
 public char yilanYonu;
 public int BombaSayac = 0;
 public char BombaYeri = ' ';
 public int jTut = -1;
 public int iTut = -1;
 public int skor = -30;
 
 public MatrisTahtasi(int boyut ){
 matrisBoyutu = boyut;
 yilan1 = new Yilan(matrisBoyutu);
 for(int i = 0 ; i < 5 ; i++){
 
 if(i == 0){
 n = new Node('☻');
 yilan1.sonaekle(n);
 }else{
 n = new Node('✿');
 yilan1.sonaekle(n);
 }
 
 }
 
 matrisTahtasi = new char[matrisBoyutu][matrisBoyutu];
 x = random.nextInt(matrisBoyutu);
 y = random.nextInt(matrisBoyutu);
 }
 
 public void Yemek(){
 
 int yemekX = random.nextInt(matrisBoyutu);
 int yemekY = random.nextInt(matrisBoyutu);
 int sayac = 0;
 for(int i = 0 ; i < matrisBoyutu ; i++){
 for(int j = 0 ; j < matrisBoyutu ; j++){
 if(matrisTahtasi[i][j] == ' ' && ( yemekX == i) && (yemekY == j)){
 matrisTahtasi[i][j] = '♛';
 sayac = 1;
 break;
 }else{
 yemekX = i;
 yemekY = random.nextInt(matrisBoyutu) + j + 1;
 }
 }
 if(sayac == 1){
 break;
 }
 }
 }
 
 //Bomba ve Yemek matriste bulunmuyorsa matrise bomba ve yemek ekleme
 public void kontrolEt(char aranan){
 int sayac = 0;
 for(int i = 0 ; i < matrisBoyutu ; i++){
 for(int j = 0 ; j < matrisBoyutu ; j++){
 if(matrisTahtasi[i][j] == aranan){
 sayac = 1;
 break;
 }
 }
 if(sayac == 1){
 break;
 }
 }
 if(sayac == 0 && aranan == '♛'){
 
 Yemek();
 skor += 30;
 }else if(sayac == 0 && aranan == '☢' &&(BombaSayac == 3 || BombaSayac == 0)){
 Bomba();
 }
 }
 
 public void Bomba(){
 
 int BombaX = random.nextInt(matrisBoyutu);
 int BombaY = random.nextInt(matrisBoyutu);
 int sayac = 0;
 for(int i = 0 ; i < matrisBoyutu ; i++){
 for(int j = 0 ; j < matrisBoyutu ; j++){
 if(matrisTahtasi[i][j] == ' ' && ( BombaX == i) && (BombaY == j)){
 matrisTahtasi[i][j] = '☢';
 sayac = 1;
 break;
 }else{
 BombaX = i;
BombaY = random.nextInt(matrisBoyutu) + j + 1;
 }
 }
 if(sayac == 1){
 break;
 }
 }
 }
 
 
 public void getYon(char yon){
 yilanYonu = yon;
 }
 
 //girilen yone gore yilani duzenleme
 public void yonuSec(){
 if(yilanYonu == 'w'){
 yilan1.yukari();
 yilan1.kalanElemanlariDuzenle();
 }else if(yilanYonu == 's'){
 yilan1.asagi();
 yilan1.kalanElemanlariDuzenle();
 }else if(yilanYonu == 'a'){
 yilan1.sol();
 yilan1.kalanElemanlariDuzenle();
 }else if(yilanYonu == 'd'){
 yilan1.sag();
 yilan1.kalanElemanlariDuzenle();
 }
 }
 
 public void matrisOlustur(){
 
 yilan1.baslangicKonumunuAyarla();
 int say = 0;
 
 for(int i = 0 ; i < matrisBoyutu ; i++){
 yilan1.baslangicKonumunuAyarla();
 for(int j = 0 ; j < matrisBoyutu ; j++){
 yilan1.baslangicKonumunuAyarla();
 int boslukSayaci = 0;
 
 char gecici = matrisTahtasi[i][j];
 if(gecici == '☢'){
 BombaYeri = '☢'; 
 jTut = j;
 iTut = i;
 }
 
 for(int sayac = 0 ; sayac < yilan1.dugumSayisi ; sayac ++){
 
 if(yilan1.tmp.yonX == i && yilan1.tmp.yonY == j){
 if(jTut == j && iTut == i){
 BombaSayac ++;
 }
 if(BombaSayac == 3){
 BombaSayac = 0;
BombaYeri = ' ';
 yilan1.elemanSil();
 say = 1; 
 
 }
 matrisTahtasi[i][j] = yilan1.tmp.data; 
 
 if(gecici == '♛' && yilan1.head.yonX == i && yilan1.head.yonY == j){
 
 Node n = new Node('✿');
 yilan1.sonaekle2(n); 
 say = 1; 
 }
 boslukSayaci += 1;
 break;
 }
 yilan1.tmpNext();
 }
 
 if(matrisTahtasi[i][j] == '☢' ){ 
 }else if(matrisTahtasi[i][j] == '♛'){
 }else if(boslukSayaci == 0 ){
 matrisTahtasi[i][j] = ' ';
 } 
 }
 }
 
 kontrolEt('♛');
 kontrolEt('☢');
 
 if(say == 1){
 matrisOlustur();
 }else{
 ekranaYaz();
 }
 
 }
 
 public void ekranaYaz(){
 
 for(int i = 0 ; i < matrisBoyutu ; i++){
 System.out.println("\n------------------------------------------");
 for(int j = 0 ; j < matrisBoyutu ; j++){
 if(matrisTahtasi[i][j] != '✿')
 System.out.print(" | " + matrisTahtasi[i][j]);
 else{
 System.out.print(" | " + matrisTahtasi[i][j]);
 }
 }
 System.out.print(" |");
 }
 System.out.println("\n------------------------------------------");
 }
}