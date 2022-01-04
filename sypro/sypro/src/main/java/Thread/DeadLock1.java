/*
 * package Thread; public class DeadLock1 {
 * 
 * 
 * public static void main(String[] args) { Object a = new Object(); Object b =
 * new Object();
 * 
 * System.out.println("a="+a); System.out.println("b="+b);
 * 
 * 
 * new Thread(() -> { while (true) { synchronized (a) { synchronized (b) {
 * System.out.println("线程A"); } } }
 * 
 * 
 * 
 * 
 * }).start();
 * 
 * 
 * new Thread(() -> { while (true) { synchronized (b) { synchronized (a) {
 * System.out.println("线程B"); } } }
 * 
 * 
 * }).start(); } }
 */