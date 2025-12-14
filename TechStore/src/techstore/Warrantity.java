/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package techstore;

/**
 *
 * @author Beyza
 */
public interface Warrantity {
    public static final int STANDART_PERİOD1=12;  // the value for tablet
    public static final int STANDART_PERİOD2=36;  // the value for laptop
    public static final int STANDART_PERİOD3=24;  // the value for smartphone
    public abstract void warrantityPeriod(int period);
}
